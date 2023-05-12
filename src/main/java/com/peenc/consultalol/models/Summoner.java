package com.peenc.consultalol.models;

import java.util.List;

public class Summoner {
		
	private String id;
	private String name;
	private String nameImage;
	private Long summonerLevel;
	private List<Rank> ranks;
	
	public Summoner(String id, String name, String nameImage, Long summonrLevel, List<Rank> ranks) {
		super();
		this.id = id;
		this.name = name;
		this.nameImage = nameImage;
		this.summonerLevel = summonrLevel;
		this.ranks = ranks;
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
	public void setSummonerLevel(Long summonrLevel) {
		this.summonerLevel = summonrLevel;
	}
	public List<Rank> getRanks() {
		return ranks;
	}
	public void setRanks(List<Rank> ranks) {
		this.ranks = ranks;
	}
	


	
}
