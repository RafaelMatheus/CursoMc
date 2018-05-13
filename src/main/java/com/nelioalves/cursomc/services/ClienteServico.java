package com.nelioalves.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.repositories.ClienteRepository;


@Service
public class ClienteServico {



		@Autowired
		private ClienteRepository repo;

		public Optional<Cliente> buscarById(Integer Id) {
			Optional<Cliente> cliente = repo.findById(Id);
			if (cliente == null) {
				
			}
			return cliente;

		}

	
}
