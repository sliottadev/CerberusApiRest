package com.cerberus.services;

import com.cerberus.models.Mesa;
import com.cerberus.models.Waiter;

public interface IMiscService {

	public Iterable<Waiter> GetWaiters();
	
	public Waiter GetWaiterById(Integer id);

	public Iterable<Mesa> GetTables();

	public Mesa GetTableById(Integer id);
}
