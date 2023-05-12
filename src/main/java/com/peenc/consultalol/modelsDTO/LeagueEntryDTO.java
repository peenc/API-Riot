package com.peenc.consultalol.modelsDTO;

public class LeagueEntryDTO {
	
	private String leagueId;	
	private String summonerId; //	Player's encrypted summonerId.
	private String summonerName;	
	private String queueType;	
	private String tier;	
	private String rank;	//The player's division within a tier.
	private Integer leaguePoints;
	private Integer wins;	//	Winning team on Summoners Rift.
	private Integer losses;//Losing team on Summoners Rift.
	private Boolean hotStreak;	
	private Boolean veteran;	
	private Boolean freshBlood;	
	private Boolean inactive;	
	private MiniSeriesDTO miniSeries;
	
	public LeagueEntryDTO(String leagueId, String summonerId, String summonerName, String queueType, String tier,
			String rank, Integer leaguePoints, Integer wins, Integer losses, Boolean hotStreak, Boolean veteran,
			Boolean freshBlood, Boolean inactive, MiniSeriesDTO miniSeries) {
		super();
		this.leagueId = leagueId;
		this.summonerId = summonerId;
		this.summonerName = summonerName;
		this.queueType = queueType;
		this.tier = tier;
		this.rank = rank;
		this.leaguePoints = leaguePoints;
		this.wins = wins;
		this.losses = losses;
		this.hotStreak = hotStreak;
		this.veteran = veteran;
		this.freshBlood = freshBlood;
		this.inactive = inactive;
		this.miniSeries = miniSeries;
	}

	public String getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(String leagueId) {
		this.leagueId = leagueId;
	}

	public String getSummonerId() {
		return summonerId;
	}

	public void setSummonerId(String summonerId) {
		this.summonerId = summonerId;
	}

	public String getSummonerName() {
		return summonerName;
	}

	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}

	public String getQueueType() {
		return queueType;
	}

	public void setQueueType(String queueType) {
		this.queueType = queueType;
	}

	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public Integer getLeaguePoints() {
		return leaguePoints;
	}

	public void setLeaguePoints(Integer leaguePoints) {
		this.leaguePoints = leaguePoints;
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

	public Boolean getHotStreak() {
		return hotStreak;
	}

	public void setHotStreak(Boolean hotStreak) {
		this.hotStreak = hotStreak;
	}

	public Boolean getVeteran() {
		return veteran;
	}

	public void setVeteran(Boolean veteran) {
		this.veteran = veteran;
	}

	public Boolean getFreshBlood() {
		return freshBlood;
	}

	public void setFreshBlood(Boolean freshBlood) {
		this.freshBlood = freshBlood;
	}

	public Boolean getInactive() {
		return inactive;
	}

	public void setInactive(Boolean inactive) {
		this.inactive = inactive;
	}

	public MiniSeriesDTO getMiniSeries() {
		return miniSeries;
	}

	public void setMiniSeries(MiniSeriesDTO miniSeries) {
		this.miniSeries = miniSeries;
	}

	public LeagueEntryDTO() {
		super();
	}	
	
	
}
