package com.innoq.helloworld.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name="relations")
public class Relation {

	@Id
	@GeneratedValue
	Long id;
	@Column(name = "attr_type")
	private String comment;
	private Boolean accepted;
	
	@Column(name = "created_at")
	private Timestamp createdAt;
	@Column(name = "updated_at")
	private Timestamp updatedAt;
	
	@ManyToOne @JoinColumn(name="source_id")
	private Profile source;

	@ManyToOne @JoinColumn(name="destination_id")
	private Profile destination;

	public Relation() {
	}

	public Relation(String comment, Boolean accepted) {
		this.comment = comment;
		this.accepted = accepted;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Boolean getAccepted() {
		return accepted;
	}

	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
	}

	public Profile getSource() {
		return source;
	}

	public void setSource(Profile source) {
		this.source = source;
	}

	public Profile getDestination() {
		return destination;
	}

	public void setDestination(Profile destination) {
		this.destination = destination;
	}

	public Long getId() {
		return id;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

}
