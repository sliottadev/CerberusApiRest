package com.cerberus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cerberus.enums.LoggerType;
import com.cerberus.helpers.GenericMapper;
import com.cerberus.helpers.Logger;
import com.cerberus.models.Rol;
import com.cerberus.services.IMiscService;
import com.cerberus.services.IProductService;
import com.cerberus.services.IUserService;

@RestController
@RequestMapping("/")
public class APIRestController {

	@Autowired
	IUserService userController;
	
	@Autowired
	IProductService productController;
	
	@Autowired
	IMiscService miscController;
	
	@Autowired
	Logger log;

	@GetMapping("GetRoles")
	public String GetRoles() {
		List<Rol> Result = (List<Rol>) userController.GetRoles();
		if (Result != null) {
			String json = GenericMapper.serialize(Result);
			log.Write(LoggerType.LOG_AUDIT, json);
			return json;
		}
		return "";
	}
	
	@GetMapping("GetUsers")
	public String GetUsers() {
		return userController.GetUsers().toString();
	}
	
	@GetMapping("GetUserById/{id}")
	public String GetUserById(@PathVariable Integer id) {
		return userController.GetUserById(id).toString();
	}
	
	@GetMapping("GetProducts")
	public String GetProducts() {
		return productController.GetProducts().toString();
	}
	
	@GetMapping("GetProductById/{id}")
	public String GetProductById(@PathVariable Integer id) {
		return productController.GetProductById(id).toString();
	}	
	
	@GetMapping("GetPermissions")
	public String GetPermissions() {
		return userController.GetPermissions().toString();
	}
	
	@GetMapping("GetPermissionById/{id}")
	public String GetPermissionById(@PathVariable Integer id) {
		return userController.GetPermissionById(id).toString();
	}
	
	@GetMapping("GetProductsOptions")
	public String GetProductsOptions() {
		return productController.GetProductsOptions().toString();
	}
	
	@GetMapping("GetOptionsByProductId/{id}")
	public String GetOptionsByProductId(@PathVariable Integer id) {
		return productController.GetOptionsByProductId(id).toString();
	}
	
	@GetMapping("GetOptionById/{id}")
	public String GetOptionById(@PathVariable Integer id) {
		return productController.GetOptionById(id).toString();
	}
	
	@GetMapping("GetPromotionItems")
	public String GetPromotionItems() {
		return productController.GetPromotionItems().toString();
	}
	
	@GetMapping("GetPromotionItemByPromotionId/{id}")
	public String GetPromotionItemByPromotionId(@PathVariable Integer id) {
		return productController.GetPromotionItemByPromotionId(id).toString();
	}
	
	@GetMapping("GetPromotionItemById/{id}")
	public String GetPromotionItemById(@PathVariable Integer id) {
		return productController.GetPromotionItemById(id).toString();
	}
	
	@GetMapping("GetWaiters")
	public String GetWaiters() {
		return miscController.GetWaiters().toString();
	}

	@GetMapping("GetWaiters/{id}")
	public String GetWaiters(@PathVariable Integer id) {
		return miscController.GetWaiterById(id).toString();
	}

	@GetMapping("GetTables")
	public String GetTables() {
		return miscController.GetTables().toString();
	}
	
	@GetMapping("GetTables/{id}")
	public String GetTableById(@PathVariable Integer id) {
		return miscController.GetTableById(id).toString();
	}
}
