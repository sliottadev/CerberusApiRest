package com.cerberus.repositories;

import com.cerberus.models.Mesa;
import com.cerberus.models.Waiter;

public interface IMiscRepo {

	public Iterable<Waiter> GetWaiters();

	public Waiter GetWaiterById(Integer id);

	public Iterable<Mesa> GetTables();

	public Mesa GetTableById(Integer id);

}
