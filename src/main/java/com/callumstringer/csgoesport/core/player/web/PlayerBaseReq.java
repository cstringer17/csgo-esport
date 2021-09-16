package com.callumstringer.csgoesport.core.player.web;

import com.callumstringer.csgoesport.base.BaseRequest;

import javax.validation.constraints.NotNull;

public class PlayerBaseReq extends BaseRequest {

    @NotNull
    private String name;

    @NotNull
    private  String username;

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
}
