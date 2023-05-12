package com.peenc.consultalol.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.peenc.consultalol.models.Summoner;
import com.peenc.consultalol.modelsDTO.LeagueEntryDTO;
import com.peenc.consultalol.modelsDTO.SummonerDTO;
import com.peenc.consultalol.services.SummonerService;

@Controller
public class SummonerController {
	
	
	@Autowired
	SummonerService ss;
	
	@GetMapping("/teste/invocador/{name}")
	public ResponseEntity<SummonerDTO> findByName(@PathVariable("name") String name) throws JsonMappingException, JsonProcessingException{
		SummonerDTO summoner = ss.getSummonerDTO(name);
		return ResponseEntity.ok(summoner);	
		}
	
	@GetMapping("/teste/invocador/{name}/ranked")
	public ResponseEntity<List<LeagueEntryDTO>> rankedByName(@PathVariable("name") String name) throws JsonMappingException, JsonProcessingException{
		SummonerDTO summoner = ss.getSummonerDTO(name);	
		List<LeagueEntryDTO> ledto = ss.getLeague(summoner.getId());
		return ResponseEntity.ok(ledto);
	}
	
	
	
	// refatorar esse metodo
	@GetMapping("/{name}")
	public ModelAndView showDataInvocador(@PathVariable("name") String name) throws JsonProcessingException {
		ModelAndView mv = new ModelAndView("invocador");
		Summoner summoner = ss.getSummoner(name);
		mv.addObject("invocador", summoner);
		mv.addObject("ranks", summoner.getRanks());
		return  mv;
	}

}
