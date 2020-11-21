package org.example.hospital_management_system.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Patient {
  private UUID id;
  private String firstName;
  private String lastName;
  private int age;
  private String address;
  private List<Doctor> doctors;
  private List<Appointment> appointments;

  public Patient(String firstName, String lastName, int age, String address) {
    id = UUID.randomUUID();
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