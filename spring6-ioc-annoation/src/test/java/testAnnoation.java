import configuration.Spring6Configuration;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testAnnoation {

    @Test
    public void testBean() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Spring6Configuration.class);
        Object userBean = annotationConfigApplicationContext.getBean("userBean");
        System.out.println(userBean);
    }
}
