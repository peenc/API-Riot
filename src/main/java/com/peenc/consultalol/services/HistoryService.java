package com.peenc.consultalol.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.peenc.consultalol.modelsDTO.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

@Service
public class HistoryService {
    @Autowired
    private ApiService service;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SummonerService summonerService;


    private String query = "https://americas.api.riotgames.com/lol/match/v5/matches/";

    public Root getMatchDTO(String puuId) throws IOException {
        String partida = IdPartida(puuId);

//            String url = query + partida + "?api_key=" + service.getKey();
//            StringBuilder resultado = restTemplate.getForObject(url, StringBuilder.class);
//        System.out.println(resultado.toString());
        String url = "https://americas.api.riotgames.com/lol/match/v5/matches/BR1_2733730590?api_key=RGAPI-4ff94d05-6235-40f3-b83d-4124add77ed1";

        try {
            // Faz a solicitação HTTP GET
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            // Verifica se a solicitação foi bem-sucedida (código de status 200 indica sucesso)
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // Lê a resposta da solicitação
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Converte a resposta JSON em uma string
                String json = response.toString();

                // Imprime a string resultante
//                System.out.println(json);
            } else {
                System.out.println("Falha na solicitação HTTP");
            }
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }




    public String IdPartida(String puuID) throws JsonProcessingException {
        List<String> idPartidas = summonerService.listMatchs(puuID);
        String partida = idPartidas.get(0);
        return partida;
    }


}
