package com.peenc.consultalol.modelsDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ParticipantDTO {
    private ChallengesDTO challenges;
    private int championId;
    private String championName;
    private int assists;
    private int deaths;
    private int kills;
    private String puuid;
    private String summonerName;
    private int totalMinionsKilled;
    private boolean win;

    public String getResulMatch(){
        if(this.win)
            return "WIN";
        return "LOSE";
    }
}
