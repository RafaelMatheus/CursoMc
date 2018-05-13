package com.nelioalves.cursomc.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.services.ClienteServico;


@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	@Autowired
	private ClienteServico service;
	
	
	@RequestMapping(value="{Id}", method=RequestMethod.GET)	
	public ResponseEntity<?> find(@PathVariable Integer Id) {
		Optional<Cliente> obj = service.find(Id);
			
		
		return ResponseEntity.ok().body(obj);
	}

}
