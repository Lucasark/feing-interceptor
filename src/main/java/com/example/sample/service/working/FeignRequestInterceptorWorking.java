package com.example.sample.service.working;

import com.example.sample.service.feign.SecondLayer;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
//@Component
public class FeignRequestInterceptorWorking implements RequestInterceptor {

    private SecondLayer secondLayer;

    @Autowired
    public void setYoutubeLayer(SecondLayer secondLayer) {
        this.secondLayer = secondLayer;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        log.info("This is: {}", requestTemplate.feignTarget().url());
        if (requestTemplate.feignTarget().url().contains("first")) {
            secondLayer.get();
        }
    }


}
