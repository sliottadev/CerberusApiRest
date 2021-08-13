package com.cerberus.services;

import com.cerberus.DTOs.userLoginDTO;
import com.cerberus.models.Client;
import com.cerberus.models.Client;

public interface IClientService {

	public Iterable<Client> GetClients();

	public Boolean ClientLogin(userLoginDTO userLogin);

	public Client CreateClient (Client client);

	public Client UpdateClient(Client client, Integer id);

	public void DeleteClient(Integer id);

	public Integer getClientIdByNameOrMail(String value);

}
