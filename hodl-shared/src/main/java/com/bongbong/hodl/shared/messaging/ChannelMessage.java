package com.bongbong.hodl.shared.messaging;

/**
 * A subtype of Message that supports channels for implementations like Redis.
 */
public interface ChannelMessage extends Message {
    /**
     * The channel to send this message on.
     *
     * @return the channel name
     */
    String getChannel();
}
