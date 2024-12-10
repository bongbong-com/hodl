package com.bongbong.hodl.shared.util;

public interface Scheduler {
    void runAsync(Runnable runnable);

    void runSync(Runnable runnable);
}
