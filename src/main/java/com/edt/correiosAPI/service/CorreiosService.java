package com.edt.correiosAPI.service;

import com.edt.correiosAPI.CorreiosApiApplication;
import com.edt.correiosAPI.exception.NoContentException;
import com.edt.correiosAPI.exception.NotReadyException;
import com.edt.correiosAPI.model.Address;
import com.edt.correiosAPI.model.AdressStatus;
import com.edt.correiosAPI.model.Status;
import com.edt.correiosAPI.repository.AddressRepository;
import com.edt.correiosAPI.repository.AddressStatusRepository;
import com.edt.correiosAPI.repository.SetupRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class CorreiosService {

    private static Logger logger = LoggerFactory.getLogger(CorreiosService.class);

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressStatusRepository addressStatusRepository;

    @Autowired
    private SetupRepository setupRepository;

    @Value("${setup.on.startup}")
    private boolean setupOnStartup;

    @Value("${spring.datasource.url}")
    private String a;

    public Status getStatus() {

        return this.addressStatusRepository.findById(AdressStatus.DEFAULT_ID)
                .orElse(AdressStatus.builder().status(Status.NEED_SETUP).build())
                .getStatus();
    }

    public Address getAddressByZipcode (String zipcode) throws NoContentException, NotReadyException {
        if (!getStatus().equals(Status.READY)){
            throw new NotReadyException();
        }


        return addressRepository.findById(zipcode).orElseThrow(NoContentException::new);


    }

    private void saveStatus(Status status){
        addressStatusRepository.save(AdressStatus.builder().id(AdressStatus.DEFAULT_ID).status(status).build());
    }


    @EventListener(ApplicationStartedEvent.class)
    protected void setupOnStartup() {
        if (setupOnStartup) {
            this.setup();
        }
    }

    public synchronized void setup() {
        logger.info("---" + a);
        logger.info("---");
        logger.info("--- STARTING SETUP");
        logger.info("--- Please wait... This may take a few minutes");
        logger.info("---");
        logger.info("---");

        try {
            if (this.getStatus().equals(Status.NEED_SETUP)) { // If not running, starts it.
                this.saveStatus(Status.SETUP_RUNNING);
                
                this.addressRepository.saveAll(
                        setupRepository.getFromOrigin());

                this.saveStatus(Status.READY);
            }

            logger.info("---");
            logger.info("---");
            logger.info("--- READY TO USE");
            logger.info("--- Good luck my friend :)");
            logger.info("---");
            logger.info("---");
        } catch (Exception exc) {
            logger.error("Error to download/save addresses, closing the application....", exc);
            CorreiosApiApplication.close(999);
        }
    }


}
