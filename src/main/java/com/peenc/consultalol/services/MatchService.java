package com.peenc.consultalol.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.peenc.consultalol.models.Match;
import com.peenc.consultalol.modelsDTO.MatchDTO;
import com.peenc.consultalol.modelsDTO.ParticipantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService {
    @Autowired
    private ApiService service;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SummonerService summonerService;

    private String URL_BY_SPLASHES ="https://raw.communitydragon.org/latest/plugins/rcp-be-lol-game-data/global/default/v1/champion-splashes/";
    private String URL_MATCH = "https://americas.api.riotgames.com/lol/match/v5/matches/";

    public MatchDTO getMatchDTO(String puuId) throws IOException {
        String partida = IdMatch(puuId);
        String url = URL_MATCH + partida + "?api_key=" + service.getKey();
        String jsonString = service.getJsonFromHistory(url);
        MatchDTO matchDTO = objectMapper.readValue(jsonString, MatchDTO.class);
        return matchDTO;
    }

    public ArrayList<MatchDTO> getListMatchs(String puuID) throws JsonProcessingException {
        List<String> strings = summonerService.listMatchs(puuID);
        String url;
        ArrayList<MatchDTO> listMatch = new ArrayList<>();
        for (String s: strings) {
            url = URL_MATCH +  s + "?api_key=" + service.getKey();
            String jsonString = service.getJsonFromHistory(url);
            listMatch.add(objectMapper.readValue(jsonString, MatchDTO.class));
        }
        return  listMatch;
    }

    public String IdMatch(String puuID) throws JsonProcessingException {
        List<String> idMatchs = summonerService.listMatchs(puuID);
        String match = idMatchs.get(0);
        return match;
    }


    public ArrayList<Match> historyMatch(String puuid) throws IOException {
        ArrayList<MatchDTO> matchDTO = getListMatchs(puuid);

        ArrayList<Match> listMatch= new ArrayList<>();

        for (MatchDTO matchDTO1: matchDTO) {
            Match match = new Match();
            ParticipantDTO pt  = matchDTO1.getInfo().getParticipants().stream().filter(f -> f.getPuuid().equals(puuid)).findFirst().orElseThrow();
            match.setKill(pt.getKills());
            match.setAssist(pt.getAssists());
            match.setDeath(pt.getDeaths());
            match.setKda(pt.getChallenges().getKda());
            match.setTimeMatch(matchDTO1.getInfo().getTimeDuration());
            match.setFarm(pt.getTotalMinionsKilled());
            match.setResulMatch(pt.getResulMatch());
            match.setNameChampion(pt.getChampionName());
            match.setQueue(matchDTO1.getInfo().getGameMode());
            match.setChampionId(pt.getChampionId());
            match.setUrlImgChampion(splashArt(pt.getChampionId()));
            listMatch.add(match);
        }
        return listMatch;
    }
        public String splashArt(int idChampion) {
            return URL_BY_SPLASHES + idChampion + "/" + idChampion+"000.jpg";
        }

}
