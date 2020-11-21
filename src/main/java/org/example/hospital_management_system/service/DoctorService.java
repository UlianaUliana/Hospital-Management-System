package org.example.hospital_management_system.service;

import org.example.hospital_management_system.api.Data;
import org.example.hospital_management_system.api.model.Appointment;
import org.example.hospital_management_system.api.model.Doctor;
import org.example.hospital_management_system.api.model.Patient;
import org.example.hospital_management_system.exeptions.NoSuchResourceException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class DoctorService {

    private Data data;

    public DoctorService() {
        data = new Data();
    }

    public List<Doctor> getAllDoctors() {
        return data.getDoctors();
    }

    public Doctor getDoctorById(UUID id) {
        for(Doctor doctor : getAllDoctors()) {
            if(doctor.getId().equals(id)) {
                return doctor;
            }
        }
        throw new NoSuchResourceException("There is no doctor with such id");
    }

    public List<Doctor> getAllDoctorsBySpecialty(String specialty) {
        List<Doctor> doctors = new ArrayList<>();
        for(Doctor doctor : getAllDoctors()) {
            if(doctor.getSpecialty().equals(specialty)) {
                doctors.add(doctor);
            }
        }
        return doctors;
    }

    public void addPatient(UUID doctorId, Patient patient) {
        getDoctorById(doctorId).getPatients().add(patient);
    }

    public void addAppointment(UUID doctorId, Appointment appointment) {
        getDoctorById(doctorId).getAppointments().add(appointment);
    }

    public void createOrUpdateDoctor(Doctor newDoctor) {
        Doctor doctor = getDoctorById(newDoctor.getId());
        if(doctor == null) {
            data.getDoctors().add(newDoctor);
        } else {
            doctor.setFirstName(newDoctor.getFirstName());
            doctor.setLastName(newDoctor.getLastName());
            doctor.setSpecialty(newDoctor.getSpecialty());
        }
    }

    public void deleteDoctor(UUID doctorId) {
        getAllDoctors().remove(getDoctorById(doctorId));
    }
}