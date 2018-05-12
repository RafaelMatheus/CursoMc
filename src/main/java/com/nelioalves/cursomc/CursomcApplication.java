package com.nelioalves.cursomc;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.domain.Produto;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	@Autowired
	private CategoriaRepository repo;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	
	public static void main(String[] args)  {
		SpringApplication.run(CursomcApplication.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2.000);
		Produto p2 = new Produto(null, "Impressora", 800.0);
		Produto p3 = new Produto(null, "Mouse", 30.00);
		
		cat1.getProdutos().addAll(java.util.Arrays.asList(p1,p2));
		cat1.getProdutos().addAll(java.util.Arrays.asList(p2));
		
		p1.getCategorias().addAll(java.util.Arrays.asList(cat1));
		p2.getCategorias().addAll(java.util.Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(java.util.Arrays.asList(cat1));
		
			
		
		repo.saveAll(java.util.Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(java.util.Arrays.asList(p1,p2,p3));
		
		
		
	}
}
