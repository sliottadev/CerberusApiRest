package com.carberus.controllers;

import com.carberus.models.Mesa;
import com.carberus.models.Waiter;
import com.carberus.repositories.IMiscRepo;
import com.carberus.repositories.MiscRepo;

public class MiscController implements IMiscController {

	private IMiscRepo miscRepo = new MiscRepo();
	
	@Override
	public Iterable<Waiter> GetWaiters() {
		return miscRepo.GetWaiters();
	}

	@Override
	public Waiter GetWaiterById(Integer id) {
		return miscRepo.GetWaiterById(id);
	}

	@Override
	public Iterable<Mesa> GetTables() {
		return miscRepo.GetTables();
	}

	@Override
	public Mesa GetTableById(Integer id) {
		return miscRepo.GetTableById(id);
	}

}
