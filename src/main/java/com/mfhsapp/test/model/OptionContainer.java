package com.mfhsapp.test.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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

@Entity
@Table(name = "KCV_OPTION_CONTAINER")
public class OptionContainer implements Serializable{

	private static final long serialVersionUID = 5471958766947165941L;


	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "KCV_OPTION_CONTAINER_ID",nullable = false )
	private BigInteger id;


	@Column(name = "NAME", nullable = false)
	private String name;

	@OneToMany(mappedBy="optionContainer" )
	@Cascade({CascadeType.ALL})
	private Set<Option> optionsList;


	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="KCV_ATTRIBUTE_ID")
	private Attribute attribute;


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


	public Set<Option> getOptionsList() {
		return optionsList;
	}


	public void setOptionsList(Set<Option> optionsList) {
		this.optionsList = optionsList;
	}


	public Attribute getAttribute() {
		return attribute;
	}


	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
