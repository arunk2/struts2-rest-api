package com.ppltech.rest;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.opensymphony.xwork2.ModelDriven;

public class ViewerController implements ModelDriven<String>{
	private static final long serialVersionUID = 1L;
	private String id;
	private String model;
	private ViewerApp viewerApp = new ViewerApp();

	
	public HttpHeaders index() {
		model = "Send viewerId in REST param";
		return new DefaultHttpHeaders("index").disableCaching();
	}
	
	public String add(){
		return "ERROR";
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		model = viewerApp.getViewerById(id);
		this.id = id;
	}
	
	@Override
	public String getModel() {
		return model;
	}

}