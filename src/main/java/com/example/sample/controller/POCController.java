package com.example.sample.controller;


import com.example.sample.service.feign.FirstClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/poc")
@RequiredArgsConstructor
public class POCController {

    private final FirstClient firstClient;

    @GetMapping
    public void get() {
        String response = firstClient.get();
    }

}
