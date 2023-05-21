package com.peenc.consultalol.modelsDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@Data
public class TeamDTO {
    public ArrayList<BanDTO> bans;
    public ObjectivesDTO objectivesDTO;
    public int teamId;
    public boolean win;
}
