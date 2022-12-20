package com.example.springbootjpa.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class StudentService {





    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting/{code}")
    public Greeting greeting(@PathVariable(value = "code") String code, @RequestParam(value = "name", defaultValue = "World") String name) {
        String text = "pakistan@email.com";

        return new Greeting(counter.incrementAndGet(), String.format(template, name));

    }
}

