package com.peenc.consultalol.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.peenc.consultalol.models.Rank;
import com.peenc.consultalol.models.Summoner;
import com.peenc.consultalol.modelsDTO.LeagueEntryDTO;
import com.peenc.consultalol.modelsDTO.SummonerDTO;

@Service
public class SummonerService {

	@Autowired
	ApiService service;

	@Autowired
	private ObjectMapper objectMapper;

	private String URL_ICON = "https://raw.communitydragon.org/latest/plugins/rcp-be-lol-game-data/global/default/v1/profile-icons/";
	private String URL_BY_Name = "https://br1.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
	private String URL_BY_SUMMONER = "https://br1.api.riotgames.com/lol/league/v4/entries/by-summoner/";
	private String URL_BY_ICON_RANK = "https://raw.communitydragon.org/latest/plugins/rcp-fe-lol-static-assets/global/default/ranked-emblem/emblem-";

	public SummonerDTO getSummonerDTO(String name) throws JsonMappingException, JsonProcessingException {
		String jsonResponse = service.getJsonFromExternalApi(URL_BY_Name + name + "?api_key=" + service.getKey());
		SummonerDTO summoner = objectMapper.readValue(jsonResponse, SummonerDTO.class);
		return summoner;
	}

	public List<LeagueEntryDTO> getLeague(String id) throws JsonMappingException, JsonProcessingException {
		String jsonResponse = service.getJsonFromExternalApi(URL_BY_SUMMONER + id + "?api_key=" + service.getKey());
		LeagueEntryDTO[] ledto = objectMapper.readValue(jsonResponse, LeagueEntryDTO[].class);
		List<LeagueEntryDTO> list = Arrays.asList(ledto);
		return list;
	}

	public List<Rank> getSummonerRank(String name) throws JsonMappingException, JsonProcessingException {
		List<Rank> list = new ArrayList<>();
		Rank rankFlex = new Rank();
		Rank rankSoloDuo = new Rank();
		SummonerDTO summoner = getSummonerDTO(name);
		List<LeagueEntryDTO> league = getLeague(summoner.getId());
		rankFlex.setTier(league.get(0).getTier());
		rankFlex.setName(league.get(0).getRank());
		rankFlex.setPdl(league.get(0).getLeaguePoints());
		rankFlex.setQueue("Ranked Flex ");
		rankSoloDuo.setTier(league.get(1).getTier());
		rankSoloDuo.setName(league.get(1).getRank());
		rankSoloDuo.setPdl(league.get(1).getLeaguePoints());
		rankSoloDuo.setQueue("Ranked Solo/Duo ");
		rankFlex.setNameImageTier(URL_BY_ICON_RANK+league.get(0).getTier().toLowerCase()+".png");
		rankSoloDuo.setNameImageTier(URL_BY_ICON_RANK+league.get(1).getTier().toLowerCase()+".png");

		list.add(rankFlex);
		list.add(rankSoloDuo);
		return list;
	}

	public String getUrlImage(String name) throws JsonProcessingException {
		SummonerDTO summer = getSummonerDTO(name);
		return URL_ICON + summer.getProfileIconId() + ".jpg";
	}

	public Summoner getSummoner(String name) throws JsonProcessingException {

		SummonerDTO summonerDTO = getSummonerDTO(name);
		Summoner summoner = new Summoner();

		summoner.setNameImage(getUrlImage(name));
		summoner.setId(summonerDTO.getId());
		summoner.setName(summonerDTO.getName());
		summoner.setSummonerLevel(summonerDTO.getSummonerLevel());

		summoner.setRanks(getSummonerRank(name));
		return summoner;
	}
}
