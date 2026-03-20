package com.example.sample.service.working;

import com.example.sample.service.feign.SecondClient;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
@ConditionalOnProperty(value = "spring.main.allow-circular-references", havingValue = "false")
public class FeignRequestInterceptorNotWorking implements RequestInterceptor {

    private final SecondClient secondLayer;

    @Override
    public void apply(final RequestTemplate requestTemplate) {
        log.info("This is: {}", requestTemplate.feignTarget().url());
        if (requestTemplate.feignTarget().url().contains("OCLC")) {
            secondLayer.get();
        }
    }
}
