package com.github.gs618.eventbus.nativ;


import com.github.gs618.eventbus.model.Event;
import com.github.gs618.eventbus.model.EventListener;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author s.c.gao
 */
public class EventListenerProvider {

    static final Map<Class<? extends Event>, Set<EventListener>> EVENT_LISTENER_MAP = new ConcurrentHashMap<>();
    private static final int INITIAL_CAPACITY = 5;

    private EventListenerProvider() {
    }

    private static class SingletonHolder {
        private static final EventListenerProvider INSTANCE = new EventListenerProvider();
    }

    public static EventListenerProvider getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public <T extends Event> void register(Class<T> clazz, EventListener<T> eventListener) {
        Set<EventListener> set = EVENT_LISTENER_MAP.computeIfAbsent(clazz, k -> new HashSet<>(INITIAL_CAPACITY));
        set.add(eventListener);
    }

}
