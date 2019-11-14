package com.github.gs618.eventbus.remote.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author sheng.dong
 */
public interface OutputChannel {
    String EVENT_OUTPUT_CHANNEL = "event-output-channel";

    @Output(EVENT_OUTPUT_CHANNEL)
    MessageChannel messageOutput();
}
