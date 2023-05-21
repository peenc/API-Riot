package com.peenc.consultalol.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.peenc.consultalol.modelsDTO.Root;
import com.peenc.consultalol.modelsDTO.SummonerDTO;
import com.peenc.consultalol.services.HistoryService;
import com.peenc.consultalol.services.SummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HistoryController {

    @Autowired
    HistoryService historyService;

    @Autowired
    SummonerService summonerService;

    @GetMapping("/vou/aqui/{name}")
    public ResponseEntity<Root> history(@PathVariable("name") String name) throws JsonProcessingException {
        SummonerDTO summoner = summonerService.getSummonerDTO(name);
        Root root = historyService.getMatchDTO(summoner.getPuuid());
        return ResponseEntity.ok(root);
    }

}
