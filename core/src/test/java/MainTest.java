import com.google.common.eventbus.EventBus;
import config.AppConfig;
import domain.CustomerOrder;
import eventhandlers.OrderPlaceHandler;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.CustomerService;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by sean on 12/20/15.
 */


public class MainTest {

    private ApplicationContext appContext;

    @Before
    public void prepare() {
        appContext = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @Test
    public void testHello() {
        CustomerService service = appContext.getBean("customerService", CustomerService.class);
        CustomerOrder order = new CustomerOrder();
        order.setOrderNumber("test-order-number");
        service.placeOrder(order);
        //assertThat(true, equalTo(true));
    }
}
