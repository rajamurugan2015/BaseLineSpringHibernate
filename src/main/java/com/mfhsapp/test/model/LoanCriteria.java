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
@Table(name = "KCV_LOAN_CRITERIA")
public class LoanCriteria implements Serializable{

	private static final long serialVersionUID = 2045179886014833796L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "KCV_LOAN_CRITERIA_ID",nullable = false )
	private BigInteger id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "STATUS", nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;

	@OneToMany(mappedBy="loanCriteriaAttribute" )
	@Cascade({CascadeType.ALL})
	private Set<Attribute> attributeList;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="KCV_LOAN_TEMPLATE_ID")
	private LoanTemplate loanCriteriaTemplate;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="KCV_LENDER_ID")
	private Lender lenderCriteria;


	@ManyToMany(mappedBy="matchingCriteria")
	@Cascade({CascadeType.ALL})
	private Set<LoanRequest> matchingLoanRequests;

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

	public Set<LoanRequest> getMatchingLoanRequests() {
		return matchingLoanRequests;
	}

	public void setMatchingLoanRequests(Set<LoanRequest> matchingLoanRequests) {
		this.matchingLoanRequests = matchingLoanRequests;
	}

	public Lender getLenderCriteria() {
		return lenderCriteria;
	}

	public void setLenderCriteria(Lender lenderCriteria) {
		this.lenderCriteria = lenderCriteria;
	}

	public Set<Attribute> getAttributeList() {
		return attributeList;
	}

	public void setAttributeList(Set<Attribute> attributeList) {
		this.attributeList = attributeList;
	}

	public LoanTemplate getLoanCriteriaTemplate() {
		return loanCriteriaTemplate;
	}

	public void setLoanCriteriaTemplate(LoanTemplate loanCriteriaTemplate) {
		this.loanCriteriaTemplate = loanCriteriaTemplate;
	}

}
