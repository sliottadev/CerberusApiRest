package com.cerberus.controllers;

import com.cerberus.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cerberus.models.Client;
import com.cerberus.services.IClientService;

/**
 * ClientsController Path: "../clients/"
 * Controla: clientes, login de clientes, detalle de clientes
 * Entidades relacionadas: Client, ClientDetails
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/clients")
public class ClientController {
	
	@Autowired
	private IClientService clientService;

	@GetMapping 
	public Iterable<Client> GetClients(){
		return clientService.GetClients();
	}

//	@GetMapping("/{id}")
//	public Client GetClientById(@PathVariable Integer id) {
//		return clientService.GetClientById(id);
//	}

	@GetMapping("/getClientIdByNameOrMail")
	public Integer getClientbyNameOrMail(@RequestParam String value) {
		return clientService.getClientIdByNameOrMail(value);
	}
	
	/*
	@PostMapping 
	public Client ClientLogin(@RequestBody Client client) {
		return clientService.ClientLogin(client);
	}

	@PostMapping
	public Client CreateClient(@RequestBody Client client) {
		return clientService.CreateClient(client);
	}
	
	@PutMapping("/{id}")
	public Client UpdateClient(@RequestBody Client client, @PathVariable Integer id) {
		return clientService.UpdateClient(client, id);
	}
	
	@DeleteMapping("/{id}")
	public void DeleteClient(@PathVariable Integer id) {
		clientService.DeleteClient(id);
	}
	*/
	
}
