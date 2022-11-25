import bean.Order;
import bean.User;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.DefaultLifecycleProcessor;

public class SpringTest {

    @Test
    public void testBeanLifeCycle() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println("4.使用bean");
        // 只有正常关闭spring容器才会执行销毁方法
        ((ClassPathXmlApplicationContext) applicationContext).close();
    }

    @Test
    public void testBeanRegister() {
        Order order = new Order();
        System.out.println(order);

        // 创建 默认可列表BeanFactory 对象
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        //注册bean
        defaultListableBeanFactory.registerSingleton("orderBean", order);
        //从spring容器中获得bean
        Order orderBean = defaultListableBeanFactory.getBean("orderBean", Order.class);
        System.out.println(orderBean);
    }
}
