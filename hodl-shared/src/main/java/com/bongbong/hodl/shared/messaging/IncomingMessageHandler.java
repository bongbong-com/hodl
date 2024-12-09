package com.bongbong.hodl.shared.messaging;

/**
 * Handles, or processes, incoming messages in MessagingService.
 *
 * @param <T> the type of message this handler works with
 */
public interface IncomingMessageHandler<T extends Message> {
    /**
     * Consumes a message from the MessagingService.
     *
     * @param message the message to process
     */
    void consumeMessage(T message);
}
