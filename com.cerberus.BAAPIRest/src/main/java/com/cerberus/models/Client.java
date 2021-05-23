package com.cerberus.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Clients")
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name = "ClientId")
	private Integer clientId;

	@Column(name = "UserName")
	private String userName;
	
	@Column(name = "Mail")
	private String mail;
	
	@Column(name = "Pass")
	private String pass;
	
	@Column(name = "IsGuest")
	private Boolean isGuest;

	@Column(name = "LogInFacebook")
	private Boolean logInFacebook;
	
	@Column(name = "LogInGoogle")
	private Boolean logInGoogle;
	
	@Column(name = "CreateDate")
	private Date createDate;
	
	@Column(name = "ModifyDate")
	private Date modifyDate;
	
	@Column(name = "DeleteDate")
	private Date deleteDate;
	
	private Image image;
	
	
	public Client() {
	}
	
	public Client(String userName, String mail, String pass, Boolean isGuest, Boolean logInFacebook,
			Boolean logInGoogle, Date createDate, Date modifyDate, Date deleteDate, Image image) {
		this.userName = userName;
		this.mail = mail;
		this.pass = pass;
		this.isGuest = isGuest;
		this.logInFacebook = logInFacebook;
		this.logInGoogle = logInGoogle;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.deleteDate = deleteDate;
		this.image = image;
	}



	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Boolean getIsGuest() {
		return isGuest;
	}

	public void setIsGuest(Boolean isGuest) {
		this.isGuest = isGuest;
	}

	public Boolean getLogInFacebook() {
		return logInFacebook;
	}

	public void setLogInFacebook(Boolean logInFacebook) {
		this.logInFacebook = logInFacebook;
	}

	public Boolean getLogInGoogle() {
		return logInGoogle;
	}

	public void setLogInGoogle(Boolean logInGoogle) {
		this.logInGoogle = logInGoogle;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getClientId() {
		return clientId;
	}
}

