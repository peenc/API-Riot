package com.peenc.consultalol.modelsDTO;


public class SummonerDTO {
	
	private String accountId;
	private String profileIconId;
	private Long revisionDate;
	private String name;
	private String id;
	private String puuid;
	private Long summonerLevel;
	
	public SummonerDTO(String accountId, String profileIconId, Long revisionDate, String name, String id, String puuid,
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

	public SummonerDTO(String profileIconId, String name) {
		this.profileIconId = profileIconId;
		this.name = name;
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
	public String getProfileIconId() {
		return profileIconId;
	}
	public void setProfileIconId(String profileIconId) {
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
