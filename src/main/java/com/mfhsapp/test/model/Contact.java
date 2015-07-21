package com.mfhsapp.test.model;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.mfhsapp.test.enums.Status;

@Entity
@Table(name = "KCV_CONTACT")
public class Contact {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "KCV_CONTACT_ID",nullable = false )
	private BigInteger id;

	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;

	@OneToOne
	//@Cascade({CascadeType.PERSIST, CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	@Cascade({CascadeType.ALL})
	@JoinColumn(name="KCV_ADDRESS_ID", nullable = false)
	private Address contactAddress;

	@OneToOne(mappedBy = "userContact")
	private User user;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="KCV_LENDER_ID")
	private Lender lenderContact;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="KCV_BROKER_BORROWER_ID")
	private BrokerBorrower brokerBorrowerContact;

	@Column(name = "PHONE1", nullable = false)
	private String phone1;

	@Column(name = "PHONE2")
	private String phone2;

	@Column(name = "EMAIL1")
	private String email1;

	@Column(name = "EMAIL2")
	private String email2;

	@Column(name = "PREFERED_TIME_TO_CONTACT")
	private String preferedTime;

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



	public Address getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(Address contactAddress) {
		this.contactAddress = contactAddress;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getPreferedTime() {
		return preferedTime;
	}

	public void setPreferedTime(String preferedTime) {
		this.preferedTime = preferedTime;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Lender getLenderContact() {
		return lenderContact;
	}

	public void setLenderContact(Lender lenderContact) {
		this.lenderContact = lenderContact;
	}


}
