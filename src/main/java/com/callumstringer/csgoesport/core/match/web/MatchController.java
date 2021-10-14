package com.callumstringer.csgoesport.core.match.web;


import com.callumstringer.csgoesport.core.match.Match;
import com.callumstringer.csgoesport.core.match.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {
    private final MatchService matchService;

    public MatchController(MatchService matchService){
        this.matchService = matchService;
    }

    //Create
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Match create (@RequestBody MatchBaseReq req){return matchService.createEmptyMatch(req);}

    //Read
    @GetMapping("")
    @ResponseBody
    public List<Match> getMatches(){return matchService.getMatchs();}

    @GetMapping("/{id}")
    @ResponseBody
    public Match getMatch(@PathVariable Long id){return matchService.getMatch(id);}

    //Update
    @PutMapping("/{id}")
    public Match updateMatch(@PathVariable(name="id") Long id, @RequestBody @Valid MatchBaseReq req){
        Match match = matchService.getMatch(id);
        return matchService.update(match, req);
    }

    //Delete

    public String deleteMatch (@PathVariable(name="id") Long id ){
        Match match = matchService.getMatch(id);
        try{
            matchService.delete(match);
            return "Match has been successfully deleted";
        }catch(Exception e){
            return e.toString();
        }
    }



}
