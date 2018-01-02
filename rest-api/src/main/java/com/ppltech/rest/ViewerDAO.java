package com.ppltech.rest;


import java.io.BufferedReader;
import java.io.FileReader;
import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/*
	{
	  "_id": "1132432",
	  "videoScore": [
	    {"cat1": 5},
	    {"cat2": 1},
	    {"cat3": 5},
	    {"cat4": 5}
	  ],
	  "adScore": [
	    {"all": 5}
	  ]
	}
*/
public class ViewerDAO {
	
	private MongoDAO mongoDAO;
	private MemCache cache;

	public static void main(String[] args) {

		try {
			
			ViewerDAO tracker = new ViewerDAO();
			
			//Initialize DB
			tracker.initialize();
			
			tracker.load();
			

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void load() throws Exception {
		
		mongoDAO.dropTable(Constants.TABLE_NAME_VIEWER);
		
		BufferedReader br = new BufferedReader(
				new FileReader("/home/dev/Desktop/Apr-1-logdata/keywords/part-m-00000"));
		String sCurrentLine = null;
		int i = 0;
		while ((sCurrentLine = br.readLine()) != null) {
			if(sCurrentLine.length() > 0)
				loadEvent(sCurrentLine);
			i++;
		}
		System.out.println("No of events : " + i);
		br.close();
		
	}
	
	public String getViewerById(String viewerId) throws Exception {

		String viewerScore = (String) cache.get(viewerId);

		if (viewerScore == null) {
			DBObject db = mongoDAO.findDocumentById(
					Constants.TABLE_NAME_VIEWER, viewerId);
			viewerScore = db.toString();
		}
		
		return viewerScore;

	}

	private void loadEvent(String event) throws Exception {
		
		String[] values = event.split(",");
		
		DBObject db = mongoDAO.findDocumentById(Constants.TABLE_NAME_VIEWER, values[0]);
		if(db == null)
			createViewer(values[0]);
		
		Integer score = 0;
		
		if (values.length < 9)
			return;//Some error - don't update
		
		Integer categoryPos = Constants.getPos(values[7]);
		
		String[] vScores = values[9].split(" ");
		if (vScores.length < 7)  
			return;//Some error - don't update
		
		score = calculateScore(vScores);
		
		BasicDBObject newDocument = new BasicDBObject().append("$inc",
				new BasicDBObject().append(Constants.DB_VIDEO_SCORE +"."+categoryPos, score));
		
		mongoDAO.update(Constants.TABLE_NAME_VIEWER, "_id", values[0], newDocument);
		
		updateCache(values[0]);
		
	}
	
	private void updateCache(String viewerId) {
		
		DBObject db = mongoDAO.findDocumentById(
				Constants.TABLE_NAME_VIEWER, viewerId);
		
		cache.set(viewerId, 0, db.toString());
		
	}

	private Integer calculateScore(String[] vScores) {
		
		/* We have a event score dumped as below
		//		String.valueOf(start)+" "+
		//		String.valueOf(progress)+" "+
		//		String.valueOf(engagementAbort)+" "+
		//		String.valueOf(engagementMute)+" "+
		//		String.valueOf(engagementPause)+" "+
		//		String.valueOf(engagementOthers)+" "+
		//		String.valueOf(click);
		*/
		
		Integer score = 0;
		
		score += Integer.valueOf(vScores[0]);
		score += Integer.valueOf(vScores[1]);
		score -= Integer.valueOf(vScores[2]) * 2;
		score -= Integer.valueOf(vScores[3]);
		score -= Integer.valueOf(vScores[4]);
		score += Integer.valueOf(vScores[5]);
		score += Integer.valueOf(vScores[6]) * 2;
		
		return score;
		
	}

	private void createViewer(String viewerId) throws Exception {
		
		BasicDBObject document = new BasicDBObject();
		document.put("_id", viewerId);
		Integer[] videoScore = new Integer[19];
		
		videoScore[0] = 0;
		videoScore[1] = 0;
		videoScore[2] = 0;
		videoScore[3] = 0;
		videoScore[4] = 0;
		videoScore[5] = 0;
		videoScore[6] = 0;
		videoScore[7] = 0;
		videoScore[8] = 0;
		videoScore[9] = 0;
		videoScore[10] = 0;
		videoScore[11] = 0;
		videoScore[12] = 0;
		videoScore[13] = 0;
		videoScore[14] = 0;
		videoScore[15] = 0;
		videoScore[16] = 0;
		videoScore[17] = 0;
		videoScore[18] = 0;
		document.put(Constants.DB_VIDEO_SCORE, videoScore);
		
		Integer[] adScore = new Integer[1];
		adScore[0] = 0;
		document.put(Constants.DB_AD_SCORE, adScore);
		
		mongoDAO.saveToDB(Constants.TABLE_NAME_VIEWER, document);
		
	}
	
	public void initialize() throws Exception {
		mongoDAO = MongoDAO.getInstance();
		mongoDAO.createTable(Constants.TABLE_NAME_VIEWER);
		
		cache = MemCache.getInstance();
	}
	
}
