package org.example.hospital_management_system.api;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.hospital_management_system.api.model.Doctor;
import org.example.hospital_management_system.api.model.Patient;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
public class Data {

    @NotNull
    private List<Doctor> doctors = List.of(
            new Doctor(UUID.fromString("c70f812b-8525-450d-8dc7-98e4892c89c6"), "Oksana", "Kostiuk", "Cardiologist"),
            new Doctor("Ivan", "Myhovych", "Endocrinologist"));

    @NotNull
    private List<Patient> patients = List.of(
        new Patient(UUID.fromString("f4221dfe-885b-42c7-af2e-c04db44fd048"), "Inna", "Romaniuk", 60, "Ivano-Frankivsk"),
        new Patient("Taras", "Lisovsky", 65, "Ivano-Frankivsk"));

    public List<Doctor> getDoctors() {
        return doctors;
    }
    public List<Patient> getPatients() {
        return patients;
    }

}
