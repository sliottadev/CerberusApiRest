package com.cerberus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerberus.models.Waiter;
import com.cerberus.repositories.IWaiterRepo;
@Service
public class WaiterService implements IWaiterService{

	@Autowired
	IWaiterRepo waiterRepo;

	@Override
	public Iterable<Waiter> GetWaiters() {
		return waiterRepo.GetWaiters();
	}

	@Override
	public Waiter GetWaiterById(Integer id) {
		return waiterRepo.GetWaiterById(id);
	}

	@Override
	public Waiter CreateWaiter(Waiter waiter) {
		return waiterRepo.CreateWaiter(waiter);
	}

	@Override
	public Waiter UpdateWaiter(Waiter waiter, Integer id) {
		return waiterRepo.UpdateWaiter(waiter, id);
	}

	@Override
	public Waiter DeleteWaiter(Integer id) {
		return waiterRepo.DeleteWaiter(id);
		
	}
}
