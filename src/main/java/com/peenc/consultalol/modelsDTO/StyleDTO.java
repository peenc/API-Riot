package com.peenc.consultalol.modelsDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@Data
public class StyleDTO {
    private String description;
    private ArrayList<SelectionDTO> selections;
    private int style;
}
