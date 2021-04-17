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
@Table(name="Products")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name = "ProductId" )	
	private Integer productId;
	
	@Column(name = "Description" )	
	private String description;
	
	@Column(name = "Details" )	
	private String details;
	
	@Column(name = "Price" )	
	private Double price;
	
	@Column(name = "HasOptions" )	
	private Boolean hasOptions;
	
	@Column(name = "Enabled" )	
	private Boolean enabled;
	
	@Column(name = "CreateDate" )	
	private Date createDate;
	
	@Column(name = "ModifyDate" )	
	private Date modifyDate;
	
	@Column(name = "DeleteDate" )	
	private Date deleteDate;
	
	@Column(name = "IsPromo" )	
	private Boolean isPromo;
	
	@Column(name = "StartDate" )	
	private Date startDate;
	
	@Column(name = "EndDate" )	
	private Date endDate;
	
	@Column(name = "HourStart" )	
	private Date hourStart;
	
	@Column(name = "HourEnd" )	
	private Date hourEnd;
	
	@Column(name = "Days" )	
	private String days;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CategoryId")	
	private Category category;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ImageId")
	private Image image;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
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

	public Boolean getHasOptions() {
		return hasOptions;
	}

	public void setHasOptions(Boolean hasOptions) {
		this.hasOptions = hasOptions;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
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

	public Boolean getIsPromo() {
		return isPromo;
	}

	public void setIsPromo(Boolean isPromo) {
		this.isPromo = isPromo;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getHourStart() {
		return hourStart;
	}

	public void setHourStart(Date hourStart) {
		this.hourStart = hourStart;
	}

	public Date getHourEnd() {
		return hourEnd;
	}

	public void setHourEnd(Date hourEnd) {
		this.hourEnd = hourEnd;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	public Product() {
	}

	public Product(Integer productId, String description, String details, Double price, Boolean hasOptions,
			Boolean enabled, Date createDate, Date modifyDate, Date deleteDate, Boolean isPromo, Date startDate,
			Date endDate, Date hourStart, Date hourEnd, String days, Category category, Image image) {
		this.productId = productId;
		this.description = description;
		this.details = details;
		this.price = price;
		this.hasOptions = hasOptions;
		this.enabled = enabled;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.deleteDate = deleteDate;
		this.isPromo = isPromo;
		this.startDate = startDate;
		this.endDate = endDate;
		this.hourStart = hourStart;
		this.hourEnd = hourEnd;
		this.days = days;
		this.category = category;
		this.image = image;
	}

	@Override
	public String toString() {
		return "{ \"productId\":\"" + productId + "\", \"description\":\"" + description + "\", \"details\":\""
				+ details + "\", \"price\":\"" + price + "\", \"hasOptions\":\"" + hasOptions + "\", \"enabled\":\""
				+ enabled + "\", \"createDate\":\"" + createDate + "\", \"modifyDate\":\"" + modifyDate
				+ "\", \"deleteDate\":\"" + deleteDate + "\", \"isPromo\":\"" + isPromo + "\", \"startDate\":\""
				+ startDate + "\", \"endDate\":\"" + endDate + "\", \"hourStart\":\"" + hourStart + "\", \"hourEnd\":\""
				+ hourEnd + "\", \"days\":\"" + days + "\", \"category\": {" + category.toString() + " }, \"image\":\"" + image
				+ "\"}";
	}
	
	

	
}
