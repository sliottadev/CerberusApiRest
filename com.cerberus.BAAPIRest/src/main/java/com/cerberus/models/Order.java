package com.cerberus.models;

import java.io.Serializable;
import java.util.Currency;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Orders")
public class Order implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name = "OrderId")
	private Integer OrderId;

	@Column(name = "PartialPayment")
	private Double partialPayment;

	@Column(name = "State")
	private String state;
	
	@Column(name = "BonusPorc")
	private Integer bonusPorc;
	
	@Column(name = "CreateDate")
	private Date createDate;
	
	@Column(name = "CloseDate")
	private Date closeDate;
	
	@Column(name = "ModifyDate")
	private Date modifyDate;
	
	@Column(name = "DeleteDate")
	private Date deleteDate;

	@Column(name = "ClientId")
	private Integer clientId;

	@Column(name = "TableId")
	private Integer tableId;

	@Column(name = "WaiterId")
	private Integer waiterId;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getOrderId() {
		return OrderId;
	}

	public void setOrderId(Integer orderId) {
		OrderId = orderId;
	}

	public Double getPartialPayment() {
		return partialPayment;
	}

	public void setPartialPayment(Double partialPayment) {
		this.partialPayment = partialPayment;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getBonusPorc() {
		return bonusPorc;
	}

	public void setBonusPorc(Integer bonusPorc) {
		this.bonusPorc = bonusPorc;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
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

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getTableId() {
		return tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public Integer getWaiterId() {
		return waiterId;
	}

	public void setWaiterId(Integer waiterId) {
		this.waiterId = waiterId;
	}

	public Order(Double partialPayment, String state, Integer bonusPorc, Date createDate, Date closeDate,
				 Date modifyDate, Date deleteDate, Integer clientId, Integer tableId, Integer waiterId) {
		this.partialPayment = partialPayment;
		this.state = state;
		this.bonusPorc = bonusPorc;
		this.createDate = createDate;
		this.closeDate = closeDate;
		this.modifyDate = modifyDate;
		this.deleteDate = deleteDate;
		this.clientId = clientId;
		this.tableId = tableId;
		this.waiterId = waiterId;
	}

	public Order() {
	}
	
}
