package com.peenc.consultalol.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.peenc.consultalol.models.LeagueEntryDTO;
import com.peenc.consultalol.models.SummonerDTO;
import com.peenc.consultalol.services.SummonerService;

@Controller
public class SummonerController {
	
	
	@Autowired
	SummonerService ss;
	
	@GetMapping("/invocador/{name}")
	public ResponseEntity<SummonerDTO> findByName(@PathVariable("name") String name) throws JsonMappingException, JsonProcessingException{
		SummonerDTO summoner = ss.getSummoner(name);	
		return ResponseEntity.ok(summoner);	
		}
	
	@GetMapping("invocador/{name}/ranked")
	public ResponseEntity<List<LeagueEntryDTO>> rankedByName(@PathVariable("name") String name) throws JsonMappingException, JsonProcessingException{
		SummonerDTO summoner = ss.getSummoner(name);	
		List<LeagueEntryDTO> ledto = ss.getLeague(summoner.getId());
		return ResponseEntity.ok(ledto);
	}
	
	
	
}
