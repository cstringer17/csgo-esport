package com.callumstringer.csgoesport.core.match;

import com.callumstringer.csgoesport.core.match.web.MatchBaseReq;
import com.callumstringer.csgoesport.core.team.TeamRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    private final MatchRepo matchRepo;
    private final TeamRepo teamRepo;

    public MatchService(MatchRepo matchRepo, TeamRepo teamRepo) {
        this.teamRepo = teamRepo;
        this.matchRepo = matchRepo;
    }


    public Match getMatch(Long id) {
        return matchRepo.getById(id);
    }

    public List<Match> getMatchs() {return matchRepo.findAll();}

    public Match createEmptyMatch(MatchBaseReq req) {
        Match match = new Match();
        this.prepare(match, req);
        Match matchSave = matchRepo.save(match);
        return matchSave;
    }

    public Match createFinalMatch(MatchBaseReq req){
        Match match = new Match();
        match = matchRepo.getById(req.getId());
        match.setWinner(req.getWinner());
        match.setTScore(req.gettScore());
        match.setCtScore(req.getCtScore());

        Match matchsave = matchRepo.save(match);
        return matchsave;
    }

    public Match prepare(Match match, MatchBaseReq matchBaseReq){
        match.setCsgo_match_teams(matchBaseReq.getCsgo_match_teams());
        match.setCtScore(matchBaseReq.getCtScore());
        match.setTScore(match.getTScore());
        match.setWinner(match.getWinner());
        return match;
    }

    public Match update(Match match, MatchBaseReq req){
        Match newMatch = this.prepare(match,req);
        Match matchSave = matchRepo.save(newMatch);
        return matchSave;
    }

    public void delete(Match match){
        matchRepo.delete(match);
    }
}
