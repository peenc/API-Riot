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
import com.peenc.consultalol.modelsDTO.ChampionMasteryDTO;
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
	private String URL_BY_MATCHS = "https://americas.api.riotgames.com/lol/match/v5/matches/by-puuid/";
	private String URL_BY_CHAMPSMASTERIES = "https://br1.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-summoner/";
	private String URL_BY_SPLASHES = "https://raw.communitydragon.org/latest/plugins/rcp-be-lol-game-data/global/default/v1/champion-splashes/";
	
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

		try {
			rankSoloDuo.setTier(league.get(1).getTier());
			rankSoloDuo.setRanking(league.get(1).getRank());
			rankSoloDuo.setPdl(league.get(1).getLeaguePoints());
			rankSoloDuo.setQueue(league.get(1).getQueueType().replace("_", " "));
			rankSoloDuo.setWins(league.get(1).getWins());
			rankSoloDuo.setLosses(league.get(1).getLosses());
			rankSoloDuo.setNameImageTier(URL_BY_ICON_RANK + league.get(1).getTier().toLowerCase() + ".png");
			rankSoloDuo.Winrate();
			if (league.get(1).getMiniSeries() != null) {
				rankFlex.setMiniSeries(league.get(1).getMiniSeries());

			}
			list.add(rankSoloDuo);
		} catch (ArrayIndexOutOfBoundsException e) {

		}

		try {
			rankFlex.setTier(league.get(0).getTier());
			rankFlex.setRanking(league.get(0).getRank());
			rankFlex.setPdl(league.get(0).getLeaguePoints());
			rankFlex.setWins(league.get(0).getWins());
			rankFlex.setLosses(league.get(0).getLosses());

			rankFlex.setQueue(league.get(0).getQueueType().replace("_", " "));
			rankFlex.setNameImageTier(URL_BY_ICON_RANK + league.get(0).getTier().toLowerCase() + ".png");
			rankFlex.Winrate();
			if (league.get(0).getMiniSeries() != null) {
				rankFlex.setMiniSeries(league.get(0).getMiniSeries());
			}
			list.add(rankFlex);
		} catch (ArrayIndexOutOfBoundsException e) {

		}

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
		summoner.setImageTopMasteries(splashArtChampionTopMasteries(listIdChampsMasteries(summoner.getId())));

		List<Rank> list = getSummonerRank(name);

		if (!list.isEmpty()) {
			summoner.setRanks(list);
		}

		return summoner;
	}
	
	public List<String> listMatchs(String puuid) throws JsonMappingException, JsonProcessingException{
		String jsonResponse = service.getJsonFromExternalApi(URL_BY_MATCHS + puuid + "/ids?start=0&count=20&api_key=" + service.getKey());
		String[] string = objectMapper.readValue(jsonResponse, String[].class);
		List<String> matchs = Arrays.asList(string);
		return matchs;
	}
	
	public List<Long> listIdChampsMasteries(String id) throws JsonMappingException, JsonProcessingException{
		String jsonResponse = service.getJsonFromExternalApi(URL_BY_CHAMPSMASTERIES + id  + "/top?api_key=" + service.getKey());
		ChampionMasteryDTO[] cmdto = objectMapper.readValue(jsonResponse, ChampionMasteryDTO[].class);
		List<ChampionMasteryDTO> listCmdto = Arrays.asList(cmdto);
		List<Long> listIdChamps = new ArrayList<>();
		for(ChampionMasteryDTO c : listCmdto) {
			listIdChamps.add(c.getChampionId());
		}
		return listIdChamps;
	}
	
	public String splashArtChampionTopMasteries(List<Long> list) {
		return URL_BY_SPLASHES + list.get(0) + "/" + list.get(0)+"000.jpg";
	}
	
}
