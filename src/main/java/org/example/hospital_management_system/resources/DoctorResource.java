package org.example.hospital_management_system.resources;

import com.codahale.metrics.annotation.Timed;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

import org.example.hospital_management_system.api.model.Appointment;
import org.example.hospital_management_system.api.model.Doctor;
import org.example.hospital_management_system.api.model.Patient;
import org.example.hospital_management_system.service.DoctorService;

@Path("/doctors")
@Produces(MediaType.APPLICATION_JSON)
@AllArgsConstructor
@NoArgsConstructor
public class DoctorResource {

    @Inject
    @NonNull
    private DoctorService service;

    @GET
    @Timed
    public String getAllDoctors() {
        return service.getAllDoctors().toString();
    }

    @GET
    @Timed
    @Path("/{id}")
    public String getDoctorById(@PathParam("id") UUID id) {
        return service.getDoctorById(id).toString();
    }

    @GET
    @Timed
    @Path("/{specialty}")
    public String getAllDoctorsBySpecialty(@PathParam("specialty") String specialty) {
        return service.getAllDoctorsBySpecialty(specialty).toString();
    }

    @POST
    @Timed
    @Path("/add_patient/{id}")
    public void addPatient(@PathParam("id") UUID doctorId, Patient patient) {  // model??
        service.addPatient(doctorId, patient);
    }

    @POST
    @Timed
    @Path("add_appointment/{id}")
    public void addAppointment(@PathParam("id") UUID doctorId, Appointment appointment) {  //?????
        service.addAppointment(doctorId, appointment);
    }

    @POST
    @Timed
    @Path("/add")
    public void addDoctor(Doctor doctor) {
        service.createOrUpdateDoctor(doctor);
    }

    @PUT
    @Timed
    @Path("/edit")
    public void updateDoctor(Doctor doctor) {
        service.createOrUpdateDoctor(doctor);
    }

    @DELETE
    @Timed
    @Path("/delete/{id}")
    public void deleteDoctor(@PathParam("id") UUID doctorId) {
        service.deleteDoctor(doctorId);
    }
}
