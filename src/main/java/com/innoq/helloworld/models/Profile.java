package com.innoq.helloworld.models;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity @Table(name="profiles")
public class Profile {

	@Id
	@GeneratedValue
	Long id;

	private String profession;
	private String company;
	private String about;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "photo_file_name")
	private String photoFileName;
	@Column(name = "photo_content_type")
	private String photoContentType;
	@Column(name = "photo_file_size")
	private Integer photoFileSize;
	@Column(name = "created_at")
	private Timestamp createdAt;
	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "private_address_id")
	private Address privateAddress;	
	@ManyToOne
	@JoinColumn(name = "business_address_id")
	private Address businessAddress;

	@OneToMany(mappedBy = "from")
	private List<Message> sentMessages;
	@OneToMany(mappedBy = "to")
	private List<Message> receivedMessages;

	@OneToMany(mappedBy = "profile")
	private List<ProfileAttribute> attributes;

	@OneToMany(mappedBy = "source")
	private List<Relation> relations;
	@OneToMany(mappedBy = "destination")
	private List<Relation> incomingRelations;

	@OneToMany(mappedBy = "profile")
	private List<Status> statuses;

	public Profile() {
	}

	public Profile(String firstName, String lastName, String company, String profession, String about) {
		this.profession = profession;
		this.company = company;
		this.about = about;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	public Integer getPhotoFileSize() {
		return photoFileSize;
	}

	public void setPhotoFileSize(Integer photoFileSize) {
		this.photoFileSize = photoFileSize;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getPrivateAddress() {
		return privateAddress;
	}

	public void setPrivateAddress(Address privateAddress) {
		this.privateAddress = privateAddress;
	}

	public Address getBusinessAddress() {
		return businessAddress;
	}

	public void setBusinessAddress(Address businessAddress) {
		this.businessAddress = businessAddress;
	}

	public List<Message> getSentMessages() {
		return sentMessages;
	}

	public void setSentMessages(List<Message> sentMessages) {
		this.sentMessages = sentMessages;
	}

	public List<Message> getReceivedMessages() {
		return receivedMessages;
	}

	public void setReceivedMessages(List<Message> receivedMessages) {
		this.receivedMessages = receivedMessages;
	}

	public Long getId() {
		return id;
	}

	public List<ProfileAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<ProfileAttribute> attributes) {
		this.attributes = attributes;
	}

	public List<Relation> getRelations() {
		return relations;
	}

	public void setRelations(List<Relation> relations) {
		this.relations = relations;
	}

	public List<Relation> getIncomingRelations() {
		return incomingRelations;
	}

	public void setIncomingRelations(List<Relation> incomingRelations) {
		this.incomingRelations = incomingRelations;
	}

	public List<Status> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<Status> statuses) {
		this.statuses = statuses;
	}

}
