package com.bongbong.hodl.shared.messaging;

import java.io.Closeable;

/**
 * This service allows messaging between instances with a publish and subscribe system.
 *
 * @param <T> the type of message this service handles
 */
public interface MessagingService<T extends Message> extends Closeable {
    /**
     * Adds a new subscription to this service.
     *
     * @param id      the handler ID (to track for unsubscribing)
     * @param handler the handler for incoming messages
     */
    void subscribe(String id, IncomingMessageHandler<T> handler);

    /**
     * Unsubscribes a handler based on its ID.
     *
     * @param id the handler ID
     */
    void unsubscribe(String id);

    /**
     * Publishes, or sends, a message to the other instances.
     *
     * @param message the message to send
     */
    void publish(T message);
}
