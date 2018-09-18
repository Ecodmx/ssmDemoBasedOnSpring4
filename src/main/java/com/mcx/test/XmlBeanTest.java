package com.mcx.test;

import com.mcx.usr.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:xml-bean.xml"})
public class XmlBeanTest implements ApplicationContextAware {

    private ApplicationContext context;

    @Test
    public void testXmlBean() {
        User user = context.getBean("user", User.class);
        Assert.assertEquals("Spring xml依赖注入失败:" + user.getUsername(),"mcx", user.getUsername());
        Assert.assertEquals("Spring xml依赖注入失败:" + user.getPassword(), "123", user.getPassword());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}