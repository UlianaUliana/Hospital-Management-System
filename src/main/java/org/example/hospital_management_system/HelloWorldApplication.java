package org.example.hospital_management_system;

/**
 * Hello world!
 *
 */
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.example.hospital_management_system.health.TemplateHealthCheck;
import org.example.hospital_management_system.resources.DoctorResource;
import org.example.hospital_management_system.resources.HelloWorldResource;
import org.example.hospital_management_system.service.DoctorService;


public class HelloWorldApplication extends Application<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(HelloWorldConfiguration configuration,
        Environment environment) {
//        JerseyEnvironment jersey = environment.jersey();

        final HelloWorldResource resource = new HelloWorldResource(
            configuration.getTemplate(),
            configuration.getDefaultName()
        );
        final TemplateHealthCheck healthCheck =
            new TemplateHealthCheck(configuration.getTemplate());

        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);

//        final Data data = new Data();
//        jersey.register(Data.class);
//        environment.jersey().register(data);
        environment.jersey().register(new DoctorService());
        environment.jersey().register(DoctorResource.class);
    }
}
