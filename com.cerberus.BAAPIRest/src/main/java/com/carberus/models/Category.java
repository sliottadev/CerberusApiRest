package com.carberus.models;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Categories")
public class Category implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name = "CategoryId" )	
	private Integer categoryId;
	
	@Column(name = "Code" )	
	private String code;
	
	@Column(name = "Description" )	
	private String Description;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Category() {
	}

	public Category(Integer categoryId, String code, String description) {
		this.categoryId = categoryId;
		this.code = code;
		Description = description;
	}

	@Override
	public String toString() {
		return "{ \"CategoryId\":\"" + categoryId + "\", \"Code\":\"" + code + "\", \"Description\":\"" + Description
				+ "\"}";
	}	
	
}
