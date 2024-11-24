package com.MongoDB.Joblisting.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="JobPost")
public class JobPost {
	
	private String profile;
	private String desc;
	private int exp;
	private String techs[];
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public String[] getTechs() {
		return techs;
	}
	public void setTechs(String[] techs) {
		this.techs = techs;
	}
	public JobPost(String profile, String desc, int exp, String[] techs) {
		super();
		this.profile = profile;
		this.desc = desc;
		this.exp = exp;
		this.techs = techs;
	}
	public JobPost() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
