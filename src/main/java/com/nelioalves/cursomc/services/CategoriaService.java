package com.nelioalves.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	
	public Optional<Categoria> find(Integer Id) {
	Optional<Categoria> cat = repo.findById(Id);
	if(cat == null) {
		throw new ObjectNotFoundException("Objeto não encontrado" + Id + ", tipo" + Categoria.class.getName());
	}
	return cat;

	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		
		return repo.save(obj);
	}
	
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
		
	}
	public List<Categoria> findAll(){
		return repo.findAll();
	}
}
