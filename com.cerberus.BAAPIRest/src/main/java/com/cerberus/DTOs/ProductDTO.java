package com.cerberus.DTOs;

public class ProductDTO {
	private Integer ProductId;
	private Integer Quantity;
	public ProductDTO() {
		super();
	}
	public Integer getProductId() {
		return ProductId;
	}
	public void setProductId(Integer productId) {
		ProductId = productId;
	}
	public Integer getQuantity() {
		return Quantity;
	}
	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}
	public ProductDTO(Integer productId, Integer quantity) {
		super();
		ProductId = productId;
		Quantity = quantity;
	}
	
	
}
