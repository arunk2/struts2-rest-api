package com.ppltech.rest;

public class Score {
	
	private String category;
	private Integer score;
	
	public Score(String category, int score) {
		this.category = category;
		this.score = score;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	
}
