package com.callumstringer.csgoesport.core.team.converter;

import com.callumstringer.csgoesport.core.player.Player;
import com.callumstringer.csgoesport.core.player.web.PlayerView;
import com.callumstringer.csgoesport.core.team.Team;
import com.callumstringer.csgoesport.core.team.web.TeamView;
import com.callumstringer.csgoesport.core.tournament.Tournament;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class TeamToTeamViewConverter implements Converter<Team, TeamView> {
    @Override
    public TeamView convert(@NonNull Team team) {
        TeamView view = new TeamView();
        view.setId(team.getId());
        view.setTeamname(team.getTeamname());
        //view.setTournament(team.getTournament());
        return view;
    }
}
