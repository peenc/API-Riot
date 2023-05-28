package com.peenc.consultalol.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.peenc.consultalol.models.Match;
import com.peenc.consultalol.modelsDTO.MatchDTO;
import com.peenc.consultalol.modelsDTO.ParticipantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService {
    @Autowired
    private ApiService service;

    @Autowired
    private SummonerService summonerService;

    private String URL_BY_SPLASHES ="https://raw.communitydragon.org/latest/plugins/rcp-be-lol-game-data/global/default/v1/champion-splashes/";
    private String URL_MATCH = "https://americas.api.riotgames.com/lol/match/v5/matches/";


    public List<MatchDTO> getMatchs(String puuid) throws JsonProcessingException {
        List<String> strings = summonerService.listMatchs(puuid);
        String url;
        ArrayList<MatchDTO> listMatch = new ArrayList<>();

        for (String s: strings) {
            url = URL_MATCH +  s + "?api_key=" + service.getKey();
            listMatch.add(new RestTemplate().exchange(url,
                    HttpMethod.GET,
                    null,
                    MatchDTO.class).getBody());
        }
        return  listMatch;

    }

    public ArrayList<Match> historyMatch(String puuid) throws IOException {
        List<MatchDTO> matchDTO = getMatchs(puuid);
        ArrayList<Match> listMatch= new ArrayList<>();

        for (MatchDTO matchDTO1: matchDTO) {
            Match match = buildMatch(puuid, matchDTO1);
            listMatch.add(match);
        }
        return listMatch;
    }

    private Match buildMatch(String puuid, MatchDTO matchDTO1) {
        Match match = new Match();
        ParticipantDTO pt  = matchDTO1.getInfo().getParticipants().stream().filter(f -> f.getPuuid().equals(puuid)).findFirst().orElseThrow();
        match.setKill(pt.getKills());
        match.setAssist(pt.getAssists());
        match.setDeath(pt.getDeaths());
        match.setKda(pt.getChallenges().getKda());
        match.setTimeDuration(Match.getGameDuration(matchDTO1.getInfo().getGameDuration()));
        match.setFarm(pt.getTotalMinionsKilled());
        match.setResulMatch(pt.getResulMatch());
        match.setNameChampion(pt.getChampionName());
        match.setQueue(matchDTO1.getInfo().getGameMode());
        match.setChampionId(pt.getChampionId());
        match.setUrlImgChampion(splashArt(pt.getChampionId()));
        return match;
    }

    public String splashArt(int idChampion) {
            return URL_BY_SPLASHES + idChampion + "/" + idChampion+"000.jpg";
        }

}
