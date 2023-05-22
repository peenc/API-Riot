package com.peenc.consultalol.models;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class Match {
    private int kill;
    private int death;
    private int assist;
    private String resulMatch;
    private String timeMatch;
    private int farm;
    private String nameChampion;
    private int championId;
    private double kda;
    private String queue;
    private String freg;
    private String urlImgChampion;


    public String getFregFormat(){
        String fregFormat = kill + "/"+death+"/"+assist;
        return fregFormat;
    }
    public double getKdaFormat(){
        return Math.round(kda * 100.0) / 100.0;
    }

}
