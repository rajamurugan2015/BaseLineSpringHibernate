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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.mfhsapp.test.enums.AttributeType;
import com.mfhsapp.test.enums.Status;

@Entity
@Table(name = "KCV_ATTRIBUTE")
public class Attribute implements Serializable{


	private static final long serialVersionUID = -7458955000612086339L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "KCV_ATTRIBUTE_ID",nullable = false )
	private BigInteger id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "STATUS", nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;

	@Column(name = "ATTRIBUTE_TYPE", nullable = false)
	@Enumerated(EnumType.STRING)
	private AttributeType attributeType;

	@OneToMany(mappedBy="attribute" )
	@Cascade({CascadeType.ALL})
	private Set<OptionContainer> optionContainerList;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="KCV_LOAN_TEMPLATE_ID")
	private LoanTemplate loanTemplateAttribute;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="KCV_LOAN_CRITERIA_ID")
	private LoanTemplate loanCriteriaAttribute;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="KCV_LOAN_REQUEST_ID")
	private LoanTemplate loanRequestAttribute;



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

	public AttributeType getAttributeType() {
		return attributeType;
	}

	public void setAttributeType(AttributeType attributeType) {
		this.attributeType = attributeType;
	}

	public Set<OptionContainer> getOptionContainerList() {
		return optionContainerList;
	}

	public void setOptionContainerList(Set<OptionContainer> optionContainerList) {
		this.optionContainerList = optionContainerList;
	}

	public LoanTemplate getLoanTemplateAttribute() {
		return loanTemplateAttribute;
	}

	public void setLoanTemplateAttribute(LoanTemplate loanTemplateAttribute) {
		this.loanTemplateAttribute = loanTemplateAttribute;
	}

	public LoanTemplate getLoanCriteriaAttribute() {
		return loanCriteriaAttribute;
	}

	public void setLoanCriteriaAttribute(LoanTemplate loanCriteriaAttribute) {
		this.loanCriteriaAttribute = loanCriteriaAttribute;
	}

	public LoanTemplate getLoanRequestAttribute() {
		return loanRequestAttribute;
	}

	public void setLoanRequestAttribute(LoanTemplate loanRequestAttribute) {
		this.loanRequestAttribute = loanRequestAttribute;
	}

}
