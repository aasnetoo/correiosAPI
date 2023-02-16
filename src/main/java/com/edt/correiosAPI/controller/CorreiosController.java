package com.edt.correiosAPI.controller;

import com.edt.correiosAPI.exception.NoContentException;
import com.edt.correiosAPI.exception.NotReadyException;
import com.edt.correiosAPI.model.Address;
import com.edt.correiosAPI.service.CorreiosService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CorreiosController {

    @Autowired
    private CorreiosService service;
    @GetMapping("/status")
    public String getStatus(){
        return "Service Status: " + this.service.getStatus();
    }

    @GetMapping("/zipcode/{zipcode}")
    public Address getAddressByZipCode(@PathVariable("zipcode") String zipcode) throws NoContentException, NotReadyException {
        return this.service.getAddressByZipcode(zipcode);

    }
}
