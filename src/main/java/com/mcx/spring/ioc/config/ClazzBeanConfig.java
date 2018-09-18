package com.mcx.spring.ioc.config;

import com.mcx.spring.ioc.pojo.Computer;
import com.mcx.spring.ioc.pojo.Home;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClazzBeanConfig {

    @Bean
    public Computer computer(Home home) {
        Computer computer = new Computer();
        computer.setHome(home);
        return computer;
    }

    @Bean
    public Home  home(){
        Home home = new Home();
        home.setHomeName("myHome");
        home.setHomeSize("15");
        return home;
    }

}