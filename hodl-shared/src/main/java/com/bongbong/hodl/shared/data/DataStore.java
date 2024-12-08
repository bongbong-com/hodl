package com.bongbong.hodl.shared.data;

import com.bongbong.hodl.shared.profile.Profile;

import java.io.Closeable;
import java.util.UUID;

public interface DataStore extends Closeable {
    void saveProfile(Profile profile);

    Profile loadProfile(UUID playerId);
}
