package com.example.sample.service.working;

import com.example.sample.service.feign.SecondClient;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@ConditionalOnProperty(value = "spring.main.allow-circular-references", havingValue = "true")
public class FeignRequestInterceptorWorking implements RequestInterceptor {

    @Autowired
    private SecondClient secondLayer;

    @Override
    public void apply(final RequestTemplate requestTemplate) {
        log.info("This is: {}", requestTemplate.feignTarget().url());
        if (requestTemplate.feignTarget().url().contains("OCLC")) {
            secondLayer.get();
        }
    }
}
