package com.peenc.consultalol.modelsDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@Data
public class MetadataDTO {
    public String dataVersion;
    public String matchId;
    public ArrayList<String> participants;
}
