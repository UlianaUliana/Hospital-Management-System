package org.example.hospital_management_system;

/**
 * Hospital Management System
 *
 */
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.example.hospital_management_system.health.HMSHealthCheck;
import org.example.hospital_management_system.resources.DoctorResource;
import org.example.hospital_management_system.resources.PatientResource;
import org.example.hospital_management_system.service.DoctorService;
import org.example.hospital_management_system.service.PatientService;


public class HMSApplication extends Application<HMSConfiguration> {
    public static void main(String[] args) throws Exception {
        new HMSApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<HMSConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(HMSConfiguration configuration,
        Environment environment) {
//        JerseyEnvironment jersey = environment.jersey();

        final HMSHealthCheck healthCheck = new HMSHealthCheck();

        environment.healthChecks().register("HMSHealthCheck", healthCheck);

//        final Data data = new Data();
//        jersey.register(Data.class);
//        environment.jersey().register(data);
        environment.jersey().register(new DoctorService());
        environment.jersey().register(DoctorResource.class);

        environment.jersey().register(new PatientService());
        environment.jersey().register(PatientResource.class);
    }
}
