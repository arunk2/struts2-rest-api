package com.ppltech.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewerRepository {
	private static Map<String,Viewer> map = new HashMap<String,Viewer>(); 
	public ViewerRepository(){
		
		Viewer viewer = new Viewer();
		viewer.setViewerId("1.187.242.1--1450539626");
		Score sc1 = new Score("news", 10);
		Score sc2 = new Score("ent", 6);
		Score sc3 = new Score("health", 1);
		Score sc4 = new Score("others", 0);
		List<Score> scores = new ArrayList<Score>();
		scores.add(sc1);
		scores.add(sc2);
		scores.add(sc3);
		scores.add(sc4);
		viewer.setVideoScores(scores);
		map.put("1.187.242.1--1450539626", viewer);
		
		
		viewer = new Viewer();
		viewer.setViewerId("1.187.242.139--1455934674");
		sc1 = new Score("news", 10);
		sc2 = new Score("ent", 6);
		sc3 = new Score("health", 1);
		sc4 = new Score("others", 0);
		scores = new ArrayList<Score>();
		scores.add(sc1);
		scores.add(sc2);
		scores.add(sc3);
		scores.add(sc4);
		viewer.setVideoScores(scores);
		map.put("1.187.242.139--1455934674", new Viewer());
		
		
		viewer = new Viewer();
		viewer.setViewerId("1.187.242.173--1459490013");
		sc1 = new Score("news", 10);
		sc2 = new Score("ent", 6);
		sc3 = new Score("health", 1);
		sc4 = new Score("others", 0);
		scores = new ArrayList<Score>();
		scores.add(sc1);
		scores.add(sc2);
		scores.add(sc3);
		scores.add(sc4);
		viewer.setVideoScores(scores);
		map.put("1.187.242.173--1459490013", new Viewer());
		
	}
	
	public  Viewer getViewerById(String id){
		return map.get(id);
	}
	
	public  Map<String,Viewer> findAllViewer(){
		return map;
	}
	
}
