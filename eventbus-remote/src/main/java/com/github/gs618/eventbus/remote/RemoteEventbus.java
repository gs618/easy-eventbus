package com.github.gs618.eventbus.remote;

import com.github.gs618.eventbus.model.Event;
import com.github.gs618.eventbus.model.Eventbus;
import com.github.gs618.eventbus.model.exception.EventPublishException;
import com.github.gs618.eventbus.remote.channel.OutputChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @author s.c.gao
 */

public class RemoteEventbus implements Eventbus<Event> {

    @Autowired
    private OutputChannel outputChannel;

    @Override
    public Object publish(Event event) throws EventPublishException {
        RemoteEvent remoteEvent = new RemoteEvent(event);
        Message<RemoteEvent> message = MessageBuilder.withPayload(remoteEvent).build();
        return outputChannel.messageOutput().send(message);
    }
}
