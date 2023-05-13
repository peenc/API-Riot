package com.peenc.consultalol.models;

import com.peenc.consultalol.modelsDTO.MiniSeriesDTO;

public class Rank {
	
	private String ranking;
	private String tier;
	private Integer pdl;
	private String queue;
	private String nameImageTier;
	private Integer wins;
	private Integer losses;
	
	public Rank(String ranking, String tier, Integer pdl, String queue, String nameImageTier, Integer wins,
			Integer losses, MiniSeriesDTO miniSeries) {
		super();
		this.ranking = ranking;
		this.tier = tier;
		this.pdl = pdl;
		this.queue = queue;
		this.nameImageTier = nameImageTier;
		this.wins = wins;
		this.losses = losses;
		this.miniSeries = miniSeries;
	}

	private MiniSeriesDTO miniSeries;
	
	
	

	public Rank() {
		super();
	}
	public String getRanking() {
		return ranking;
	}
	public void setRanking(String ranking) {
		this.ranking = ranking;
	}
	public String getTier() {
		return tier;
	}
	public void setTier(String tier) {
		this.tier = tier;
	}
	public Integer getPdl() {
		return pdl;
	}
	public void setPdl(Integer pdl) {
		this.pdl = pdl;
	}
	
	public String getQueue() {
		return queue;
	}
	public void setQueue(String queue) {
		this.queue = queue;
	}

	public String getNameImageTier() {
		return nameImageTier;
	}

	public void setNameImageTier(String nameImageTier) {
		this.nameImageTier = nameImageTier;
	}
	public Integer getWins() {
		return wins;
	}
	public void setWins(Integer wins) {
		this.wins = wins;
	}
	public Integer getLosses() {
		return losses;
	}
	public void setLosses(Integer losses) {
		this.losses = losses;
	}
	public MiniSeriesDTO getMiniSeries() {
		return miniSeries;
	}
	public void setMiniSeries(MiniSeriesDTO miniSeries) {
		this.miniSeries = miniSeries;
	}
	
	public double Winrate(){
		 double winRate = (wins * 100.0) / (wins + losses);
		    winRate = Math.round(winRate * 10.0) / 10.0; 
		    return winRate;

		
	}
}
