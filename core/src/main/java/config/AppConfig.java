package config;

import com.google.common.eventbus.EventBus;
import eventhandlers.OrderPlaceHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.CustomerService;

/**
 * Created by sean on 12/20/15.
 */

@Configuration
public class AppConfig {

    @Bean(name="eventBus")
    public EventBus getEventBus() {
        return new EventBus();
    }

    @Bean(name = "customerService")
    public CustomerService getCustomerService() {
        return new CustomerService(getEventBus());
    }

    @Bean
    public InitEventBus initEventBus() {
        return new InitEventBus();
    }

    @Bean
    public OrderPlaceHandler getOrderPlaceHander() {
        return new OrderPlaceHandler();
    }
}
