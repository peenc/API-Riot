package com.peenc.consultalol.models;

import java.util.List;

public class ChampionInfoIds {
		
	private List<Integer> freeChampionIds;
	
	public ChampionInfoIds(List<Integer> freeChampionIds) {
		super();
		this.freeChampionIds = freeChampionIds;
	}

	public ChampionInfoIds() {
		super();
	}

	public List<Integer> getFreeChampionIds() {
		return freeChampionIds;
	}

	public void setFreeChampionIds(List<Integer> freeChampionIds) {
		this.freeChampionIds = freeChampionIds;
	}

	@Override
	public String toString() {
		return "ChampionInfoIds [freeChampionIds=" + freeChampionIds + "]";
	}
	
	
}
