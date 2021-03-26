package com.carberus.controllers;

import com.carberus.models.Mesa;
import com.carberus.models.Waiter;

public interface IMiscController {

	public Iterable<Waiter> GetWaiters();
	
	public Waiter GetWaiterById(Integer id);

	public Iterable<Mesa> GetTables();

	public Mesa GetTableById(Integer id);
}
