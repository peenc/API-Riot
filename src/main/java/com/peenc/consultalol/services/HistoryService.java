package com.peenc.consultalol.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.peenc.consultalol.models.Summoner;
import com.peenc.consultalol.modelsDTO.MatchDTO;
import com.peenc.consultalol.modelsDTO.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@Service
public class HistoryService {
    @Autowired
    private ApiService service;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SummonerService summonerService;
    @Autowired
    private RestTemplate rt;


    private String query = "https://americas.api.riotgames.com/lol/match/v5/matches/";

    public Root getMatchDTO(String puuId) throws JsonProcessingException {
        String partida = IdPartida(puuId);
        try {
            String url = query + partida + "?api_key=" + service.getKey();
            String jsonResponse = service.getJsonFromExternalApi(url);
            Root root = objectMapper.readValue(jsonResponse, Root.class);
            System.out.println(root);

        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("ERRO");
        }
        return null;
    }

    public String IdPartida(String puuID) throws JsonProcessingException {
        List<String> idPartidas = summonerService.listMatchs(puuID);
        String partida = idPartidas.get(0);
        return partida;
    }


}
