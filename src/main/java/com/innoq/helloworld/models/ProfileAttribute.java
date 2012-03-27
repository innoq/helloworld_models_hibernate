package com.innoq.helloworld.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name="profile_attributes")
public class ProfileAttribute {

	@Id
	@GeneratedValue
	Long id;
	@Column(name = "attr_type")
	private String attrType;
	private String value;
	
	@ManyToOne @JoinColumn(name="profile_id")
	private Profile profile;

	public ProfileAttribute() {
	}

	public ProfileAttribute(String attrType, String value) {
		this.attrType = attrType;
		this.value = value;
	}

	public String getAttrType() {
		return attrType;
	}

	public void setAttrType(String attrType) {
		this.attrType = attrType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Long getId() {
		return id;
	}


}
