package com.example.sample.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "first",
        url = "https://openlibrary.org/api/books?bibkeys=OCLC%3A263296519&format=json&jscmd=viewap"
)
public interface FirstClient {

    @GetMapping
    String get();

}
