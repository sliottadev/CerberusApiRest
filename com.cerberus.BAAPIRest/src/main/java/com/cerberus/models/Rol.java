package com.cerberus.models;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Roles")
public class Rol implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name = "RolId" )	
	private Integer RolId;
	
	@Column(name = "Description" )	
	private String Description;
	
	public Integer getRolId() {
		return RolId;
	}

	public void setRolId(Integer rolId) {
		RolId = rolId;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Rol() {
	}

	public Rol(Integer rolId, String description) {
		RolId = rolId;
		Description = description;
	}

	@Override
	public String toString() {
		return "{\"RolId\":" + RolId + ", \"Description\":\"" + Description + "\"}";
	}
		
}
