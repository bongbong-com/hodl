package com.bongbong.hodl.shared.profile;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * This is the main data type for player-related information.
 *
 * @param playerId            unique ID of the Minecraft player
 * @param claims              a map of the worlds with their claims by this player (key is world name, value is list of claims)
 * @param allowedClaimEditors a set of player IDs that are allowed to edit this player's claims
 */
public record Profile(UUID playerId, Map<String, List<ProfileChunkClaim>> claims, Set<UUID> allowedClaimEditors) {
}
