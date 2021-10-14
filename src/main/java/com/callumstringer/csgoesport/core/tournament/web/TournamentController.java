package com.callumstringer.csgoesport.core.tournament.web;

import com.callumstringer.csgoesport.core.tournament.Tournament;
import com.callumstringer.csgoesport.core.tournament.TournamentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {
    private final TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService){this.tournamentService = tournamentService;}

    //Create
    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public Tournament create(@RequestBody TournamentBaseReq req){ return tournamentService.create(req);}

    //Read
    @GetMapping("")
    @ResponseBody
    public List<Tournament> getTournaments(){return tournamentService.getTournaments();}

    @GetMapping("/{id}")
    @ResponseBody
    public Tournament getTournament(@PathVariable Long id){return tournamentService.getTournamentById(id);}

    //Update
    @PutMapping("/{id}")
    public Tournament updateTournament(@PathVariable(name = "id") Long id, @RequestBody @Valid TournamentBaseReq req){
        Tournament tournament = tournamentService.getTournamentById(id);
        return tournamentService.update(tournament,req);
    }

    //Delete
    @DeleteMapping("/{id}")
    public String deleteTournament(@PathVariable(name = "id") Long id){
        Tournament tournament = tournamentService.getTournamentById(id);
        try{
            tournamentService.delete(tournament);
            return "Tournament successfully deleted";
        }catch(Exception e){
            return e.toString();
        }
    }

}
