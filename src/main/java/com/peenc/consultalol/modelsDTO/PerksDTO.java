package com.peenc.consultalol.modelsDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@Data
public class PerksDTO {
    public StatPerksDTO statPerksDTO;
    public ArrayList<StyleDTO> styleDTOS;
}
