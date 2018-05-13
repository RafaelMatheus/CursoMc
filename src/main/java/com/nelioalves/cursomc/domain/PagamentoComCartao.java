package com.nelioalves.cursomc.domain;

import com.nelioalves.cursomc.domain.enuns.EstadoPagamento;

public class PagamentoComCartao extends Pagamento {
	
	private static final long serialVersionUID = 1L;
	
	
	private Integer numeroParcelas;

	public PagamentoComCartao() {
	
	}

	
	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido) {
		super(id, estado, pedido);
		// TODO Auto-generated constructor stub
	}



	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}

	
	
	

}
