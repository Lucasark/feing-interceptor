package com.example.sample.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "second",
        url = "https://openlibrary.org/api/books?bibkeys=ISBN%3A0201558025&format=json&jscmd=viewapi"
)
public interface SecondClient {

    @GetMapping
    String get();

}




