package com.khooju.auth.db.model;

import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 
 * @author mukesh
 *This is super class of the all the auditable entity in the system.This class will log the details of the user who performed the activity.
 * @param <U>
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> extends Identifier{
	@CreatedBy
	protected U createdBy;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
	protected Date createdDate;
    @LastModifiedBy
	protected U lastModifiedBy;
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
	protected Date lastModifiedDate;
	
    public U getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(U createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public U getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(U lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
}
