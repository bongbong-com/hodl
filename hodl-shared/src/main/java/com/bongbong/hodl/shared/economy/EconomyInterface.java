package com.bongbong.hodl.shared.economy;

import java.util.UUID;

public interface EconomyInterface {
    boolean transfer(UUID sender, UUID receiver, int amount_msat);
    int getBalance(UUID player);
}
