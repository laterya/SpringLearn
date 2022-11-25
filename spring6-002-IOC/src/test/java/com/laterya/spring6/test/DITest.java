package com.laterya.spring6.test;

import com.laterya.spring6.beans.MyDataSource;
import com.laterya.spring6.beans.Order;
import com.laterya.spring6.beans.Person;
import com.laterya.spring6.beans.User;
import com.laterya.spring6.service.OrderService;
import com.laterya.spring6.service.UserService;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DITest {

    @Test
    public void testSetDI() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml", "spring-simple-type.xml");
//        UserService userServiceBean = applicationContext.getBean("userServiceBean", UserService.class);
//        userServiceBean.save();

//        OrderService orderServiceBean = applicationContext.getBean("orderServiceBean", OrderService.class);
//        orderServiceBean.delete();
        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println(userBean);
    }
    @Test
    public void testDataSource() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-datasource.xml");
        MyDataSource dataSource = applicationContext.getBean("dataSource", MyDataSource.class);
        System.out.println(dataSource);
    }

    @Test
    public void testArraySimple() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-array-simple.xml");
        Person person = applicationContext.getBean("person", Person.class);
        System.out.println(person);
    }

    @Test
    public void testArray() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-array.xml");
        Order order = applicationContext.getBean("order", Order.class);
        System.out.println(order);
    }
}
