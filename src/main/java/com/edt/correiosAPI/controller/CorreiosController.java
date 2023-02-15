package com.edt.correiosAPI.controller;

import com.edt.correiosAPI.model.Address;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CorreiosController {

    @GetMapping("/status")
    public String getStatus(){
        return "UP";
    }

    @GetMapping("/zipcode/{zipcode}")
    public Address getAddressByZipCode(@PathParam("zipcode") String zipcode) {
        return Address.builder().zipcode(zipcode).build();

    }
}
