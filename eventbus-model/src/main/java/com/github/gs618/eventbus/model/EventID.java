package com.github.gs618.eventbus.model;

/**
 * @author s.c.gao
 */
public class EventID implements ID<String> {

    private String id;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public EventID setId(String id) {
        this.id = id;
        return this;
    }

}
