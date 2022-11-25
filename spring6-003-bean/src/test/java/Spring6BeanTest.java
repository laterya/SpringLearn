import bean.Person;
import bean.Vip;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring6BeanTest {
    @Test
    public void testSimpleFactory() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Vip vipBean = applicationContext.getBean("vipBean", Vip.class);
        System.out.println(vipBean);
    }

    @Test
    public void testDate() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Person personBean = applicationContext.getBean("personBean", Person.class);
        System.out.println(personBean);
    }
}

