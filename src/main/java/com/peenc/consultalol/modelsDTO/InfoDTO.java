package com.peenc.consultalol.modelsDTO;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.stream.Collectors;

@NoArgsConstructor
@Data
public class InfoDTO {

    private String gameMode;
    private ArrayList<ParticipantDTO> participants;
    private int gameDuration;

}
