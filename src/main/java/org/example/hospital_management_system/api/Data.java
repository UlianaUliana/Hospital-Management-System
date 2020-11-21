package org.example.hospital_management_system.api;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.hospital_management_system.api.model.Doctor;
import org.example.hospital_management_system.api.model.Patient;

import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Data {

    @NotNull
    private List<Doctor> doctors = List.of(
            new Doctor("Oksana", "Kostiuk", "Cardiologist"),
            new Doctor("Ivan", "Myhovych", "Endocrinologist"));

    @NotNull
    private List<Patient> patients = List.of(
        new Patient("Inna", "Romaniuk", 60, "Ivano-Frankivsk"),
        new Patient("Taras", "Lisovsky", 65, "Ivano-Frankivsk"));

    public List<Doctor> getDoctors() {
        return doctors;
    }
    public List<Patient> getPatients() {
        return patients;
    }

}
