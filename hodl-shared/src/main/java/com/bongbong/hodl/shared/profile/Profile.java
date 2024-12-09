package com.bongbong.hodl.shared.profile;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public record Profile(UUID playerId, List<ProfileChunkClaim> claims, Set<UUID> allowedClaimEditors) {
}
