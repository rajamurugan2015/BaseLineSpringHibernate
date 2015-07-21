package com.mfhsapp.test.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.mfhsapp.test.enums.OptionType;
import com.mfhsapp.test.enums.Status;

@Entity
@Table(name = "KCV_OPTION")
public class Option implements Serializable{

	private static final long serialVersionUID = -7767833005444063261L;


	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "KCV_OPTION_ID",nullable = false )
	private BigInteger id;


	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "STATUS", nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;

	@Column(name = "OPTION_TYPE", nullable = false)
	@Enumerated(EnumType.STRING)
	private OptionType optionType;

	@Column(name = "CHECKED", nullable = true)
	private Boolean isChecked;

	@Column(name = "NUM_VALUE_1", nullable = true)
	private BigDecimal numValue1;

	@Column(name = "NUM_VALUE_2", nullable = true)
	private BigDecimal numValue2;

	@Column(name = "DATE_1", nullable = true)
	private Date date1;

	@Column(name = "DATE_2", nullable = true)
	private Date date2;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="KCV_OPTION_CONTAINER_ID")
	private OptionContainer optionContainer;



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

	public OptionType getOptionType() {
		return optionType;
	}

	public void setOptionType(OptionType optionType) {
		this.optionType = optionType;
	}

	public Boolean getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(Boolean isChecked) {
		this.isChecked = isChecked;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BigDecimal getNumValue1() {
		return numValue1;
	}

	public void setNumValue1(BigDecimal numValue1) {
		this.numValue1 = numValue1;
	}

	public BigDecimal getNumValue2() {
		return numValue2;
	}

	public void setNumValue2(BigDecimal numValue2) {
		this.numValue2 = numValue2;
	}

	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	public OptionContainer getOptionContainer() {
		return optionContainer;
	}

	public void setOptionContainer(OptionContainer optionContainer) {
		this.optionContainer = optionContainer;
	}


}
