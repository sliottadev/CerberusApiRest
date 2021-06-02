package com.cerberus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerberus.models.Mesa;
import com.cerberus.models.Waiter;
import com.cerberus.repositories.IMiscRepo;

@Service
public class MiscService implements IMiscService {

	@Autowired
	private IMiscRepo miscRepo;
	
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
