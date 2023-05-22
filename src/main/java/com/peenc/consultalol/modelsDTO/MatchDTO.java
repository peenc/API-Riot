package com.peenc.consultalol.modelsDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MatchDTO {
    private MetadataDTO metadata;
    private InfoDTO info;
}
