package com.ppltech.rest;

public class Constants {
	
	public static String CATEGORY_ALL = "All";
	public static String CATEGORY_GENERAL = "General";
	public static String CATEGORY_AUTO_VEHICLE = "Auto & Vehicles";
	public static String CATEGORY_ENTERTAINMENT = "Entertainment";
	public static String CATEGORY_HEALTH_FITNESS = "Health & Fitness";
	public static String CATEGORY_POLITICS = "Politics";
	public static String CATEGORY_SPORTS = "Sports";
	public static String CATEGORY_TECHNOLOGY = "Technology";
	public static String CATEGORY_BUSINESS = "Business";
	public static String CATEGORY_REAL_ESTATE = "Real Estate";
	public static String CATEGORY_CULTURE = "Culture";
	public static String CATEGORY_COMEDY = "Comedy";
	public static String CATEGORY_FOOD_DINE = "Food & Dining";
	public static String CATEGORY_LIFESTYLE_FASHION = "Lifestyle & Fashion";
	public static String CATEGORY_MUSIC = "Music";
	public static String CATEGORY_NEWS = "News";
	public static String CATEGORY_PEOPLE = "People";
	public static String CATEGORY_OTHER_INTERESTS = "Other Interests";
	public static String CATEGORY_TRAVEL = "Travel";
	
	public static String DB_CATEGORY_ALL = "all";
	public static String DB_CATEGORY_GENERAL = "general";
	public static String DB_CATEGORY_AUTO_VEHICLE = "auto_vehicles";
	public static String DB_CATEGORY_ENTERTAINMENT = "entertainment";
	public static String DB_CATEGORY_HEALTH_FITNESS = "health_fitness";
	public static String DB_CATEGORY_POLITICS = "politics";
	public static String DB_CATEGORY_SPORTS = "sports";
	public static String DB_CATEGORY_TECHNOLOGY = "technology";
	public static String DB_CATEGORY_BUSINESS = "business";
	public static String DB_CATEGORY_REAL_ESTATE = "real_estate";
	public static String DB_CATEGORY_CULTURE = "culture";
	public static String DB_CATEGORY_COMEDY = "comedy";
	public static String DB_CATEGORY_FOOD_DINE = "food_dining";
	public static String DB_CATEGORY_LIFESTYLE_FASHION = "lifestyle_fashion";
	public static String DB_CATEGORY_MUSIC = "music";
	public static String DB_CATEGORY_NEWS = "news";
	public static String DB_CATEGORY_PEOPLE = "people";
	public static String DB_CATEGORY_OTHER_INTERESTS = "other_interests";
	public static String DB_CATEGORY_TRAVEL = "travel";
	
	public static String DB_CATEGORY_ALL_POS = "0";
	public static String DB_CATEGORY_GENERAL_POS = "1";
	public static String DB_CATEGORY_AUTO_VEHICLE_POS = "2";
	public static String DB_CATEGORY_ENTERTAINMENT_POS = "3";
	public static String DB_CATEGORY_HEALTH_FITNESS_POS = "4";
	public static String DB_CATEGORY_POLITICS_POS = "5";
	public static String DB_CATEGORY_SPORTS_POS = "6";
	public static String DB_CATEGORY_TECHNOLOGY_POS = "7";
	public static String DB_CATEGORY_BUSINESS_POS = "8";
	public static String DB_CATEGORY_REAL_ESTATE_POS = "9";
	public static String DB_CATEGORY_CULTURE_POS = "10";
	public static String DB_CATEGORY_COMEDY_POS = "11";
	public static String DB_CATEGORY_FOOD_DINE_POS = "12";
	public static String DB_CATEGORY_LIFESTYLE_FASHION_POS = "13";
	public static String DB_CATEGORY_MUSIC_POS = "14";
	public static String DB_CATEGORY_NEWS_POS = "15";
	public static String DB_CATEGORY_PEOPLE_POS = "16";
	public static String DB_CATEGORY_OTHER_INTERESTS_POS = "17";
	public static String DB_CATEGORY_TRAVEL_POS = "18";
	
