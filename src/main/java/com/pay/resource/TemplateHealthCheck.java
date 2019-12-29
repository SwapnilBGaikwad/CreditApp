package com.pay.resource;

import com.codahale.metrics.health.HealthCheck;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplateHealthCheck extends HealthCheck {
    @Override
    protected Result check() {
        log.info("HealthCheck: Hello 1,2,3,4 :)");
        return Result.healthy();
    }
}
