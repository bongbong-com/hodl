package com.bongbong.hodl.shared.messaging;

import java.io.Closeable;

public interface MessagingService<T extends Message> extends Closeable {
    void subscribe(String id, IncomingMessageHandler<T> handler);

    void unsubscribe(String id);

    void publish(T message);
}
