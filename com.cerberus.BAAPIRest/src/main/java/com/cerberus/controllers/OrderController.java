package com.cerberus.controllers;

import com.cerberus.models.Mesa;
import com.cerberus.services.IMesaService;

import org.springframework.beans.factory.annotation.Autowired;
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
 * Entidades relacionadas: Order, OrderDetails, Table, Waiter
 */
@RestController
@RequestMapping("/orders")
public class OrderController {
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
	
	@PostMapping("/tables/register")
	public Mesa MesaRegister(@RequestBody Mesa mesa) {
		return mesaService.MesaRegister(mesa);
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
