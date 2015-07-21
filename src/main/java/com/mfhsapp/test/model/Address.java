package com.mfhsapp.test.model;
import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.mfhsapp.test.enums.Status;

@Entity
@Table(name = "KCV_ADDRESS")
public class Address implements Serializable{

	private static final long serialVersionUID = -8621795010615652945L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "KCV_ADDRESS_ID",nullable = false )
	private BigInteger id;

	@Column(name = "ADDRESS_LINE1", nullable = false)
	private String addressLine1;

	@Column(name = "ADDRESS_LINE2")
	private String addressLine2;

	@Column(name = "CITY", nullable = false)
	private String city;

	@Column(name = "STATE", nullable = false)
	private String state;

	@Column(name = "ZIPCODE", nullable = false)
	private String zipcode;

	@OneToOne(mappedBy = "contactAddress")
	private Contact contact;

	@Enumerated(EnumType.STRING)
	private Status status;

	/*@Column(name = "CREATED_BY", nullable = false)
	private String createdBy;

	@Column(name = "CREATING_PROCESS", nullable = false)
	private String creatingProcess;

	@Column(name = "CREATION_DATE_TIME", nullable = false)
	private Date creationDateTime;

	@Column(name = "LAST_UPDATED_BY", nullable = false)
	private String lastUpdatedBy;

	@Column(name = "LAST_UPDATING_PROCESS", nullable = false)
	private String lastUpdatingProcess;

	@Column(name = "LAST_UPDATED_DATE_TIME", nullable = false)
	private Date lastUpdatedDateTime;

	 */
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
