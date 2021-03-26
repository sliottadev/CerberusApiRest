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
@Table(name="Waiters")
public class Waiter implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name = "WaiterId")
	private Integer waiterId;
	
	@Column(name = "Code")
	private String code;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Details")
	private String details;
	
	@Column(name = "Deleted")
	private Boolean deleted;

	public Integer getWaiterId() {
		return waiterId;
	}

	public void setWaiterId(Integer waiterId) {
		this.waiterId = waiterId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Waiter() {
	}

	public Waiter(Integer waiterId, String code, String name, String details, Boolean deleted) {
		this.waiterId = waiterId;
		this.code = code;
		this.name = name;
		this.details = details;
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "{\"waiterId\":\"" + waiterId + "\", \"code\":\"" + code + "\", \"name\":\"" + name
				+ "\", \"details\":\"" + details + "\", \"deleted\":\"" + deleted + "\"}";
	}
	
}
