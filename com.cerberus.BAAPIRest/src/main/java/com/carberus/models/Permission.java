package com.carberus.models;

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
@Table(name="Permissions")
public class Permission implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name = "PermissionsId" )	
	private Integer permissionId;
	
	@Column(name = "CanManegeProducts" )	
	private Boolean canManegeProducts;
	
	@Column(name = "CanManagePromotions" )	
	private Boolean canManagePromotions;
	
	@Column(name = "CanManageOrders" )	
	private Boolean canManageOrders;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RolId")
	private Rol rol;

	public Integer getPermissionsId() {
		return permissionId;
	}

	public void setPermissionsId(Integer permissionsId) {
		this.permissionId = permissionsId;
	}

	public Boolean getCanManegeProducts() {
		return canManegeProducts;
	}

	public void setCanManegeProducts(Boolean canManegeProducts) {
		this.canManegeProducts = canManegeProducts;
	}

	public Boolean getCanManagePromotions() {
		return canManagePromotions;
	}

	public void setCanManagePromotions(Boolean canManagePromotions) {
		this.canManagePromotions = canManagePromotions;
	}

	public Boolean getCanManageOrders() {
		return canManageOrders;
	}

	public void setCanManageOrders(Boolean canManageOrders) {
		this.canManageOrders = canManageOrders;
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

	public Permission() {
	}

	public Permission(Integer permissionsId, Boolean canManegeProducts, Boolean canManagePromotions,
			Boolean canManageOrders, Rol rol) {
		this.permissionId = permissionsId;
		this.canManegeProducts = canManegeProducts;
		this.canManagePromotions = canManagePromotions;
		this.canManageOrders = canManageOrders;
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "{ \"permissionsId\":\"" + permissionId + "\", \"canManegeProducts\":\"" + canManegeProducts
				+ "\", \"canManagePromotions\":\"" + canManagePromotions + "\", \"canManageOrders\":\""
				+ canManageOrders + "\", \"rol\": " + rol.toString() + "}";
	}
		
}
