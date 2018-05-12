package com.nelioalves.cursomc;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	@Autowired
	private CategoriaRepository repo;
	
	
	public static void main(String[] args)  {
		SpringApplication.run(CursomcApplication.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Saúde");
		
		repo.saveAll(java.util.Arrays.asList(cat1,cat2, cat3));
		
		
	}
}
