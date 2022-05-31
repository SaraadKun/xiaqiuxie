package com.saraad.demo.test;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements ITestService {


    @Override
    public String test() {

        return "test method";
    }
}
