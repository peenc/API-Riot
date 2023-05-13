package com.peenc.consultalol.models;

import java.util.List;

public class Summoner {
		
	private String id;
	private String name;
	private String nameImage;

	private Long summonerLevel;
	private List<Rank> ranks;
	private List<String> matchs;
	
	
	public Summoner(String id, String name, String nameImage, Long summonerLevel, List<Rank> ranks,
			List<String> matchs) {
		super();
		this.id = id;
		this.name = name;
		this.nameImage = nameImage;
		this.summonerLevel = summonerLevel;
		this.ranks = ranks;
		this.matchs = matchs;
	}
	public Summoner() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameImage() {
		return nameImage;
	}
	public void setNameImage(String nameImage) {
		this.nameImage = nameImage;
	}
	public Long getSummonerLevel() {
		return summonerLevel;
	}
	public void setSummonerLevel(Long summonerLevel) {
		this.summonerLevel = summonerLevel;
	}
	public List<Rank> getRanks() {
		return ranks;
	}

	public void setRanks(List<Rank> ranks) {
		this.ranks = ranks;
	}
	public List<String> getMatchs() {
		return matchs;
	}
	public void setMatchs(List<String> matchs) {
		this.matchs = matchs;
	}
	


	
}
