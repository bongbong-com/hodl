package com.bongbong.hodl.shared.messaging.impl;

import com.bongbong.hodl.shared.messaging.ChannelMessage;
import com.bongbong.hodl.shared.messaging.IncomingMessageHandler;
import com.bongbong.hodl.shared.messaging.MessagingService;
import lombok.RequiredArgsConstructor;
import redis.clients.jedis.JedisPubSub;
import redis.clients.jedis.UnifiedJedis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RedisMessagingService implements MessagingService<ChannelMessage> {
    private final Map<String, IncomingMessageHandler<ChannelMessage>> subscriptions = new HashMap<>();
    private final UnifiedJedis jedis;
    private final Subscription handler;

    public RedisMessagingService(String jedisURL) {
        this.jedis = new UnifiedJedis(jedisURL);
        this.handler = new Subscription(this);
    }

    @Override
    public void subscribe(String id, IncomingMessageHandler<ChannelMessage> handler) {
        subscriptions.put(id, handler);
    }

    @Override
    public void unsubscribe(String id) {
        subscriptions.remove(id);
    }

    @Override
    public void publish(ChannelMessage message) {
        jedis.publish(message.getChannel(), message.getPayload());
    }

    @Override
    public void close() {
        handler.unsubscribe();
        jedis.close();
    }

    @RequiredArgsConstructor
    private static class Subscription extends JedisPubSub {
        private final RedisMessagingService service;

        @Override
        public void onMessage(String channel, String message) {
            final RedisMessage msg = new RedisMessage(channel, message);

            final Set<Map.Entry<String, IncomingMessageHandler<ChannelMessage>>> handlers = service.subscriptions.entrySet(); // TODO: Might need to copy to be thread-safe
            for (Map.Entry<String, IncomingMessageHandler<ChannelMessage>> handler : handlers) {
                if (!handler.getKey().equalsIgnoreCase(channel)) continue;

                handler.getValue().consumeMessage(msg);
            }
        }
    }
}
