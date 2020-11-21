package org.example.hospital_management_system.resources;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.example.hospital_management_system.api.model.Analysis;
import org.example.hospital_management_system.api.model.Appointment;
import org.example.hospital_management_system.api.model.Doctor;
import org.example.hospital_management_system.api.model.Patient;
import org.example.hospital_management_system.service.PatientService;

import com.codahale.metrics.annotation.Timed;

@Path("/patients")
@Produces(MediaType.APPLICATION_JSON)
@AllArgsConstructor
@NoArgsConstructor
public class PatientResource {

  @Inject
  @NonNull
  private PatientService service;

  @GET
  @Timed
  public String getAllPatients() {
    return service.getAllPatients().toString();
  }

  @GET
  @Timed
  @Path("/{id}")
  public String getPatientById(@PathParam("id") UUID id) {
    return service.getPatientById(id).toString();
  }

  @POST
  @Timed
  @Path("/add_doctor/{id}")
  public void addDoctor(@PathParam("id") UUID patientId, Doctor doctor) {  // model??
    service.addDoctor(patientId, doctor);
  }

  @POST
  @Timed
  @Path("add_appointment/{id}")
  public void addAppointment(@PathParam("id") UUID patientId, Appointment appointment) {  //?????
    service.addAppointment(patientId, appointment);
  }

  @GET
  @Timed
  @Path("/analyses/appointment")
  public String getAllAnalysesByAppointment(@QueryParam("patientId")UUID patientId, @QueryParam("appointmentId") UUID appointmentId) {
    return service.getAllAnalysesByAppointment(patientId, appointmentId).toString();
  }

  @GET
  @Timed
  @Path("/analyses")
  public String getAllAnalyses(@QueryParam("patientId")UUID patientId) {
    return service.getAllAnalyses(patientId).toString();
  }

  @POST
  @Timed
  @Path("/add_analysis/{id}")
  public void addAnalysis(@PathParam("id") UUID patientId, Analysis analysis) {
    service.addAnalysis(patientId, analysis);
  }

  @POST
  @Timed
  @Path("/add")
  public void addPatient(Patient patient) {
    service.createOrUpdatePatient(patient);
  }

//  @PUT
  @GET
  @Timed
  @Path("/edit")
  public void updatePatient(Patient patient) {
    service.createOrUpdatePatient(patient);
  }

//  @DELETE
  @GET
  @Timed
  @Path("/delete/{id}")
  public void deletePatient(@PathParam("id") UUID patientId) {
    service.deletePatient(patientId);
  }
}
