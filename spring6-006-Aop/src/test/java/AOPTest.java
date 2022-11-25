import configuartion.Spring6Configuration;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.OrderService;

public class AOPTest {
    @Test
    public void testAOP() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Spring6Configuration.class);
        OrderService orderService = annotationConfigApplicationContext.getBean("orderService", OrderService.class);
        orderService.generate();
    }
}
