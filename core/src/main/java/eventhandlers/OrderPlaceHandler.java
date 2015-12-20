package eventhandlers;

import com.google.common.eventbus.Subscribe;
import events.OrderPlaced;

/**
 * Created by sean on 12/20/15.
 */
public class OrderPlaceHandler {

    @Subscribe
    public void HandleOrderPlace(OrderPlaced event) {
        System.out.printf("order placed %s \n", event.getOrder().getOrderNumber());
    }

}
