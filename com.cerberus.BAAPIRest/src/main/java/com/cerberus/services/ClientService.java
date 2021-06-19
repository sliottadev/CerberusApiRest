package com.cerberus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerberus.models.Client;
import com.cerberus.repositories.IClientRepo;

@Service
public class ClientService implements IClientService{
	
	@Autowired 
	private IClientRepo clientRepo;

	@Override
	public Iterable<Client> GetClients() {
		return clientRepo.GetClients();
	}

	@Override
	public Client ClientLogin(Client client) {
		return clientRepo.ClientLogin(client);
	}

	@Override
	public Client ClientRegister(Client client) {
		return clientRepo.ClientRegister(client);
	}

	@Override
	public Client UpdateClient(Client client, Integer id) {	
		return clientRepo.UpdateClient(client, id);
	}

	@Override
	public void DeleteClient(Integer id) {
		clientRepo.DeleteClient(id);
		
	}

}
