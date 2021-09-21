package com.callumstringer.csgoesport.core.player.web;

import com.callumstringer.csgoesport.base.BaseRequest;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class PlayerBaseReq extends BaseRequest {

    @NotNull
    private String name;

    @NotNull
    private  String username;

    private List<@Valid Id> teams;

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

    public List<Id> getTeams() {
        return teams;
    }

    public void setTeams(List<Id> teams) {
        this.teams = teams;
    }
}
