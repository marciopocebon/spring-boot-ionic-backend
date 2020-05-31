package com.brunomarqueslirainformatica.cursoSpringExercicio1.domain;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.brunomarqueslirainformatica.cursoSpringExercicio1.domain.enums.EstadoPagamento;

public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;  
	
	@Temporal(TemporalType.DATE)  
	private Date dataVencimento; 
	 
	@Temporal(TemporalType.DATE)  
	private Date dataPagamento; 
	
	public PagamentoComBoleto() {
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		// TODO Auto-generated constructor stub
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
}
