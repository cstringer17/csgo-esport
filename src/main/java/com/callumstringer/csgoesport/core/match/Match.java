package com.callumstringer.csgoesport.core.match;

import com.callumstringer.csgoesport.core.team.Team;

import javax.persistence.*;
import java.util.List;

@Table(name = "match")
@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "t_score", nullable = false)
    private Integer tScore;

    @Column(name = "ct_score", nullable = false)
    private Integer ctScore;

    @ManyToMany
    @JoinTable(name = "match_teams",
            joinColumns = @JoinColumn(name = "match_id"),
            inverseJoinColumns = @JoinColumn(name = "teams_id"))
    private List<Team> csgo_match_teams;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "winner_id")
    private Team winner;

    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }

    public List<Team> getCsgo_match_teams() {
        return csgo_match_teams;
    }

    public void setCsgo_match_teams(List<Team> csgo_match_teams) {
        this.csgo_match_teams = csgo_match_teams;
    }

    public Integer getCtScore() {
        return ctScore;
    }

    public void setCtScore(Integer ctScore) {
        this.ctScore = ctScore;
    }

    public Integer getTScore() {
        return tScore;
    }

    public void setTScore(Integer tScore) {
        this.tScore = tScore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}