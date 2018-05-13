package com.nelioalves.cursomc.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.dto.CategoriaDto;
import com.nelioalves.cursomc.services.CategoriaService;

@RestController

@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService service;

	@RequestMapping(value = "{Id}", method = RequestMethod.GET)
	public ResponseEntity<?> listar(@PathVariable Integer Id) {
		Optional<Categoria> obj = service.find(Id);

		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Categoria obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(value = "{Id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer Id) {
		
		service.delete(Id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<CategoriaDto>> findAll() {
		List<Categoria> obj = service.findAll();
		List<CategoriaDto> listDto = obj.stream().map(obje -> new CategoriaDto(obje)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto);
	}
}
