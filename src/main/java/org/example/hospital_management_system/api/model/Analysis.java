package org.example.hospital_management_system.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.joda.time.LocalDate;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "analyses")
public class Analysis {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
          name = "UUID",
          strategy = "org.hibernate.id.UUIDGenerator"
  )
  @Column(name = "id", updatable = false, nullable = false)
  private UUID id;

  @Column(name = "date")
  private LocalDate date;

  @Column(name = "laboratory")
  private String laboratory;

  @Column(name = "results")
  private String results;

  @ManyToOne
  @JoinColumn(name="appointment_id", nullable=false)
  private Appointment appointment;

  public Analysis(LocalDate date, String laboratory, String results, Appointment appointment) {
    id = UUID.randomUUID();
    this.date = date;
    this.laboratory = laboratory;
    this.results = results;
    this.appointment = appointment;
  }

  @Override
  public String toString() {
    return this.id + " " + this.date + " " + this.laboratory + " " + this.results;
  }
}