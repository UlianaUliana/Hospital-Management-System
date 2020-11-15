package org.example.hospital_management_system.service;

import org.example.hospital_management_system.api.model.Data;
import org.example.hospital_management_system.api.model.Doctor;
import java.util.List;


public class DoctorService {

    private Data data;

    public DoctorService() {
        data = new Data();
    }

    public List<Doctor> getAllDoctors() {
        return data.getDoctors();
    }
}