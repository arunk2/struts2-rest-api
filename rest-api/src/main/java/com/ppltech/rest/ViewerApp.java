package com.ppltech.rest;

public class ViewerApp {
	
	private ViewerDAO viewerDAO;

	public ViewerApp() {
		try {
		viewerDAO = new ViewerDAO();
		viewerDAO.initialize();
		}catch(Exception e) {
			System.out.println("Exception in DAO initprocess");
			e.printStackTrace();
		}
	}

	public String getViewerById(String id) {
		
		try {
			return viewerDAO.getViewerById(id);
		} catch (Exception e) {
			System.out.println("Exception fetching data for user : "+id);
			e.printStackTrace();
			return null;
		}
	}

	public ViewerDAO getViewerDAO() {
		return viewerDAO;
	}

	public void setViewerDAO(ViewerDAO viewerDAO) {
		this.viewerDAO = viewerDAO;
	}

}
