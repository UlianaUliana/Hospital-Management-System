package org.example.hospital_management_system.resources;

import com.codahale.metrics.annotation.Timed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
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
}
