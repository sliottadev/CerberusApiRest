package com.cerberus.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ClientDetails")
public class ClientDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name = "ClientDetailId")
	private Integer clientDetailId;

	@Column(name = "FirstName")
	private String firstName;
	
	@Column(name = "LastName")
	private String lastName;
	
	@Column(name = "Address")
	private String address;
	
	@Column(name = "City")
	private String city;
	
	@Column(name = "Country")
	private String country;
	
	@Column(name = "GMCoord")
	private String gMCoord;
	
	@Column(name = "ZipCode")
	private String zipCode;
	
	@Column(name = "Phone")
	private String phone;
	
	@Column(name = "WhatsAppPhone")
	private String whatsAppPhone;
	
	@Column(name = "IsMailSubscribed")
	private Boolean isMailSubscribed;
	
	@Column(name = "IsWhatsAppSubscribed")
	private Boolean isWhatsAppSubscribed;
	
	@Column(name = "LastSession")
	private Date lastSession;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ClientId")
	private Client client;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getgMCoord() {
		return gMCoord;
	}

	public void setgMCoord(String gMCoord) {
		this.gMCoord = gMCoord;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWhatsAppPhone() {
		return whatsAppPhone;
	}

	public void setWhatsAppPhone(String whatsAppPhone) {
		this.whatsAppPhone = whatsAppPhone;
	}

	public Boolean getIsMailSubscribed() {
		return isMailSubscribed;
	}

	public void setIsMailSubscribed(Boolean isMailSubscribed) {
		this.isMailSubscribed = isMailSubscribed;
	}

	public Boolean getIsWhatsAppSubscribed() {
		return isWhatsAppSubscribed;
	}

	public void setIsWhatsAppSubscribed(Boolean isWhatsAppSubscribed) {
		this.isWhatsAppSubscribed = isWhatsAppSubscribed;
	}

	public Date getLastSession() {
		return lastSession;
	}

	public void setLastSession(Date lastSession) {
		this.lastSession = lastSession;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getClientDetailId() {
		return clientDetailId;
	}

	public ClientDetail(String firstName, String lastName, String address, String city, String country, String gMCoord,
			String zipCode, String phone, String whatsAppPhone, Boolean isMailSubscribed, Boolean isWhatsAppSubscribed,
			Date lastSession, Client client) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.country = country;
		this.gMCoord = gMCoord;
		this.zipCode = zipCode;
		this.phone = phone;
		this.whatsAppPhone = whatsAppPhone;
		this.isMailSubscribed = isMailSubscribed;
		this.isWhatsAppSubscribed = isWhatsAppSubscribed;
		this.lastSession = lastSession;
		this.client = client;
	}

	public ClientDetail() {
		super();
	}
		
}

