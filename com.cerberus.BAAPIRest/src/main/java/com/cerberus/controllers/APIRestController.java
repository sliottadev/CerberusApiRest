package com.cerberus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cerberus.enums.LoggerType;
import com.cerberus.helpers.GenericMapper;
import com.cerberus.helpers.Logger;
import com.cerberus.models.Product;
import com.cerberus.models.Rol;
import com.cerberus.models.User;
import com.cerberus.services.IMiscService;
import com.cerberus.services.IProductService;
import com.cerberus.services.IUserService;

@RestController
@RequestMapping("/")
public class APIRestController {

	@Autowired
	IUserService userService;
	
	@Autowired
	IProductService productService;
	
	@Autowired
	IMiscService miscService;
	
	@Autowired
	Logger log;

	@GetMapping("test")
	public String HelloTest() {
		return "Hello World!!!";
	}

	/*
	@GetMapping("GetRoles")
	public String GetRoles() {
		List<Rol> Result = (List<Rol>) userService.GetRoles();
		if (Result != null) {
			String json = GenericMapper.serialize(Result);
			log.Write(LoggerType.LOG_AUDIT, json);
			return json;
		}
		return "";
	}

	@GetMapping("GetPermissions")
	public String GetPermissions() {
		return userService.GetPermissions().toString();
	}

	@GetMapping("GetPermissionById/{id}")
	public String GetPermissionById(@PathVariable Integer id) {
		return userService.GetPermissionById(id).toString();
	}

	@GetMapping("GetUsers")
	public Iterable<User> GetUsers() {
		return userService.GetUsers();
	}

	@GetMapping("GetUserById/{id}")
	public User GetUserById(@PathVariable Integer id) {
		return userService.GetUserById(id);
	}
	*/

	/*
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("GetProducts")
	public Iterable<Product> GetProducts() {
		return productService.GetProducts();
	}

	@GetMapping("GetProductById/{id}")
	public String GetProductById(@PathVariable Integer id) {
		return productService.GetProductById(id).toString();
	}

	@GetMapping("GetPromotionItems")
	public String GetPromotionItems() {
		return productService.GetPromotionItems().toString();
	}

	@GetMapping("GetPromotionItemByPromotionId/{id}")
	public String GetPromotionItemByPromotionId(@PathVariable Integer id) {
		return productService.GetPromotionItemByPromotionId(id).toString();
	}

	@GetMapping("GetPromotionItemById/{id}")
	public String GetPromotionItemById(@PathVariable Integer id) {
		return productService.GetPromotionItemById(id).toString();
	}
	*/

	/*
	@GetMapping("GetOptionsByProductId/{id}")
	public String GetOptionsByProductId(@PathVariable Integer id) {
		return productService.GetOptionsByProductId(id).toString();
	}

	@GetMapping("GetOptionById/{id}")
	public String GetOptionById(@PathVariable Integer id) {
		return productService.GetOptionById(id).toString();
	}

	@GetMapping("GetProductsOptions")
	public String GetProductsOptions() {
		return productService.GetProductsOptions().toString();
	}
	*/

	/*
	@GetMapping("GetWaiters")
	public String GetWaiters() {
		return miscService.GetWaiters().toString();
	}

	@GetMapping("GetWaiters/{id}")
	public String GetWaiters(@PathVariable Integer id) {
		return miscService.GetWaiterById(id).toString();
	}

	@GetMapping("GetTables")
	public String GetTables() {
		return miscService.GetTables().toString();
	}
	
	@GetMapping("GetTables/{id}")
	public String GetTableById(@PathVariable Integer id) {
		return miscService.GetTableById(id).toString();
	}
	*/
}
