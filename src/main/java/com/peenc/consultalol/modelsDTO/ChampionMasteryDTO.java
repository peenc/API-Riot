package com.peenc.consultalol.modelsDTO;

public class ChampionMasteryDTO {

	private Long championPointsUntilNextLevel;
	private Boolean chestGranted;
	private Long championId;
	private Long lastPlayTime;
	private Integer championLevel;
	private String summonerId;
	private Integer championPoints;
	private Long championPointsSinceLastLevel;
	private Integer tokensEarned;

	public ChampionMasteryDTO(Long championPointsUntilNextLevel, Boolean chestGranted, Long championId,
			Long lastPlayTime, Integer championLevel, String summonerId, Integer championPoints,
			Long championPointsSinceLastLevel, Integer tokensEarned) {
		super();
		this.championPointsUntilNextLevel = championPointsUntilNextLevel;
		this.chestGranted = chestGranted;
		this.championId = championId;
		this.lastPlayTime = lastPlayTime;
		this.championLevel = championLevel;
		this.summonerId = summonerId;
		this.championPoints = championPoints;
		this.championPointsSinceLastLevel = championPointsSinceLastLevel;
		this.tokensEarned = tokensEarned;
	}

	public ChampionMasteryDTO() {
		super();
	}

	public Long getChampionPointsUntilNextLevel() {
		return championPointsUntilNextLevel;
	}

	public void setChampionPointsUntilNextLevel(Long championPointsUntilNextLevel) {
		this.championPointsUntilNextLevel = championPointsUntilNextLevel;
	}

	public Boolean getChestGranted() {
		return chestGranted;
	}

	public void setChestGranted(Boolean chestGranted) {
		this.chestGranted = chestGranted;
	}

	public Long getChampionId() {
		return championId;
	}

	public void setChampionId(Long championId) {
		this.championId = championId;
	}

	public Long getLastPlayTime() {
		return lastPlayTime;
	}

	public void setLastPlayTime(Long lastPlayTime) {
		this.lastPlayTime = lastPlayTime;
	}

	public Integer getChampionLevel() {
		return championLevel;
	}

	public void setChampionLevel(Integer championLevel) {
		this.championLevel = championLevel;
	}

	public String getSummonerId() {
		return summonerId;
	}

	public void setSummonerId(String summonerId) {
		this.summonerId = summonerId;
	}

	public Integer getChampionPoints() {
		return championPoints;
	}

	public void setChampionPoints(Integer championPoints) {
		this.championPoints = championPoints;
	}

	public Long getChampionPointsSinceLastLevel() {
		return championPointsSinceLastLevel;
	}

	public void setChampionPointsSinceLastLevel(Long championPointsSinceLastLevel) {
		this.championPointsSinceLastLevel = championPointsSinceLastLevel;
	}

	public Integer getTokensEarned() {
		return tokensEarned;
	}

	public void setTokensEarned(Integer tokensEarned) {
		this.tokensEarned = tokensEarned;
	}

}
