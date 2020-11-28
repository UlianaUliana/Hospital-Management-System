package org.example.hospital_management_system.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.joda.time.LocalDateTime;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "appointments")
public class Appointment {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
          name = "UUID",
          strategy = "org.hibernate.id.UUIDGenerator"
  )
  @Column(name = "id", updatable = false, nullable = false)
  private UUID id;

  @ManyToOne
  @JoinColumn(name="patient_id", nullable=false)
  private Patient patient;

  @ManyToOne
  @JoinColumn(name="doctor_id", nullable=false)
  private Doctor doctor;

  @Column(name = "date")
  private LocalDateTime date;

  @OneToMany(mappedBy="appointment")
  private List<Analysis> analyses;

  @Column(name = "prescriptions")
  private String prescriptions;

  public Appointment(Patient patient, Doctor doctor, LocalDateTime date) {
    this.patient = patient;
    this.doctor = doctor;
    this.date = date;
  }

  @Override
  public String toString() {
    return this.id + " " + this.patient + " " + this.doctor + " " + this.date;
  }
}
