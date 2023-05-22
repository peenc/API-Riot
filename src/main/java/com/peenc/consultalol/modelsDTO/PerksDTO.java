package com.peenc.consultalol.modelsDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@Data
public class PerksDTO {
    private StatPerksDTO statPerks;
    private ArrayList<StyleDTO> styles;
}
