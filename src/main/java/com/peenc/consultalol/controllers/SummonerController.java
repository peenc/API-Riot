package com.peenc.consultalol.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.peenc.consultalol.models.LeagueEntryDTO;
import com.peenc.consultalol.models.SummonerDTO;
import com.peenc.consultalol.services.SummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SummonerController {
	
	
	@Autowired
	SummonerService ss;
	
	@GetMapping("/teste/invocador/{name}")
	public ResponseEntity<SummonerDTO> findByName(@PathVariable("name") String name) throws JsonMappingException, JsonProcessingException{
		SummonerDTO summoner = ss.getSummoner(name);
		return ResponseEntity.ok(summoner);	
		}
	
	@GetMapping("/teste/invocador/{name}/ranked")
	public ResponseEntity<List<LeagueEntryDTO>> rankedByName(@PathVariable("name") String name) throws JsonMappingException, JsonProcessingException{
		SummonerDTO summoner = ss.getSummoner(name);	
		List<LeagueEntryDTO> ledto = ss.getLeague(summoner.getId());
		return ResponseEntity.ok(ledto);
	}
	
	// refatorar esse metodo
	@GetMapping("/{name}")
	public ModelAndView showDataInvocador(@PathVariable("name") String name) throws JsonProcessingException {
		ModelAndView mv = new ModelAndView("invocador");

		// criar uma classe para pegar essas informaçoes
		String tierRankedFlex = ss.getSummonerTier(ss.getSummoner(name).getName(),0);
		String nameImage = ss.getUrlImage(name);
		String rankFlex = ss.getSummonerRank(ss.getSummoner(name).getName(),0);
		String rankSolo = ss.getSummonerRank(ss.getSummoner(name).getName(),1);
		String tierRankedSolo = ss.getSummonerTier(ss.getSummoner(name).getName(),1);
		int pdlFlex = ss.getSummonerLeaguePoints(ss.getSummoner(name).getName(),0);
		int pdlSolo = ss.getSummonerLeaguePoints(ss.getSummoner(name).getName(),1);

		SummonerDTO invocador = ss.getSummoner(name);

		mv.addObject("invocador",invocador);
		mv.addObject("urlImg", nameImage);
		// verificar quando nao tiver elo
		mv.addObject("tierFlex",tierRankedFlex);
		mv.addObject("rankFlex",rankFlex);
		mv.addObject("tierSolo",tierRankedSolo);
		mv.addObject("rankSolo",rankSolo);
		mv.addObject("pdlFlex",pdlFlex);
		mv.addObject("pdlSolo",pdlSolo);

		return  mv;
	}

}
