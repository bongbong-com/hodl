package com.bongbong.hodl.paper.util;

import com.bongbong.hodl.paper.PaperPlugin;
import com.bongbong.hodl.shared.util.Scheduler;
import org.bukkit.Bukkit;

public final class PaperScheduler implements Scheduler {
    private final PaperPlugin plugin;

    public PaperScheduler(PaperPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void runAsync(Runnable runnable) {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, runnable);
    }

    @Override
    public void runSync(Runnable runnable) {
        Bukkit.getScheduler().runTask(plugin, runnable);
    }
}
