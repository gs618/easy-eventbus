package com.github.gs618.eventbus.remote;

import com.github.gs618.eventbus.model.Event;
import com.github.gs618.eventbus.model.EventListener;
import com.github.gs618.eventbus.nativ.NativeEventbus;
import com.github.gs618.eventbus.remote.channel.InputChannel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.stream.annotation.StreamListener;

import java.util.Objects;

import static com.github.gs618.eventbus.remote.util.GsonUtils.GSON;


/**
 * @author s.c.gao
 */
@Slf4j
public class DefaultRemoteEventListener implements EventListener {

    @StreamListener(InputChannel.EVENT_INPUT_CHANNEL)
    protected void input(String remoteEventJson) {
        if (StringUtils.isEmpty(remoteEventJson)) {
            log.error("Received a NULL event from remote");
            return;
        }
        var remoteEvent = GSON.fromJson(remoteEventJson, RemoteEvent.class);
        try {
            Class<? extends Event> clazz = (Class<? extends Event>) Class.forName(remoteEvent.getClazz());
            Event nativeEvent = GSON.fromJson(remoteEvent.getEvent(), clazz);
            if (Objects.nonNull(nativeEvent)) {
                handle(nativeEvent);
            }
        } catch (Exception e) {
            log.error("event handle exception", e);
        }
    }

    @Override
    public void handle(Event event) {
        if (null == event) {
            return;
        }
        NativeEventbus.getInstance().publish(event);
    }
}
