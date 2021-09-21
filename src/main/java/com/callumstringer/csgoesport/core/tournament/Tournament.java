package com.callumstringer.csgoesport.core.tournament;

import com.callumstringer.csgoesport.core.match.Match;
import com.callumstringer.csgoesport.core.stage.Stage;
import com.callumstringer.csgoesport.core.team.Team;

import javax.persistence.*;
import java.security.KeyPair;
import java.util.List;

@Table(name = "tournament")
@Entity
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    @OneToMany(mappedBy = "tournament")
    private List<Team> teams;

    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Stage> stages;

    public List<Stage> getStages() {
        return stages;
    }

    public void setStages(List<Stage> stages) {
        this.stages = stages;
    }

    public Tournament(){
        int amountOfTeams = teams.size();
        if ( amountOfTeams % 2 != 0 ){
            generateMatches(amountOfTeams+1);
        }else{
            generateMatches(amountOfTeams);
        }
    }

    private void generateMatches(int amountOfTeams){

    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

