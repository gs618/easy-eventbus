package com.github.gs618.eventbus.remote;

import com.github.gs618.eventbus.model.Event;
import com.github.gs618.eventbus.model.EventID;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.UUID;

import static com.github.gs618.eventbus.remote.util.GsonUtils.GSON;


/**
 * @author s.c.gao
 */
@Getter
@Accessors(chain = true)
class RemoteEvent implements Event {

    public RemoteEvent(Event event) {
        this.event = GSON.toJson(event);
        this.clazz = event.getClass().getName();
        this.eventID = new EventID().setId(UUID.randomUUID().toString());
    }

    private String event;

    private String clazz;

    private EventID eventID;

    @Override
    public String toString() {
        return GSON.toJson(this);
    }

}
