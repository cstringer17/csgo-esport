package com.callumstringer.csgoesport.core.team;

import org.springframework.stereotype.Service;

@Service
public class TeamService {
    private final TeamRepo teamRepo;

    public TeamService(TeamRepo teamRepo) {
        this.teamRepo = teamRepo;
    }


}
