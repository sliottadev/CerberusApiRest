package com.cerberus.controllers;

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

import com.cerberus.models.Waiter;
import com.cerberus.services.IWaiterService;

@RestController 
@RequestMapping("/api/waiters")
@CrossOrigin(origins = "http://localhost:4200")
public class WaiterController {

	@Autowired
	private IWaiterService waiterService;
	
	@GetMapping
	public Iterable<Waiter> GetWaiters(){
		return waiterService.GetWaiters();
	}
	
	@GetMapping("/{id}")
	public Waiter GetWaiterById(@PathVariable Integer id) {
		return waiterService.GetWaiterById(id);
	}
	
	@PostMapping("/register")
	public Waiter CreateWaiter(@RequestBody Waiter waiter) {
		return waiterService.CreateWaiter(waiter);
	}
	
	@PutMapping("/{id}")
	public Waiter UpdateWaiter(@RequestBody Waiter waiter, @PathVariable Integer id) {
		return waiterService.UpdateWaiter(waiter, id);
	}
	
	@DeleteMapping("/{id}")
	public Waiter DeleteWaiter(@PathVariable Integer id) {
		return waiterService.DeleteWaiter(id);
	}
}
