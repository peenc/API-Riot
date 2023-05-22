package com.peenc.consultalol.modelsDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@Data
public class TeamDTO {
    private ArrayList<BanDTO> bans;
    private ObjectivesDTO objectives;
    private int teamId;
    private boolean win;
}
