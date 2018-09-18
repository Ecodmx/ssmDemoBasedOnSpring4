package com.mcx.test;

import com.mcx.spring.ioc.config.ClazzBeanConfig;
import com.mcx.spring.ioc.pojo.Computer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ClazzBeanConfig.class})
public class ClazzBeanTest implements ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Test
    public void testClazzBean(){
        Computer computer = context.getBean(Computer.class);
        Assert.assertEquals("Spring class注入失败","myHome", computer.getHome().getHomeName());
    }

}