package com.peenc.consultalol.modelsDTO;

public class MiniSeriesDTO {
		
	private Integer losses;	
	private String progress;	
	private Integer target;	
	private Integer wins;
	
	public MiniSeriesDTO(Integer losses, String progress, Integer target, Integer wins) {
		super();
		this.losses = losses;
		this.progress = progress;
		this.target = target;
		this.wins = wins;
	}

	public Integer getLosses() {
		return losses;
	}

	public void setLosses(Integer losses) {
		this.losses = losses;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public Integer getTarget() {
		return target;
	}

	public void setTarget(Integer target) {
		this.target = target;
	}

	public Integer getWins() {
		return wins;
	}

	public void setWins(Integer wins) {
		this.wins = wins;
	}

	public MiniSeriesDTO() {
		super();
	}
	

}
