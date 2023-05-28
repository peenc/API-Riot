package com.peenc.consultalol.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


@NoArgsConstructor
@Data
public class Match {

    private String timeDuration;
    private int kill;
    private int death;
    private int assist;
    private String resulMatch;
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

    public static String getGameDuration(int time){
        int segundos = time;
        int  minutos = segundos/60;
        segundos %= 60;
        return LocalTime.of(0, minutos, segundos ).format(DateTimeFormatter.ofPattern("mm:ss")) ;
    }

}
