package com.example.sample.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "SegundaApi", url = "https://dontpad.com/secondlayer")
public interface SecondLayer {

    @GetMapping
    String get();

}
