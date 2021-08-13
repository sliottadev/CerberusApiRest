package com.cerberus.controllers;

import com.cerberus.models.Mesa;
import com.cerberus.models.Order;
import com.cerberus.services.IMesaService;

import com.cerberus.services.IOrderService;
import com.cerberus.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * OrdersController Path: "../orders/"
 * Controla: ABM Order, OrderDetails (orderByClientId, Ordenes Activas, etc)
 * Entidades relacionadas: Order, OrderDetails, Mesa, Waiter
 */
@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

	/**
	 * Controlador para Order
	 */

	@Autowired
	IOrderService orderService;

	@GetMapping
	public Iterable<Order> GetOrders() {
		return orderService.GetOrders();
	}

	@GetMapping("/{id}")
	public Order GetOrderById(@PathVariable Integer id) {
		return orderService.GetOrderById(id);
	}

	@PostMapping
	public Order CreateOrder(@RequestBody Order order) {
		return orderService.CreateOrder(order);
	}

	@PutMapping("/{id}")
	public Order UpdateOrder(@RequestBody Order order, @PathVariable Integer id) {
		return orderService.UpdateOrder(order, id);
	}

	@DeleteMapping("/{id}")
	public void DeleteOrder(@PathVariable Integer id) {
		orderService.DeleteOrder(id);
	}


	/**
	 * Controlador para Mesa
	 */

	@Autowired
	IMesaService mesaService;
	
	@GetMapping("/tables")
	public Iterable<Mesa> GetMesas(){
		return mesaService.GetMesas();
	}
	
	@GetMapping("/tables/{id}")
	public Mesa GetMesaById(@PathVariable Integer id) {
		return mesaService.GetMesaById(id);
	}
	
	@PostMapping("/tables")
	public Mesa CreateMesa(@RequestBody Mesa mesa) {
		return mesaService.CreateMesa(mesa);
	}
	
	@PutMapping("/tables/{id}")
	public Mesa UpdateMesa(@RequestBody Mesa mesa, @PathVariable Integer id) {
		return mesaService.UpdateMesa(mesa, id);
	}
	
	@DeleteMapping("/tables/{id}")
	public Mesa DeleteMesa(@PathVariable Integer id) {
		return mesaService.DeleteMesa(id);
	}
}
