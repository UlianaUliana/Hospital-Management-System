package org.example.hospital_management_system.service;

import org.example.hospital_management_system.api.Data;
import org.example.hospital_management_system.api.model.Doctor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class DoctorServiceTest {

    @Mock
    private Data data;

    @InjectMocks
    private DoctorService service;

    @Test
    public void getAllDoctorsTestReturnsDoctors() {
        when(data.getDoctors()).thenReturn(List.of(
            new Doctor("Oksana", "Kostiuk", "Cardiologist"),
            new Doctor("Ivan", "Myhovych", "Endocrinologist")));
        assertEquals(service.getAllDoctors().get(0).getFirstName(), "Oksana");
    }
}
