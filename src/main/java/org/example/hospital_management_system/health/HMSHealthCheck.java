package org.example.hospital_management_system.health;

import com.codahale.metrics.health.HealthCheck;

public class HMSHealthCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
