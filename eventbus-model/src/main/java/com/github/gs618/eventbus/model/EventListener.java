package com.github.gs618.eventbus.model;

/**
 * @author s.c.gao
 */
@FunctionalInterface
public interface EventListener<T extends Event> {

    /**
     * 事件处理
     *
     * @param event event
     */
    void handle(T event);
}
