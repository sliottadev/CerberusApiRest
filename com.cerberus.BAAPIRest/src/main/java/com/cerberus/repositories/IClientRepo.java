package com.cerberus.repositories;

import com.cerberus.models.Client;
import com.cerberus.models.Client;

public interface IClientRepo {

	public Iterable<Client> GetClients();

	public Client GetClientById(Integer id);

	public Client CreateClient(Client client);

	public Client UpdateClient(Client client, Integer id);

	public void DeleteClient(Integer id);

	public Client ClientLogin(Client client);

	public Client ClientRegister(Client client);

}
