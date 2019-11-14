package com.github.gs618.eventbus.nativ;


import com.github.gs618.eventbus.model.Event;
import com.github.gs618.eventbus.model.Eventbus;

import java.util.concurrent.Executor;

/**
 * @author s.c.gao
 */
public class NativeEventbus implements Eventbus<Event> {

    private Executor executor;

    private NativeEventbus() {
        executor = ExecutorProvider.SINGLETON_THREAD_POOL_5.getExecutor();
    }

    private static class SingletonHolder {
        private static final NativeEventbus INSTANCE = new NativeEventbus();
    }

    public static NativeEventbus getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public Object publish(Event event) {
        EventListenerProvider.EVENT_LISTENER_MAP.forEach((eventClass, eventListeners) -> {
            if (!eventClass.equals(event.getClass())) {
                return;
            }
            eventListeners.forEach(eventListener -> executor.execute(() -> eventListener.handle(event)));
        });
        return null;
    }

}
