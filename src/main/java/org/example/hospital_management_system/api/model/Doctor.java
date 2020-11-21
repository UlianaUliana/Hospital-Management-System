package org.example.hospital_management_system.api.model;


import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Doctor {
    private UUID id;
    private String firstName;
    private String lastName;
    private String specialty;
    private List<Patient> patients;
    private List<Appointment> appointments;

    public Doctor(String firstName, String lastName, String specialty) {
        id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
    }

    public Doctor(UUID id, String firstName, String lastName, String specialty) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return this.id + " " + this.firstName + " " + this.lastName + " " + this.specialty;
    }
}
