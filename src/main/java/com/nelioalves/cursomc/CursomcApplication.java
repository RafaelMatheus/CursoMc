package com.nelioalves.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.domain.Cidade;
import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.domain.Endereco;
import com.nelioalves.cursomc.domain.Estado;
import com.nelioalves.cursomc.domain.Pagamento;
import com.nelioalves.cursomc.domain.PagamentoComBoleto;
import com.nelioalves.cursomc.domain.PagamentoComCartao;
import com.nelioalves.cursomc.domain.Pedido;
import com.nelioalves.cursomc.domain.Produto;
import com.nelioalves.cursomc.domain.enuns.EstadoPagamento;
import com.nelioalves.cursomc.domain.enuns.TipoCliente;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.repositories.CidadeRepository;
import com.nelioalves.cursomc.repositories.ClienteRepository;
import com.nelioalves.cursomc.repositories.EnderecoRepository;
import com.nelioalves.cursomc.repositories.EstadoRepository;
import com.nelioalves.cursomc.repositories.PagamentoRepository;
import com.nelioalves.cursomc.repositories.PedidoRepositiry;
import com.nelioalves.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	@Autowired
	private CategoriaRepository repo;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepositiry pedidoRepositiry;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	
	
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
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(java.util.Arrays.asList(c1));
		est2.getCidades().addAll(java.util.Arrays.asList(c2,c3));
		
		Cliente cli1= new Cliente(null, "Maria Silva", "maria@gmail.com", "1111111111111",TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("999999999999999"));
		
		Endereco e1= new Endereco(null, "Rua flores", "300", "Apto 303","Jardim","3212", cli1, c1);
		Endereco e2= new Endereco(null, "Rua flores", "300", "Apto 303","Jardim","3212", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:32"), cli1, e2);
		
		Pagamento pagTo1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);	
		ped1.setPagamento(pagTo1);
		
		
		
		
		Pagamento pagTo2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);	
		ped2.setPagamento(pagTo2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		
		
		
			
		
		repo.saveAll(java.util.Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		
		
		pedidoRepositiry.saveAll(Arrays.asList(ped1,ped2));
		
		pagamentoRepository.saveAll(Arrays.asList(pagTo1,pagTo2));
	}
}
