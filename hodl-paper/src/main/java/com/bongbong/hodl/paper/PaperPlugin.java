package com.bongbong.hodl.paper;

import com.bongbong.hodl.paper.claim.ChunkClaimCommand;
import com.bongbong.hodl.paper.claim.ChunkClaimManager;
import com.bongbong.hodl.paper.profile.PaperProfileManager;
import com.bongbong.hodl.paper.util.PaperScheduler;
import com.bongbong.hodl.shared.data.DataStore;
import com.bongbong.hodl.shared.data.impl.MongoDataStore;
import com.bongbong.hodl.shared.profile.ProfileManager;
import com.bongbong.hodl.shared.util.Scheduler;
import org.bukkit.plugin.java.JavaPlugin;
import revxrsal.commands.Lamp;
import revxrsal.commands.bukkit.BukkitLamp;
import revxrsal.commands.bukkit.actor.BukkitCommandActor;

public class PaperPlugin extends JavaPlugin {
    private Scheduler scheduler;
    private DataStore dataStore;
    private ProfileManager profileManager;
    private ChunkClaimManager chunkClaimManager;
    private Lamp<BukkitCommandActor> lamp;

    @Override
    public void onEnable() {
        scheduler = new PaperScheduler(this);
        dataStore = new MongoDataStore(null, null); // TODO: setup credentials
        profileManager = new PaperProfileManager(dataStore, scheduler);
        chunkClaimManager = new ChunkClaimManager();

        lamp = BukkitLamp.builder(this)
                .dependency(ProfileManager.class, profileManager)
                .dependency(DataStore.class, dataStore)
                .dependency(Scheduler.class, scheduler)
                .build();
        lamp.register(new ChunkClaimCommand(chunkClaimManager));

        getLogger().info("hodl has successfully started!");
    }

    @Override
    public void onDisable() {
        lamp.unregisterAllCommands();

        getLogger().info("hodl has successfully stopped!");
    }
}
