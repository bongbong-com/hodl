package com.bongbong.hodl.shared.messaging;

/**
 * A message that can be sent by MessagingService.
 */
public interface Message {
    /**
     * The actual message, or payload, to send.
     *
     * @return the payload string
     */
    String getPayload();
}
