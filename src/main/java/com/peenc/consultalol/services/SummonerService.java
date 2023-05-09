package com.peenc.consultalol.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.peenc.consultalol.models.ChampionInfoIds;
import com.peenc.consultalol.models.LeagueEntryDTO;
import com.peenc.consultalol.models.SummonerDTO;

@Service
public class SummonerService {
		
	@Autowired
	ApiService service;	
	
	@Autowired
    private ObjectMapper objectMapper;
	
	public SummonerDTO getSummoner(String name) throws JsonMappingException, JsonProcessingException {
		String jsonResponse = service.getJsonFromExternalApi("https://br1.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+ name +"?api_key="+service.getKey());
		SummonerDTO summoner = objectMapper.readValue(jsonResponse, SummonerDTO.class);
		
		return summoner;
	}
	
	public List<LeagueEntryDTO> getLeague(String id) throws JsonMappingException, JsonProcessingException {
		String jsonResponse = service.getJsonFromExternalApi("https://br1.api.riotgames.com/lol/league/v4/entries/by-summoner/"+id+""+ service.getKey());
		LeagueEntryDTO[] ledto = objectMapper.readValue(jsonResponse, LeagueEntryDTO[].class);
		List<LeagueEntryDTO> list =  Arrays.asList(ledto);
		return list;
	}
	
	public  List<Integer> getFreeWeek() throws JsonMappingException, JsonProcessingException{
		String jsonResponse = service.getJsonFromExternalApi("https://br1.api.riotgames.com/lol/platform/v3/champion-rotations?api_key="+service.getKey());
		ChampionInfoIds cii = objectMapper.readValue(jsonResponse, ChampionInfoIds.class);			
			return cii.getFreeChampionIds();
	}
	
	
}
