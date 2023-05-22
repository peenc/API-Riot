package com.peenc.consultalol.controllers;

import com.peenc.consultalol.models.Match;
import com.peenc.consultalol.models.Summoner;
import com.peenc.consultalol.modelsDTO.MatchDTO;
import com.peenc.consultalol.modelsDTO.SummonerDTO;
import com.peenc.consultalol.services.MatchService;
import com.peenc.consultalol.services.SummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;

@Controller
public class MatchController {

    @Autowired
    MatchService matchService;

    @Autowired
    SummonerService summonerService;

    @GetMapping("/historio/teste/{name}")
    public ResponseEntity<MatchDTO> history(@PathVariable("name") String name) throws IOException {
        SummonerDTO summoner = summonerService.getSummonerDTO(name);
        MatchDTO matchDTO = matchService.getMatchDTO(summoner.getPuuid());
        return ResponseEntity.ok(matchDTO);
    }

    @GetMapping("/historico/{name}")
    public ModelAndView showHistory(@PathVariable("name") String name) throws IOException {
        Summoner summoner = summonerService.getSummoner(name);
        ModelAndView mv = new ModelAndView("history");
        ArrayList<Match> matchs = matchService.historyMatch(summoner.getPuuid());
        mv.addObject("matchs", matchs);
        return mv;
    }


}
