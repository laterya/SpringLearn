package com.laterya.spring6.test;

import com.laterya.spring6.service.OrderService;
import com.laterya.spring6.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DITest {

    @Test
    public void testSetDI() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        UserService userServiceBean = applicationContext.getBean("userServiceBean", UserService.class);
//        userServiceBean.save();

        OrderService orderServiceBean = applicationContext.getBean("orderServiceBean", OrderService.class);
        orderServiceBean.delete();
    }
}
