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
public class AddressStatus {

    public static final int DEFAULT_ID = 1;
    @Id
    private int id;
    private Status status;
}
