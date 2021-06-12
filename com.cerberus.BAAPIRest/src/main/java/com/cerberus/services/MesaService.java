package com.cerberus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerberus.models.Mesa;
import com.cerberus.repositories.IMesaRepo;

@Service
public class MesaService implements IMesaService {
	
	@Autowired
	IMesaRepo mesaRepo;

	@Override
	public Iterable<Mesa> GetMesas() {		
		return mesaRepo.GetMesas();
	}

	@Override
	public Mesa GetMesaById(Integer id) {
		return mesaRepo.GetMesaById(id);
	}

	@Override
	public Mesa MesaRegister(Mesa mesa) {
		return mesaRepo.MesaRegister(mesa);
	}

	@Override
	public Mesa UpdateMesa(Mesa mesa, Integer id) {
		return mesaRepo.UpdateMesa(mesa, id);
	}

	@Override
	public Mesa DeleteMesa(Integer id) {
		return mesaRepo.DeleteMesa(id);
	}

}
