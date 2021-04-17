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
@Table(name="Tables")
public class Mesa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name = "TableId" )	
	private Integer tableId;
	
	@Column(name = "Code" )	
	private String code;
	
	@Column(name = "Location" )	
	private String location;
	
	@Column(name = "Enabled" )	
	private Boolean enabled;
	
	@Column(name = "Visible" )	
	private Boolean visible;

	@Column(name = "Deleted" )	
	private Boolean deleted;

	public Integer getTableId() {
		return tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
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

	public Mesa() {
	}

	public Mesa(Integer tableId, String code, String location, Boolean enabled, Boolean visible, Boolean deleted) {
		this.tableId = tableId;
		this.code = code;
		this.location = location;
		this.enabled = enabled;
		this.visible = visible;
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "{\"tableId\":\"" + tableId + "\", \"code\":\"" + code + "\", \"location\":\"" + location
				+ "\", \"enabled\":\"" + enabled + "\", \"visible\":\"" + visible + "\", \"deleted\":\"" + deleted
				+ "\"}";
	}
	
}
