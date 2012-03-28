package com.innoq.helloworld.models;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

@Entity @Table(name="relations")

public class Relation {
    class RelationPK implements Serializable {
        @Column(name="source_id")
        Long sourceId;
        @Column(name="destination_id")
        Long destinationId;
        
        
    }

    @EmbeddedId
    private RelationPK id;

	private String comment;
	private Boolean accepted;
	
	@Column(name = "created_at")
	private Timestamp createdAt;
	@Column(name = "updated_at")
	private Timestamp updatedAt;
	
	@ManyToOne @JoinColumn(name="source_id", insertable = false, updatable = false)
	private Profile source;

	@ManyToOne @JoinColumn(name="destination_id", insertable = false, updatable = false)
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

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

}
