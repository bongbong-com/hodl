package com.bongbong.hodl.shared.profile;

import com.bongbong.hodl.shared.data.DataStore;
import com.bongbong.hodl.shared.util.Scheduler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class AbstractProfileManager implements ProfileManager {
    protected final Map<UUID, Profile> profiles = new HashMap<>();
    protected final DataStore dataStore;
    protected final Scheduler scheduler;

    protected AbstractProfileManager(DataStore dataStore, Scheduler scheduler) {
        this.dataStore = dataStore;
        this.scheduler = scheduler;
    }

    @Override
    public @NotNull Map<UUID, Profile> getCachedProfiles() {
        return profiles;
    }

    @Override
    public @Nullable Profile getProfile(@NotNull UUID playerId) {
        return profiles.get(playerId);
    }

    @Override
    public void saveProfile(@NotNull Profile profile) {
        dataStore.saveProfile(profile);
    }

    @Override
    public void saveProfileAsync(@NotNull Profile profile) {
        scheduler.runAsync(() -> saveProfile(profile));
    }

    @Override
    public @Nullable Profile loadProfile(@NotNull UUID playerId) {
        return dataStore.loadProfile(playerId);
    }
}
