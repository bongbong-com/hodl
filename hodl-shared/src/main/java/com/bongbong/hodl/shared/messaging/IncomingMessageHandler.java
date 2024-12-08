package com.bongbong.hodl.shared.messaging;

public interface IncomingMessageHandler<T extends Message> {
    void consumeMessage(T message);
}
