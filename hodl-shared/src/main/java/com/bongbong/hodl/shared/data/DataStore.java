package com.bongbong.hodl.shared.data;

import com.bongbong.hodl.shared.profile.Profile;

import java.util.UUID;

public interface DataStore {
    void saveProfile(Profile profile);

    Profile loadProfile(UUID playerId);
}
