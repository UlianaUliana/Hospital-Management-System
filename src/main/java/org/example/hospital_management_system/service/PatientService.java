package org.example.hospital_management_system.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.example.hospital_management_system.api.Data;
import org.example.hospital_management_system.api.model.Analysis;
import org.example.hospital_management_system.api.model.Appointment;
import org.example.hospital_management_system.api.model.Doctor;
import org.example.hospital_management_system.api.model.Patient;

public class PatientService {
  private Data data;

  public PatientService() {
    data = new Data();
  }

  public List<Patient> getAllPatients() {
    return data.getPatients();
  }

  public Patient getPatientById(UUID id) {
    for(Patient patient : getAllPatients()) {
      if(patient.getId() == id) {
        return patient;
      }
    }
    return null;
  }

  public void addDoctor(Patient patient, Doctor doctor) {
    patient.getDoctors().add(doctor);
  }

  public void addAppointment(Patient patient, Appointment appointment) {
    patient.getAppointments().add(appointment);
  }

  public List<Analysis> getAllAnalysesByAppointment(Patient patient, Appointment appointment) {
    for(Appointment appoint : patient.getAppointments()) {
      if(appoint.getId() == appointment.getId()) {
        return appoint.getAnalyses();
      }
    }
    return null;
  }

  public List<Analysis> getAllAnalyses(Patient patient) {
    List<Analysis> analysesList = new ArrayList<>();
    for(Appointment appointment : patient.getAppointments()) {
      analysesList.addAll(getAllAnalysesByAppointment(patient, appointment));
    }
    return analysesList;
  }

  public void addAnalysis(Patient patient, Doctor doctor, Appointment appointment, Analysis analysis) {
    // ToDo
  }

}
