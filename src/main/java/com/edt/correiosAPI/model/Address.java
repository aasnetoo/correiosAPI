package com.edt.correiosAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
public class Address {

    @Id
    private String zipcode;
    private String street;
    private String district;
    private String city;
    private String state;


}
