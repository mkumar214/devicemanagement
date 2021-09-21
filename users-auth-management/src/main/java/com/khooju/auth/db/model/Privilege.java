package com.khooju.auth.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Privilege extends Identifier{


	@Column
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

		
}
