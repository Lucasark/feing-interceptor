package com.example.sample.service;

import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import(FeignClientsConfiguration.class)
public class FeignLoggingConfiguration {
    /**
     * Set the Feign specific log level to log client REST requests.
     */
    @Bean
    feign.Logger.Level feignLoggerLevel() {
        return feign.Logger.Level.FULL;
    }

}
