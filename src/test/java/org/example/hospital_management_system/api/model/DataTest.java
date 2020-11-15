package org.example.hospital_management_system.api.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataTest {

    private static Data data;

    @BeforeAll
    public static void setUp() {
        data = new Data();
    }

    @Test
    public void getAllDoctorsTestShouldReturnDoctors() {
        String expected = "Oksana";
        assertEquals(expected, data.getDoctors().get(0).getFirstName());
    }
}
