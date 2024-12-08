package com.bongbong.hodl.shared.messaging.impl;

import com.bongbong.hodl.shared.messaging.ChannelMessage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class RedisMessage implements ChannelMessage {
    private final String channel, payload;
}
