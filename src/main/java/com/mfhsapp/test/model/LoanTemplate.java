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
@Table(name = "KCV_LOAN_TEMPLATE")
public class LoanTemplate implements Serializable{

	private static final long serialVersionUID = 262374597532069000L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "KCV_LOAN_TEMPLATE_ID",nullable = false )
	private BigInteger id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "STATUS", nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;

	@OneToMany(mappedBy="loanTemplateAttribute" )
	@Cascade({CascadeType.ALL})
	private Set<Attribute> attributeList;

	@OneToMany(mappedBy="loanCriteriaTemplate" )
	@Cascade({CascadeType.ALL})
	private Set<LoanCriteria> loanCriteriaList;

	@OneToMany(mappedBy="loanRequestTemplate" )
	@Cascade({CascadeType.ALL})
	private Set<LoanRequest>  loanRequestList;

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

	public Set<Attribute> getAttributeList() {
		return attributeList;
	}

	public void setAttributeList(Set<Attribute> attributeList) {
		this.attributeList = attributeList;
	}

	public Set<LoanCriteria> getLoanCriteriaList() {
		return loanCriteriaList;
	}

	public void setLoanCriteriaList(Set<LoanCriteria> loanCriteriaList) {
		this.loanCriteriaList = loanCriteriaList;
	}

	public Set<LoanRequest> getLoanRequestList() {
		return loanRequestList;
	}

	public void setLoanRequestList(Set<LoanRequest> loanRequestList) {
		this.loanRequestList = loanRequestList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
