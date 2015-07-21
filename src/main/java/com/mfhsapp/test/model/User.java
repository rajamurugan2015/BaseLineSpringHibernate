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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.mfhsapp.test.enums.Status;
import com.mfhsapp.test.enums.UserRole;

@Entity
@Table(name = "KCV_USER")
public class User implements Serializable{

	private static final long serialVersionUID = 8381282319570872977L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "KCV_USER_ID",nullable = false )
	private BigInteger id;


	@Column(name = "USERNAME", nullable = false)
	private String username;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@OneToOne
	//@Cascade({CascadeType.PERSIST, CascadeType.SAVE_UPDATE,CascadeType.DELETE})
	@Cascade({CascadeType.ALL})
	@JoinColumn(name="KCV_CONTACT_ID", nullable = false)
	private Contact userContact;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="KCV_LENDER_ID")
	private Lender lenderUser;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="KCV_BROKER_BORROWER_ID")
	private BrokerBorrower brokerBorrowerUser;

	@Column(name = "STATUS", nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;

	@Column(name = "USER_ROLE", nullable = false)
	@Enumerated(EnumType.STRING)
	private UserRole userRole;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Contact getUserContact() {
		return userContact;
	}

	public Lender getLenderUser() {
		return lenderUser;
	}

	public void setLenderUser(Lender lenderUser) {
		this.lenderUser = lenderUser;
	}

	public void setUserContact(Contact userContact) {
		this.userContact = userContact;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BrokerBorrower getBrokerBorrowerUser() {
		return brokerBorrowerUser;
	}

	public void setBrokerBorrowerUser(BrokerBorrower brokerBorrowerUser) {
		this.brokerBorrowerUser = brokerBorrowerUser;
	}


}
