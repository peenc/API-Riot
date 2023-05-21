package com.peenc.consultalol.modelsDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@Data
public class StyleDTO {
    public String description;
    public ArrayList<SelectionDTO> selectionDTOS;
    public int style;
}
