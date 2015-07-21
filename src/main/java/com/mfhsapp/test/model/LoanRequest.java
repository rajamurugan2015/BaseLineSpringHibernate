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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.mfhsapp.test.enums.Status;

@Entity
@Table(name = "KCV_LOAN_REQUEST")
public class LoanRequest implements Serializable{

	private static final long serialVersionUID = 2459760361204241604L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "KCV_LOAN_REQUEST_ID",nullable = false )
	private BigInteger id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "STATUS", nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;


	@OneToMany(mappedBy="loanRequestAttribute" )
	@Cascade({CascadeType.ALL})
	private Set<Attribute> attributeList;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="KCV_LOAN_TEMPLATE_ID")
	private LoanTemplate loanRequestTemplate;


	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="KCV_BROKER_BORROWER_ID")
	private BrokerBorrower brokerBorrowerLoanRequest;

	@ManyToMany
	@Cascade({CascadeType.ALL})
	@JoinTable(name="KCV_MATCH_LOAN__REQUEST_CRITERIA",
	joinColumns={@JoinColumn(name="KCV_LOAN_CRITERIA_ID")},
	inverseJoinColumns={@JoinColumn(name="KCV_LOAN_REQUEST_ID")}
			)
	private Set<LoanCriteria> matchingCriteria;

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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<LoanCriteria> getMatchingCriteria() {
		return matchingCriteria;
	}

	public void setMatchingCriteria(Set<LoanCriteria> matchingCriteria) {
		this.matchingCriteria = matchingCriteria;
	}

	public BrokerBorrower getBrokerBorrowerLoanRequest() {
		return brokerBorrowerLoanRequest;
	}

	public void setBrokerBorrowerLoanRequest(
			BrokerBorrower brokerBorrowerLoanRequest) {
		this.brokerBorrowerLoanRequest = brokerBorrowerLoanRequest;
	}

	public Set<Attribute> getAttributeList() {
		return attributeList;
	}

	public void setAttributeList(Set<Attribute> attributeList) {
		this.attributeList = attributeList;
	}

	public LoanTemplate getLoanRequestTemplate() {
		return loanRequestTemplate;
	}

	public void setLoanRequestTemplate(LoanTemplate loanRequestTemplate) {
		this.loanRequestTemplate = loanRequestTemplate;
	}

}
