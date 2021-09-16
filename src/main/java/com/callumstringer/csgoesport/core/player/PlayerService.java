package com.callumstringer.csgoesport.core.player;

import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    private final PlayerRepo playerRepo;


    public PlayerService(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    public Player getPlayer(Long id) {
        return playerRepo.getById(id);
    }
}
