package com.handbb.ssp.model;

import java.util.List;
import java.util.Map;

public class UserMap {
	private String name;
	private Map<String, Object> link;
	private List<String> linklist;
	private String rescode;
	private String description;
	
	public String getRescode() {
		return rescode;
	}
	public void setRescode(String rescode) {
		this.rescode = rescode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getLinklist() {
		return linklist;
	}
	public void setLinklist(List<String> linklist) {
		this.linklist = linklist;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, Object> getLink() {
		return link;
	}
	public void setLink(Map<String, Object> link) {
		this.link = link;
	}
	
	
	
	
	
	
	
}
