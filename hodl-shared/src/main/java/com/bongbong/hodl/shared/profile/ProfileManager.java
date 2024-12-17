package com.bongbong.hodl.shared.profile;

import com.bongbong.hodl.shared.lightning.Requests;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;

/**
 * The ProfileManager interface provides methods for managing player profiles.
 * It allows the retrieval, creation, and saving of Profile
 * instances, utilizing caching for performance optimization.
 */
public interface ProfileManager {
    /**
     * Retrieves a cached map of player profiles. The map contains
     * profiles indexed by their unique player UUIDs.
     *
     * @return a non-null map where the keys are UUIDs representing player IDs
     * and the values are Profile instances associated with those IDs.
     * This map may be empty if no profiles are currently cached.
     */
    @NotNull
    Map<UUID, Profile> getCachedProfiles();

    /**
     * Retrieves the profile associated with the specified player ID. If the profile
     * is cached, it is returned directly. If no profile is found in cache, null is returned.
     *
     * @param playerId the unique identifier of the player whose profile is to be
     *                 retrieved; must not be null
     * @return the Profile associated with the given player ID, or null if no profile
     * is found in cache (Note: The profile may still be in database.)
     */
    @Nullable
    Profile getProfile(@NotNull UUID playerId);

    /**
     * Creates a new instance of a player's profile with the specified unique player ID.
     * The profile is initialized with an empty map of claims and an empty set of allowed claim editors.
     * <p>
     * Note: Depending on the implementation, this may or may not save the profile to cache or database.
     *
     * @param playerId the unique identifier of the player for whom the profile is being created; must not be null
     * @return a newly created Profile instance associated with the given player ID, containing no initial claims or allowed editors
     */
    @NotNull
    default Profile createProfile(@NotNull UUID playerId) {
        return new Profile(playerId, new HashMap<>(), new HashSet<>(), null);
    }

    /**
     * Persists the given player profile. This method should be implemented
     * to handle the storage of the profile data, ensuring that any changes
     * made to the profile are saved appropriately.
     *
     * @param profile the Profile instance representing the player's data
     *                that is to be saved; must not be null
     */
    void saveProfile(@NotNull Profile profile);

    void saveProfileAsync(@NotNull Profile profile);

    /**
     * Loads the profile of a player synchronously based on the specified player ID. The profile
     * is retrieved from a database and may or may not already be cached. This method
     * should handle retrieving the profile by its unique identifier.
     * <p>
     * Note: Depending on the implementation, loading a profile may or may not put it in cache.
     *
     * @param playerId the unique identifier of the player whose profile is to be loaded;
     *                 must not be null
     * @return the loaded Profile associated with the given player ID, or null if no profile
     * is found in database
     */
    @Nullable
    Profile loadProfile(@NotNull UUID playerId);
}
