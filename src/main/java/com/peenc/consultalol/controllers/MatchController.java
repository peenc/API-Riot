package com.peenc.consultalol.controllers;

import com.peenc.consultalol.models.Match;
import com.peenc.consultalol.models.Summoner;
import com.peenc.consultalol.services.MatchService;
import com.peenc.consultalol.services.SummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;


@Controller
public class MatchController {

    @Autowired
    MatchService matchService;

    @Autowired
    SummonerService summonerService;

    @GetMapping("/{name}")
    public ModelAndView showHistory(@PathVariable("name") String name) throws IOException {
        Summoner summoner = summonerService.getSummoner(name);
        ModelAndView mv = new ModelAndView("invocador");
        List<Match> matchs = matchService.historyMatch(summoner.getPuuid());
        mv.addObject("matchs", matchs);
        mv.addObject("invocador", summoner);
        mv.addObject("ranks", summoner.getRanks());
        return mv;
    }


}
