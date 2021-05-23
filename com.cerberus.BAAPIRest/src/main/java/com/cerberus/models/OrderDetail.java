package com.cerberus.models;

import java.io.Serializable;

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
@Table(name="OrderDetails")
public class OrderDetail implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name = "OrderDetailId" )		
	private Integer orderDetailId;
	
	@Column(name = "Quantity" )		
	private Integer quantity;
	
	@Column(name = "Rewarded" )		
	private Boolean rewarded;
	
	@Column(name = "BonusPorc" )		
	private Integer bonusPorc;

	@Column(name = "State" )		
	private String state;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="OrderId")
	private Order order;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OptionId")
	private Option option;

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Boolean getRewarded() {
		return rewarded;
	}

	public void setRewarded(Boolean rewarded) {
		this.rewarded = rewarded;
	}

	public Integer getBonusPorc() {
		return bonusPorc;
	}

	public void setBonusPorc(Integer bonusPorc) {
		this.bonusPorc = bonusPorc;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Option getOption() {
		return option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getOrderDetailId() {
		return orderDetailId;
	}

	public OrderDetail(Integer quantity, Boolean rewarded, Integer bonusPorc, String state, Order order,
			Option option) {
		this.quantity = quantity;
		this.rewarded = rewarded;
		this.bonusPorc = bonusPorc;
		this.state = state;
		this.order = order;
		this.option = option;
	}

	public OrderDetail() {
	}
	
}
