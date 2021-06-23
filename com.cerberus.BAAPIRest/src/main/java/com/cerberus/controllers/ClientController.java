package com.cerberus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cerberus.models.Client;
import com.cerberus.services.IClientService;

/**
 * ClientsController Path: "../clients/"
 * Controla: clientes, login de clientes, detalle de clientes
 * Entidades relacionadas: Client, ClientDetails
 */
@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	private IClientService clientService;

	@GetMapping 
	public Iterable<Client> GetClients(){
		return clientService.GetClients();
	}
	
	@PutMapping("/{id}")
	public Client UpdateClient(@RequestBody Client client, @PathVariable Integer id) {
		return clientService.UpdateClient(client, id);
	}
	
	@DeleteMapping("/{id}")
	public void DeleteClient(@PathVariable Integer id) {
		clientService.DeleteClient(id);
	}
}
