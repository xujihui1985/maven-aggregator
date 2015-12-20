package service;

import com.google.common.eventbus.EventBus;
import domain.CustomerOrder;
import events.OrderPlaced;

/**
 * Created by sean on 12/20/15.
 */
public class CustomerService {

    private EventBus bus;

    public CustomerService(EventBus bus) {
        this.bus = bus;
    }

    public void placeOrder(CustomerOrder order) {
        this.bus.post(new OrderPlaced(order));
    }
}
