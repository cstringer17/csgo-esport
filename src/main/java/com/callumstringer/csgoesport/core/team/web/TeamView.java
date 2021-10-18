package com.callumstringer.csgoesport.core.team.web;

import com.callumstringer.csgoesport.core.tournament.Tournament;
import com.callumstringer.csgoesport.core.tournament.web.TournamentView;

public class TeamView {
    private long id;
    private String teamname;
    private TournamentView tournament;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public TournamentView getTournament() {
        return tournament;
    }

    public void setTournament(TournamentView tournament) {
        this.tournament = tournament;
    }

}
