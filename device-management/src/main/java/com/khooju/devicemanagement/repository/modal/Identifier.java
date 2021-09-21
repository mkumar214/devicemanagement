package com.khooju.devicemanagement.repository.modal;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 
 * @author mukesh
 *This is a abstract class.This only contains of the identifer field which is extended by the other entity.
 */
@MappedSuperclass
public abstract class Identifier {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}
