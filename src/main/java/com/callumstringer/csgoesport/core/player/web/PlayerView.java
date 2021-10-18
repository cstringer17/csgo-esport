package com.callumstringer.csgoesport.core.player.web;

import com.callumstringer.csgoesport.core.team.web.TeamView;

import java.util.HashSet;
import java.util.Set;

public class PlayerView {

    private long id;
    private String name;
    private String username;
    private Set<TeamView> teams = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<TeamView> getTeams() {
        return teams;
    }

    public void setTeams(Set<TeamView> teams) {
        this.teams = teams;
    }
}
