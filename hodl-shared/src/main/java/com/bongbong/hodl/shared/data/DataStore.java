package com.bongbong.hodl.shared.data;

import com.bongbong.hodl.shared.profile.Profile;

import java.io.Closeable;
import java.util.UUID;

/**
 * The DataStore interface provides methods to persist and retrieve data.
 */
public interface DataStore extends Closeable {
    /**
     * Persists the given player profile to the data store.
     *
     * @param profile the profile containing player-related information to be saved
     */
    void saveProfile(Profile profile);

    /**
     * Loads and retrieves the player profile associated with the given player ID from the data store.
     *
     * @param playerId the unique identifier of the player whose profile is to be loaded
     * @return the Profile object containing player-related information
     */
    Profile loadProfile(UUID playerId);
}
