package com.saraad.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    ITestService testService;

    @GetMapping("/test")
    public String test() {
        return testService.test();
    }

}
