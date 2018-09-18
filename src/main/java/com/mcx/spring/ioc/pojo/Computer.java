package com.mcx.spring.ioc.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Computer {

    @Autowired
    private Home home;

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }
}