package com.peenc.consultalol.models;


public class SummonerDTO {
	
	private String accountId;
	private Integer profileIconId;
	private Long revisionDate;
	private String name;
	private String id;
	private String puuid;
	private Long summonerLevel;
	
	public SummonerDTO(String accountId, Integer profileIconId, Long revisionDate, String name, String id, String puuid,
			Long summonerLevel) {
		super();
		this.accountId = accountId;
		this.profileIconId = profileIconId;
		this.revisionDate = revisionDate;
		this.name = name;
		this.id = id;
		this.puuid = puuid;
		this.summonerLevel = summonerLevel;
	}
	
	public boolean estaVazia() {
        return accountId == null;
    }
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public Integer getProfileIconId() {
		return profileIconId;
	}
	public void setProfileIconId(Integer profileIconId) {
		this.profileIconId = profileIconId;
	}
	public Long getRevisionDate() {
		return revisionDate;
	}
	public void setRevisionDate(Long revisionDate) {
		this.revisionDate = revisionDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPuuid() {
		return puuid;
	}
	public void setPuuid(String puuid) {
		this.puuid = puuid;
	}
	public Long getSummonerLevel() {
		return summonerLevel;
	}
	public void setSummonerLevel(Long summonerLevel) {
		this.summonerLevel = summonerLevel;
	}
	public SummonerDTO() {
		super();
	}
	@Override
	public String toString() {
		return "SummonerDTO [accountId=" + accountId + ", profileIconId=" + profileIconId + ", revisionDate="
				+ revisionDate + ", name=" + name + ", id=" + id + ", puuid=" + puuid + ", summonerLevel="
				+ summonerLevel + "]";
	}
	



}
