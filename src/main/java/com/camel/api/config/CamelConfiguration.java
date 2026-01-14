package com.camel.api.config;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamelConfiguration {
    
    @Value("${app.name}")
    private String appName;
    
    @Bean
    public CamelContextConfiguration camelContextConfiguration() {
        return new CamelContextConfiguration() {
            @Override
            public void beforeApplicationStart(CamelContext camelContext) {
                camelContext.setStreamCaching(true);
                camelContext.setMessageHistory(true);
                camelContext.setTracing(false);
                camelContext.setUseMDCLogging(true);
                
                camelContext.getRouteController().setSupervising(true);
                camelContext.getRouteController().getSupervisingRouteController()
                    .setBackOffDelay(1000)
                    .setInitialDelay(1000)
                    .setMaxAttempts(3);
            }
            
            @Override
            public void afterApplicationStart(CamelContext camelContext) {
                // Nothing to do after application starts
            }
        };
    }
}