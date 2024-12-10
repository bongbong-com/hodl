package com.bongbong.hodl.paper.profile;

import com.bongbong.hodl.shared.data.DataStore;
import com.bongbong.hodl.shared.profile.AbstractProfileManager;
import com.bongbong.hodl.shared.profile.Profile;
import com.bongbong.hodl.shared.util.Scheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PaperProfileManager extends AbstractProfileManager implements Listener {
    public PaperProfileManager(DataStore dataStore, Scheduler scheduler) {
        super(dataStore, scheduler);
    }

    @EventHandler
    public void on(PlayerJoinEvent event) {
        scheduler.runAsync(() -> {
            final Profile loaded = loadProfile(event.getPlayer().getUniqueId());

            scheduler.runSync(() -> {
                Profile profile;
                if (loaded == null) {
                    profile = createProfile(event.getPlayer().getUniqueId());
                    scheduler.runAsync(() -> saveProfile(profile));
                } else {
                    profile = loaded;
                }

                getCachedProfiles().put(event.getPlayer().getUniqueId(), profile);
            });
        });
    }

    @EventHandler
    public void on(PlayerQuitEvent event) {
        getCachedProfiles().remove(event.getPlayer().getUniqueId());
    }
}
