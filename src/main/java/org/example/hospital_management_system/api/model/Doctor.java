package org.example.hospital_management_system.api.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "specialty")
    private String specialty;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "doctor_patient",
            joinColumns = { @JoinColumn(name = "doctor_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "patient_id", referencedColumnName = "id") }
    )
    private List<Patient> patients;

    @OneToMany(mappedBy="doctor")
    private List<Appointment> appointments;

    public Doctor() {}

    public Doctor(String firstName, String lastName, String specialty) {
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
