package com.example.sample.service.working;

import com.example.sample.service.feign.SecondClient;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;


@Component
public class FeignRequestInterceptor implements RequestInterceptor {

    private static final Logger log = LoggerFactory.getLogger(FeignRequestInterceptor.class);

    @Autowired
    private SecondClient secondLayer;

    private final String secondLayerUrl = "https://openlibrary.org/api/books?bibkeys=ISBN%3A0201558025&format=json&jscmd=viewapi";

    @Override
    public void apply(final RequestTemplate requestTemplate) {
        log.info("This is: {}", requestTemplate.feignTarget().url());
        if (requestTemplate.feignTarget().url().contains("OCLC")) {
            try {
                var a = secondLayer.getSecondLayer(new URI(secondLayerUrl));
                log.info("From Second layer: {}", a);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
