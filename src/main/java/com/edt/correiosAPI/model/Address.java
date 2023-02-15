package com.edt.correiosAPI.model;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Builder
@NoArgsConstructor

public class Address {
    private String zipcode;
    private String street;
    private String district;
    private String city;
    private String state;


}
