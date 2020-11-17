package org.example.hospital_management_system.api;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.hospital_management_system.api.model.Doctor;

import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Data {

    @NotNull
    private List<Doctor> doctors = List.of(
            new Doctor("Oksana", "Kostiuk"),
            new Doctor("Ivan", "Myhovych"));

    public List<Doctor> getDoctors() {
        return doctors;
    }

}
