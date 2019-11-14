package com.github.gs618.eventbus.remote.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author sheng.dong
 */
public interface InputChannel {

    String EVENT_INPUT_CHANNEL = "event-input-channel";

    @Input(EVENT_INPUT_CHANNEL)
    SubscribableChannel messageInput();
}
