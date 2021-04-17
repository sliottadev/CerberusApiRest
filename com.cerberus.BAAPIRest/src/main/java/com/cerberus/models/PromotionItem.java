package com.cerberus.models;

import java.io.Serializable;

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
@Table(name="PromotionsItems")
public class PromotionItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name = "PromotionItemsId" )	
	private Integer promotionItemsId;
	
	@Column(name = "Quantity" )	
	private Integer quantity;
	
	@Column(name = "PromotionId" )	
	private Integer promotionId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ProductId")
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OptionId")
	private Option option;

	public Integer getPromotionItemsId() {
		return promotionItemsId;
	}

	public void setPromotionItemsId(Integer promotionItemsId) {
		this.promotionItemsId = promotionItemsId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(Integer promotionId) {
		this.promotionId = promotionId;
	}

	public Product getProductId() {
		return product;
	}

	public void setProductId(Product productId) {
		this.product = productId;
	}

	public Option getOptionId() {
		return option;
	}

	public void setOptionId(Option optionId) {
		this.option = optionId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public PromotionItem() {
	}

	public PromotionItem(Integer promotionItemsId, Integer quantity, Integer promotionId, Product product,
			Option option) {
		this.promotionItemsId = promotionItemsId;
		this.quantity = quantity;
		this.promotionId = promotionId;
		this.product = product;
		this.option = option;
	}

	@Override
	public String toString() {
		return "{ \"promotionItemsId\":\"" + promotionItemsId + "\", \"quantity\":\"" + quantity
				+ "\", \"promotionId\":\"" + promotionId + "\", \"product\":" + ((product == null) ? "\"null\"" : product.toString()) + ", \"option\":\"" + ((option == null) ? "\"null\"" : option.toString())
				+ "\"}";
	}
	
	
}
