package com.cerberus.services;

import com.cerberus.models.Client;
import com.cerberus.models.Client;

public interface IClientService {

	public Iterable<Client> GetClients();

	public Client GetClientById(Integer id);

	public Client CreateClient (Client client);

	public Client UpdateClient(Client client, Integer id);

	public void DeleteClient(Integer id);

	public Client ClientLogin(Client client);

	public Client ClientRegister(Client client);

}
