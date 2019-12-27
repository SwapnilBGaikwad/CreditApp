package com.pay;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.pay.config.AppConfig;
import com.pay.config.CreditModule;
import com.pay.resource.ImportResource;
import com.pay.resource.TemplateHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class CreditApp extends Application<AppConfig> {
    public static void main(String[] args) throws Exception {
        new CreditApp().run(args);
    }

    @Override
    public void run(AppConfig configuration, Environment environment) {
        Injector injector = Guice.createInjector(new CreditModule());
        environment.jersey().register(injector.getInstance(ImportResource.class));
        TemplateHealthCheck healthCheck = new TemplateHealthCheck();
        environment.healthChecks().register("template", healthCheck);
    }
}
