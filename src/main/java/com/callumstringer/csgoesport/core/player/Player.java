package com.callumstringer.csgoesport.core.player;

import com.callumstringer.csgoesport.core.team.Team;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "csgo_player")
@Proxy(lazy = false)
public class Player {

    @Id
    @Column(name = "id")
    @GenericGenerator(
            name= "csgo_player_id_seq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                @org.hibernate.annotations.Parameter(name = "sequence_name", value = "csgo_player_id_seq"),
                @org.hibernate.annotations.Parameter(name= "INCREMENT", value = "1"),
                @org.hibernate.annotations.Parameter(name = "MINVALUE", value = "1"),
                @org.hibernate.annotations.Parameter(name = "MAXVALUE", value = "2147483647"),
                @org.hibernate.annotations.Parameter(name = "CACHE", value = "1")
            }
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "csgo_player_id_seq")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(name = "csgo_player_team",
            joinColumns = { @JoinColumn(name = "id_player") },
            inverseJoinColumns = { @JoinColumn(name = "id_team") })
    @JsonIgnore
    private Set<Team> teams = new HashSet<>();

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

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

    public void addTeam(Team team){
        this.teams.add(team);
    }


}
