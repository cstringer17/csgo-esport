package com.callumstringer.csgoesport.core.player.converter;

import com.callumstringer.csgoesport.core.player.Player;
import com.callumstringer.csgoesport.core.player.web.PlayerView;
import com.callumstringer.csgoesport.core.team.Team;
import com.callumstringer.csgoesport.core.team.converter.TeamToTeamViewConverter;
import com.callumstringer.csgoesport.core.team.web.TeamView;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
class PlayerToPlayerViewConverter implements Converter<Player, PlayerView> {

    private final TeamToTeamViewConverter teamToTeamViewConverter;

    public PlayerToPlayerViewConverter(TeamToTeamViewConverter teamToTeamViewConverter) {
        this.teamToTeamViewConverter = teamToTeamViewConverter;
    }

    @Override
    public PlayerView convert(@NonNull Player player) {
        PlayerView view = new PlayerView();
        view.setId(player.getId());
        view.setName(player.getName());
        view.setUsername(player.getUsername());
        Set<TeamView> views = new HashSet<>();
        Set<Team> teams= player.getTeams();
        teams.forEach(team -> {
            TeamView teamView = teamToTeamViewConverter.convert(team);
            views.add(teamView);
        });
        view.setTeams(views);
        return view;
    }
}
