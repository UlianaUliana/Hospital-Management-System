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
@Table(name = "patients")
public class Patient {

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

  @Column(name = "age")
  private int age;

  @Column(name = "address")
  private String address;

  @ManyToMany(mappedBy = "patients")
  private List<Doctor> doctors;

  @OneToMany(mappedBy="patient")
  private List<Appointment> appointments;

  public Patient(String firstName, String lastName, int age, String address) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.address = address;
  }

  public Patient(UUID id, String firstName, String lastName, int age, String address) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.address = address;
  }

  @Override
  public String toString() {
    return this.id + " " + this.firstName + " " + this.lastName + " " + this.age + " " + this.address;
  }
}