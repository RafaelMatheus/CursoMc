package com.nelioalves.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Pedido;
import com.nelioalves.cursomc.repositories.PedidoRepositiry;
import com.nelioalves.cursomc.services.exception.ObjectNotFoundException;

@Service
public class PedidoServico {


		
		@Autowired
		private PedidoRepositiry repo;
		
		
		public Optional<Pedido> buscar(Integer Id) {
		Optional<Pedido> cat = repo.findById(Id);
		if(cat == null) {
			throw new ObjectNotFoundException("Objeto não encontrado" + Id + ", tipo" + Pedido.class.getName());
		}
		return cat;

		}
	}



