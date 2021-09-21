package com.callumstringer.csgoesport.core.match.web;

import com.callumstringer.csgoesport.base.BaseRequest;
import com.callumstringer.csgoesport.core.team.Team;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

public class MatchBaseReq extends BaseRequest {


    private Long id;


    private Integer tScore;


    private Integer ctScore;

    @NotNull
    private List<Team> csgo_match_teams;


    private Team winner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer gettScore() {
        return tScore;
    }

    public void settScore(Integer tScore) {
        this.tScore = tScore;
    }

    public Integer getCtScore() {
        return ctScore;
    }

    public void setCtScore(Integer ctScore) {
        this.ctScore = ctScore;
    }

    public List<Team> getCsgo_match_teams() {
        return csgo_match_teams;
    }

    public void setCsgo_match_teams(List<Team> csgo_match_teams) {
        this.csgo_match_teams = csgo_match_teams;
    }

    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }
}
