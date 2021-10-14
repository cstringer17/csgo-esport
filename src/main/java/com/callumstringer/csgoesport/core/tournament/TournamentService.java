package com.callumstringer.csgoesport.core.tournament;

import com.callumstringer.csgoesport.core.player.Player;
import com.callumstringer.csgoesport.core.player.PlayerRepo;
import com.callumstringer.csgoesport.core.player.web.PlayerBaseReq;
import com.callumstringer.csgoesport.core.team.TeamRepo;
import com.callumstringer.csgoesport.core.tournament.web.TournamentBaseReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentService {

    private final TournamentRepository tournamentRepository;

    public TournamentService(TournamentRepository tournementRepo) {
        this.tournamentRepository = tournementRepo;
    }

    public Tournament getTournamentById(long id){
        return tournamentRepository.getById(id);
    }

    public List<Tournament> getTournaments(){
        return  tournamentRepository.findAll();
    }

    public Tournament create(TournamentBaseReq req) {
        Tournament tournament = new Tournament();
        //Create Tournament logic
        return tournament;
    }

    public Tournament prepare(Tournament tournament, TournamentBaseReq tournamentBaseReq){
        tournament.setStages(tournamentBaseReq.getStages());
        tournament.setTeams(tournamentBaseReq.getTeams());
        return tournament;
    }

    public Tournament update(Tournament tournament, TournamentBaseReq req){
        Tournament newTournament = this.prepare(tournament,req);
        Tournament tournamentSave = tournamentRepository.save(newTournament);
        return tournamentSave;
    }

    public void delete(Tournament tournament){
        tournamentRepository.delete(tournament);
    }
}
