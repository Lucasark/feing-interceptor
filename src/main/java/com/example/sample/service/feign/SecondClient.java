package com.example.sample.service.feign;

import com.example.sample.service.FeignLoggingConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URI;

@FeignClient(
        name = "second",
        url = "https://openlibrary.org/api/books?bibkeys=ISBN%3A0201558025&format=json&jscmd=viewapi",
        configuration = FeignLoggingConfiguration.class
)
public interface SecondClient {

    @GetMapping
    String getSecondLayer(URI baseURI);

}




