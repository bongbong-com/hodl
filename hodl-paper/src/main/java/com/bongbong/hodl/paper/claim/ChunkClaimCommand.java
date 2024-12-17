package com.bongbong.hodl.paper.claim;

import org.bukkit.entity.Player;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Description;

public class ChunkClaimCommand {
    private final ChunkClaimManager manager;

    public ChunkClaimCommand(ChunkClaimManager manager) {
        this.manager = manager;
    }

    @Command("claim")
    @Description("Attempts to claim the chunk the player is standing in.")
    public void on(Player sender) {
        // TODO:
        // - check if chunk is already claimed
        // - check if player has enough $$$
        // - claim it
        // - asynchronously save data to db
    }
}
