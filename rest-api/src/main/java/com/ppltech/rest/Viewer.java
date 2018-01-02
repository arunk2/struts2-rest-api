package com.ppltech.rest;

import java.util.List;

public class Viewer {
	
	private String viewerId;
	private List<Score> videoScores;
	private List<Score> AdScores;
	
	public String getViewerId() {
		return viewerId;
	}
	public void setViewerId(String viewerId) {
		this.viewerId = viewerId;
	}
	public List<Score> getVideoScores() {
		return videoScores;
	}
	public void setVideoScores(List<Score> videoScores) {
		this.videoScores = videoScores;
	}
	public List<Score> getAdScores() {
		return AdScores;
	}
	public void setAdScores(List<Score> adScores) {
		AdScores = adScores;
	}
}
