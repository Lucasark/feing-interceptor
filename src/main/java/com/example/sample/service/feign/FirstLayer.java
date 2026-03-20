package com.example.sample.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "PrimeiraApi", url = "https://dontpad.com/firstlayer")
public interface FirstLayer {

    @GetMapping
    String get();

}
