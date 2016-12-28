package com.prongbang.hibernate.models;

import java.io.Serializable;

public class AddressModel implements Serializable {

	private static final long serialVersionUID = 233945993777302787L;
 
	private Integer id;
	 
	private String addressName;
	 
	private Integer personId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

}
