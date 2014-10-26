package br.com.k21;

import java.util.List;

import br.com.k21.dao.VendaRepository;
import br.com.k21.modelo.Venda;

public class CalculadoraRoyalties {

	private CalculadoraComissao calculadoraComissao;
	private VendaRepository vendaRepository;
	
	public CalculadoraRoyalties(CalculadoraComissao calculadoraComissao,
			VendaRepository vendaRepository) {
		this.calculadoraComissao = calculadoraComissao;
		this.vendaRepository = vendaRepository;
	}

	public double calcula(int mes, int ano) {

		List<Venda> vendasPorMesEAno = vendaRepository.obterVendasPorMesEAno(ano, mes);
		double total = 0;
		
		for (Venda venda : vendasPorMesEAno) {
			double comissao = calculadoraComissao.calcula(venda.getValor());
			total += (venda.getValor() - comissao);
		}
		
		return total * 0.2;
	}

}
