package service;

import org.springframework.stereotype.Component;

//目标类
@Component
public class OrderService {
    //目标方法
    public void generate() {
        System.out.println("生成订单！");
    }
}
