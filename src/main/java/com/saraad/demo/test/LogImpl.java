package com.saraad.demo.test;

import org.springframework.stereotype.Service;

@Service
public class LogImpl implements ILog {

    @Override
    public void log(String msg) {
        System.err.println("LogImpl: " + msg);
    }

}
