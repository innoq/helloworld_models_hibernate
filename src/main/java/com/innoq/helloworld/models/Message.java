package com.innoq.helloworld.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name="messages")
public class Message {

    @Id @GeneratedValue
    Long id;
	private String subject;
	private String body;
	@Column(name = "created_at")
	private Timestamp createdAt;
	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@ManyToOne
	@JoinColumn(name = "from_id")
	private Profile from;
	@ManyToOne
	@JoinColumn(name = "to_id")
	private Profile to;

	public Message() {
	}

	public Message(String subject, String body, Profile from, Profile to) {
		super();
		this.subject = subject;
		this.body = body;
		this.from = from;
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public Profile getFrom() {
		return from;
	}

	public void setFrom(Profile from) {
		this.from = from;
	}

	public Profile getTo() {
		return to;
	}

	public void setTo(Profile to) {
		this.to = to;
	}

}
