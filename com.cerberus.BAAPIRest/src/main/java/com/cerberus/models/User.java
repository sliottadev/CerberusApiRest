package com.cerberus.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name = "UserId")	
	private Integer userId;
	
	@Column(name = "UserName")	
	private String userName;
	
	@Column(name = "PIN")	
	private String PIN;
	
	@Column(name = "LastConnection")	
	private Date lastConnection;
	
	@Column(name = "CreateDate")	
	private Date createDate;
	
	@Column(name = "ModifyDate")	
	private Date modifyDate;
	
	@Column(name = "DeleteDate")	
	private Date deleteDate;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ImageId")
	private Image image;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RolId")
	private Rol rol;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPIN() {
		return PIN;
	}

	public void setPIN(String PIN) {
		this.PIN = PIN;
	}

	public Date getLastConnection() {
		return lastConnection;
	}

	public void setLastConnection(Date lastConnection) {
		this.lastConnection = lastConnection;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public User() {
	}

	public User(Integer userId, String userName, String PIN, Date lastConnection, Date createDate, Date modifyDate,
			Date deleteDate, Image image, Rol rol) {
		this.userId = userId;
		this.userName = userName;
		this.PIN = PIN;
		this.lastConnection = lastConnection;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.deleteDate = deleteDate;
		this.image = image;
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "{\"userId\":" + userId + ", \"userName\":\"" + userName + "\", \"PIN\":\"" + PIN + "\", \"lastConnection\":\""
				+ lastConnection + "\", \"createDate\":\"" + createDate + "\", \"modifyDate\":\"" + modifyDate + "\", \"deleteDate\":\""
				+ deleteDate + "\", \"image\":\"" + image + "\", \"rol\":{ " + rol.toString() + "}}";
	}
	
}
