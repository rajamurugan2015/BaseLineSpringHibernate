package com.mfhsapp.test.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.mfhsapp.test.enums.Status;

@Entity
@Table(name = "KCV_BROKER_BORROWER")
public class BrokerBorrower implements Serializable{

	private static final long serialVersionUID = 1655574344661134623L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "KCV_BROKER_BORROWER_ID",nullable = false )
	private BigInteger id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "DESCRIPTION", nullable = false)
	private String dec;

	@Column(name = "STATUS", nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;

	@OneToMany(mappedBy="brokerBorrowerContact" )
	//@Cascade({CascadeType.PERSIST, CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	@Cascade({CascadeType.ALL})
	private Set<Contact> contacts;

	@OneToMany(mappedBy="brokerBorrowerUser" )
	@Cascade({CascadeType.ALL})
	private Set<User> users;

	@OneToMany(mappedBy="brokerBorrowerLoanRequest" )
	//@Cascade({CascadeType.PERSIST, CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	@Cascade({CascadeType.ALL})
	private Set<LoanRequest> loanRequests;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDec() {
		return dec;
	}

	public void setDec(String dec) {
		this.dec = dec;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<LoanRequest> getLoanRequests() {
		return loanRequests;
	}

	public void setLoanRequests(Set<LoanRequest> loanRequests) {
		this.loanRequests = loanRequests;
	}



}



