package com.peenc.consultalol.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.peenc.consultalol.models.ChampionInfoIds;

@Service
public class IndexService {
		
	
	@Autowired
	ApiService service;

	@Autowired
	private ObjectMapper objectMapper;
	
	private String URL_ICON_CHAMP = "https://raw.communitydragon.org/latest/plugins/rcp-be-lol-game-data/global/default/v1/champion-icons/";
	private String URL_FREEWEEK = "https://br1.api.riotgames.com/lol/platform/v3/champion-rotations?api_key=";
	
	public List<Integer> getFreeWeek() throws JsonMappingException, JsonProcessingException {
		String jsonResponse = service.getJsonFromExternalApi(URL_FREEWEEK + service.getKey());
		ChampionInfoIds cii = objectMapper.readValue(jsonResponse, ChampionInfoIds.class);
		return cii.getFreeChampionIds();
	}
	
	public List<String> getListConvertString() throws JsonProcessingException {
		List<String> listaStrings = getFreeWeek().stream().map(Object::toString).collect(Collectors.toList());
		return listaStrings;
	}

	public List<String> getUrlListIcon() throws JsonProcessingException {
		List<String> listaUrl = getFreeWeek().stream().map(s -> URL_ICON_CHAMP + s + ".png")
				.collect(Collectors.toList());
		return listaUrl;
	}
}
