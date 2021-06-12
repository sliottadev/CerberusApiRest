package com.cerberus.repositories;

import com.cerberus.models.Client;

public interface IClientRepo {

	public Iterable<Client> GetClients();

	public Client ClientLogin(Client client);

	public Client ClientRegister(Client client);

	public Client UpdateClient(Client client, Integer id);

	public void DeleteClient(Integer id);

}
