package config;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import eventhandlers.OrderPlaceHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

/**
 * Created by sean on 12/20/15.
 */
public class InitEventBus implements BeanPostProcessor, BeanFactoryAware {

    private BeanFactory beanFactory;
    private EventBus eventBus;

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
//        if(s.equals("eventBus")) {
//            EventBus eventBus = (EventBus) o;
//            eventBus.register(new OrderPlaceHandler());
//            return eventBus;
//        }
//        return o;
        for (Method method : o.getClass().getMethods()) {

            Subscribe subscribeAnnotation = method.getAnnotation(Subscribe.class);
            if (subscribeAnnotation == null) {
                continue;
            }
            this.eventBus.register(o);
            break;
        }
        return o;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        this.eventBus = this.beanFactory.getBean(EventBus.class);
    }
}
