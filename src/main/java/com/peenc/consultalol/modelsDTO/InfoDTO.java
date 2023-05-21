package com.peenc.consultalol.modelsDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@Data
public class InfoDTO {
    public long gameCreation;
    public int gameDuration;
    public long gameEndTimestamp;
    public long gameId;
    public String gameMode;
    public String gameName;
    public long gameStartTimestamp;
    public String gameType;
    public String gameVersion;
    public int mapId;
    public ArrayList<ParticipantDTO> participantDTOS;
    public String platformId;
    public int queueId;
    public ArrayList<TeamDTO> teamDTOS;
    public String tournamentCode;
}
