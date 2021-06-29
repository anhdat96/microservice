package microservice.limitsservice.controller;

import microservice.limitsservice.config.Configuration;
import microservice.limitsservice.entity.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitsFromConfiguration() {
        return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
    }
}
