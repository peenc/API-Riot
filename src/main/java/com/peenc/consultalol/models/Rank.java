package com.peenc.consultalol.models;

public class Rank {
	
	private String name;
	private String tier;
	private Integer pdl;
	private String queue;
	private String nameImageTier;
	
	
	
	public Rank(String name, String tier, Integer pdl, String queue, String nameImageTier) {
		super();
		this.name = name;
		this.tier = tier;
		this.pdl = pdl;
		this.queue = queue;
		this.nameImageTier = nameImageTier;
	}
	public Rank() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
}
