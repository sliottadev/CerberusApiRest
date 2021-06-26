package com.cerberus.services;

import com.cerberus.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerberus.models.Client;
import com.cerberus.repositories.IClientRepo;

@Service
public class ClientService implements IClientService{
	
	@Autowired 
	private IClientRepo clientRepo;

	/**
	 * Retorna la lista de clients.
	 *
	 * @return lista de clients
	 */
	@Override
	public Iterable<Client> GetClients() {
		return clientRepo.GetClients();
	}

	/**
	 * Busca un user por Id.
	 *
	 * @param id id de user a buscar
	 * @return user existente
	 */
	@Override
	public Client GetClientById(Integer id) {
		return clientRepo.GetClientById(id);
	}

	/**
	 * Crea un nuevo client.
	 *
	 * @param client client a crear
	 * @return nuevo client
	 */
	public Client CreateClient(Client client) {
		return clientRepo.CreateClient(client);
	}


	/**
	 * Actualiza client existente.
	 *
	 * @param client client a actualizar
	 * @return client actualizado
	 */
	@Override
	public Client UpdateClient(Client client, Integer id) {
		return clientRepo.UpdateClient(client, id);
	}

	/**
	 * Borra client existente.
	 *
	 * @param id id de client a eliminar
	 */
	@Override
	public void DeleteClient(Integer id) {
		clientRepo.DeleteClient(id);
	}

	@Override
	public Client ClientLogin(Client client) {
		return clientRepo.ClientLogin(client);
	}

	@Override
	public Client ClientRegister(Client client) {
		return clientRepo.ClientRegister(client);
	}

}
