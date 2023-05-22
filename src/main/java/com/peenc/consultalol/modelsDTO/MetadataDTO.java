package com.peenc.consultalol.modelsDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@Data
public class MetadataDTO {
    private String dataVersion;
    private String matchId;
    private ArrayList<String> participants;
}