	public static String DB_VIEWER_ID = "viewerId";
	public static String DB_VIDEO_SCORE = "videoScore";
	public static String DB_AD_SCORE = "adScore";
	
	public static String TABLE_NAME_VIEWER = "viewers";

	public static String getDBCategory(String category) {
		String cat = DB_CATEGORY_ALL;
		
		if(CATEGORY_GENERAL.equals(category))
			cat = DB_CATEGORY_ALL;
		else if(CATEGORY_AUTO_VEHICLE.equals(category))
			cat = DB_CATEGORY_AUTO_VEHICLE;
		else if(CATEGORY_ENTERTAINMENT.equals(category))
			cat = DB_CATEGORY_ENTERTAINMENT;
		else if(CATEGORY_HEALTH_FITNESS.equals(category))
			cat = DB_CATEGORY_HEALTH_FITNESS;
		else if(CATEGORY_POLITICS.equals(category))
			cat = DB_CATEGORY_POLITICS;
		else if(CATEGORY_SPORTS.equals(category))
			cat = DB_CATEGORY_SPORTS;
		else if(CATEGORY_TECHNOLOGY.equals(category))
			cat = DB_CATEGORY_TECHNOLOGY;
		else if(CATEGORY_BUSINESS.equals(category))
			cat = DB_CATEGORY_BUSINESS;
		else if(CATEGORY_REAL_ESTATE.equals(category))
			cat = DB_CATEGORY_REAL_ESTATE;
		else if(CATEGORY_CULTURE.equals(category))
			cat = DB_CATEGORY_CULTURE;
		else if(CATEGORY_COMEDY.equals(category))
			cat = DB_CATEGORY_COMEDY;
		else if(CATEGORY_FOOD_DINE.equals(category))
			cat = DB_CATEGORY_FOOD_DINE;
		else if(CATEGORY_LIFESTYLE_FASHION.equals(category))
			cat = DB_CATEGORY_LIFESTYLE_FASHION;
		else if(CATEGORY_MUSIC.equals(category))
			cat = DB_CATEGORY_MUSIC;
		else if(CATEGORY_NEWS.equals(category))
			cat = DB_CATEGORY_NEWS;
		else if(CATEGORY_PEOPLE.equals(category))
			cat = DB_CATEGORY_PEOPLE;
		else if(CATEGORY_OTHER_INTERESTS.equals(category))
			cat = DB_CATEGORY_OTHER_INTERESTS;
		else if(CATEGORY_TRAVEL.equals(category))
			cat = DB_CATEGORY_TRAVEL;
		
		return cat;
		
	}
	
	public static Integer getPos(String category) {
		Integer pos = 0;
		
		if(CATEGORY_GENERAL.equals(category))
			pos = 1;
		else if(CATEGORY_AUTO_VEHICLE.equals(category))
			pos = 2;
		else if(CATEGORY_ENTERTAINMENT.equals(category))
			pos = 3;
		else if(CATEGORY_HEALTH_FITNESS.equals(category))
			pos = 4;
		else if(CATEGORY_POLITICS.equals(category))
			pos = 5;
		else if(CATEGORY_SPORTS.equals(category))
			pos = 6;
		else if(CATEGORY_TECHNOLOGY.equals(category))
			pos = 7;
		else if(CATEGORY_BUSINESS.equals(category))
			pos = 8;
		else if(CATEGORY_REAL_ESTATE.equals(category))
			pos = 9;
		else if(CATEGORY_CULTURE.equals(category))
			pos = 10;
		else if(CATEGORY_COMEDY.equals(category))
			pos = 11;
		else if(CATEGORY_FOOD_DINE.equals(category))
			pos = 12;
		else if(CATEGORY_LIFESTYLE_FASHION.equals(category))
			pos = 13;
		else if(CATEGORY_MUSIC.equals(category))
			pos = 14;
		else if(CATEGORY_NEWS.equals(category))
			pos = 15;
		else if(CATEGORY_PEOPLE.equals(category))
			pos = 16;
		else if(CATEGORY_OTHER_INTERESTS.equals(category))
			pos = 17;
		else if(CATEGORY_TRAVEL.equals(category))
			pos = 18;
		
		return pos;
		
	}
	
}
