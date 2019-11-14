package com.github.gs618.eventbus.model;


import com.github.gs618.eventbus.model.exception.EventPublishException;

/**
 * @author s.c.gao
 */
@FunctionalInterface
public interface Eventbus<T extends Event> {

    /**
     * 发布事件
     *
     * @param event 发布的事件
     * @return any
     * @throws EventPublishException
     */
    Object publish(final T event) throws EventPublishException;

}
