package com.peenc.consultalol.modelsDTO;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.stream.Collectors;

@NoArgsConstructor
@Data
public class InfoDTO {
    private long gameCreation;
    private int gameDuration;
    private long gameEndTimestamp;
    private long gameId;
    private String gameMode;
    private String gameName;
    private long gameStartTimestamp;
    private String gameType;
    private String gameVersion;
    private int mapId;
    private ArrayList<ParticipantDTO> participants;
    private String platformId;
    private int queueId;
    private ArrayList<TeamDTO> teams;
    private String tournamentCode;


    public String getTimeDuration(){
        int minutos = this.gameDuration/60;
        int segundos = this.gameDuration % 60;
        String aux = minutos + ":" + segundos;
        return aux;
    }

}
