package org.example.hospital_management_system.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.example.hospital_management_system.api.Data;
import org.example.hospital_management_system.api.model.Analysis;
import org.example.hospital_management_system.api.model.Appointment;
import org.example.hospital_management_system.api.model.Doctor;
import org.example.hospital_management_system.api.model.Patient;
import org.example.hospital_management_system.exeptions.NoSuchResourceException;

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
      if(patient.getId().equals(id)) {
        return patient;
      }
    }
    throw new NoSuchResourceException("There is no patient with such id");
  }

  public void addDoctor(UUID patientId, Doctor doctor) {
    getPatientById(patientId).getDoctors().add(doctor);
  }

  public void addAppointment(UUID patientId, Appointment appointment) {
    getPatientById(patientId).getAppointments().add(appointment);
  }

  public List<Analysis> getAllAnalysesByAppointment(UUID patientId, UUID appointmentId) {
    for(Appointment appoint : getPatientById(patientId).getAppointments()) {
      if(appoint.getId() == appointmentId) {
        return appoint.getAnalyses();
      }
    }
    return null;
  }

  public List<Analysis> getAllAnalyses(UUID patientId) {
    List<Analysis> analysesList = new ArrayList<>();
    for(Appointment appointment : getPatientById(patientId).getAppointments()) {
      analysesList.addAll(getAllAnalysesByAppointment(patientId, appointment.getId()));
    }
    return analysesList;
  }

  public void addAnalysis(UUID patientId, Analysis analysis) {
    getAllAnalyses(patientId).add(analysis);
  }

  public void createOrUpdatePatient(Patient newPatient) {
    Patient patient = getPatientById(newPatient.getId());
    if(patient == null) {
      data.getPatients().add(newPatient);
    } else {
      patient.setFirstName(newPatient.getFirstName());
      patient.setLastName(newPatient.getLastName());
      patient.setAge(newPatient.getAge());
      patient.setAddress(newPatient.getAddress());
    }
  }

  public void deletePatient(UUID patientId) {
    getAllPatients().remove(getPatientById(patientId));
  }

}
