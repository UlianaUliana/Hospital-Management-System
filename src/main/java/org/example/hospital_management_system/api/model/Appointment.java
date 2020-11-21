package org.example.hospital_management_system.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

import org.joda.time.LocalDate;

@Getter
@Setter
public class Appointment {
  private UUID id;
  private Patient patient;
  private Doctor doctor;
  private LocalDate date;
  private List<Analysis> analyses;
  private String prescriptions;

  public Appointment(Patient patient, Doctor doctor, LocalDate date) {
    id = UUID.randomUUID();
    this.patient = patient;
    this.doctor = doctor;
    this.date = date;
  }

  @Override
  public String toString() {
    return this.id + " " + this.patient + " " + this.doctor + " " + this.date;
  }
}
