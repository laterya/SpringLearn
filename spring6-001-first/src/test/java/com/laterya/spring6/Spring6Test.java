package com.laterya.spring6;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring6Test {

    @Test
    public void testFirst() {
        // 初始化Spring容器上下文（解析beans.xml文件，创建所有的bean对象）
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml", "beans1.xml");    //beans.xml在resources目录下即在根目录下
        // 根据id获取bean对象
        Object userBean = applicationContext.getBean("userBean");
        Object dateBean = applicationContext.getBean("dateBean");
        System.out.println(userBean);
        System.out.println(dateBean);

        Logger logger = LoggerFactory.getLogger(Spring6Test.class);
        logger.info("this is a log message");
    }
}