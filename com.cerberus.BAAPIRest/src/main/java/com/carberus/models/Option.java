package com.carberus.models;

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
@Table(name="Options")
public class Option implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name = "OptionId" )	
	private Integer optionId;
	
	@Column(name = "Description" )	
	private String description;
	
	@Column(name = "Details" )	
	private String details;
	
	@Column(name = "Price" )	
	private Double price;
	
	@Column(name = "CreateDate" )	
	private Date createDate;
	
	@Column(name = "ModifyDate" )	
	private Date modifyDate;
	
	@Column(name = "DeleteDate" )	
	private Date deleteDate;
	
	@Column(name = "Enabled" )	
	private Boolean enabled;
	
	@Column(name = "ProductId" )	
	private Integer productId;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ImageId")
	private Image Image;

	public Integer getOptionId() {
		return optionId;
	}

	public void setOptionId(Integer optionId) {
		this.optionId = optionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Image getImageId() {
		return Image;
	}

	public void setImageId(Image imageId) {
		Image = imageId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Option() {
	}

	public Option(Integer optionId, String description, String details, Double price, Date createDate, Date modifyDate,
			Date deleteDate, Boolean enabled, Integer productId, Image imageId) {
		this.optionId = optionId;
		this.description = description;
		this.details = details;
		this.price = price;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.deleteDate = deleteDate;
		this.enabled = enabled;
		this.productId = productId;
		Image = imageId;
	}

	@Override
	public String toString() {
		return "{ \"optionId\":\"" + optionId + "\", \"description\":\"" + description + "\", \"details\":\""
				+ details + "\", \"price\":\"" + price + "\", \"createDate\":\"" + createDate + "\", \"modifyDate\":\""
				+ modifyDate + "\", \"deleteDate\":\"" + deleteDate + "\", \"enabled\":\"" + enabled
				+ "\", \"productId\":\"" + productId.toString() + "\", \"Image\":\"" + Image + "\"}";
	}
	
	
}
