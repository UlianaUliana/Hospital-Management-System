package org.example.hospital_management_system.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

import org.joda.time.LocalDate;

@Getter
@Setter
public class Analysis {
  private UUID id;
  private LocalDate date;
  private String laboratory;
  private String results;

  public Analysis(LocalDate date, String laboratory, String results) {
    id = UUID.randomUUID();
    this.date = date;
    this.laboratory = laboratory;
    this.results = results;
  }

  @Override
  public String toString() {
    return this.id + " " + this.date + " " + this.laboratory + " " + this.results;
  }
}