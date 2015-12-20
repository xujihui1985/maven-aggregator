package events;

import domain.CustomerOrder;

/**
 * Created by sean on 12/20/15.
 */
public class OrderPlaced {
    private CustomerOrder order;

    public OrderPlaced(CustomerOrder order) {
        this.order = order;
    }

    public CustomerOrder getOrder() {
        return order;
    }
}
