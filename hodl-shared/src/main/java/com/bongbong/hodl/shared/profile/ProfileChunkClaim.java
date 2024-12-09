package com.bongbong.hodl.shared.profile;

/**
 * Represents a claim for a chunk based on its world location.
 *
 * @param x the chunk x
 * @param z the chunk z
 */
public record ProfileChunkClaim(int x, int z) {
}