package org.example.hospital_management_system.api.model;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Doctor {
    private UUID id;
    private String firstName;
    private String lastName;

    public Doctor(String firstName, String lastName) {
        id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return this.id + " " + this.firstName + " " + this.lastName;
    }
}
