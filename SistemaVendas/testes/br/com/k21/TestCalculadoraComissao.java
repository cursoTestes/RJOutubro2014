package br.com.k21;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class TestCalculadoraComissao{
	
	@Test
	public void calcula_comissao_venda_100_retornando_5() {
		int valor_venda = 100;
		int valor_comissao_esperada = 5;
		
		double retorno = new CalculadoraComissao().calcula(valor_venda);
		
		assertEquals(valor_comissao_esperada, retorno, 0);
	}
	
	@Test
	public void calcula_comissao_venda_10000_retornando_500() {
		int valor_venda = 10000;
		int valor_comissao_esperada = 500;
		
		double retorno = new CalculadoraComissao().calcula(valor_venda);
		
		assertEquals(valor_comissao_esperada, retorno, 0);
	}
	
	@Test
	public void calcula_comissao_venda_1_retornando_5_centavos() {
		int valor_venda = 1;
		double valor_comissao_esperada = 0.05;
		
		double retorno = new CalculadoraComissao().calcula(valor_venda);
		
		assertEquals(valor_comissao_esperada, retorno, 0);
	}
	
	@Test
	public void calcula_comissao_venda_1_55_centavos_retornando_5_centavos() {
		double valor_venda = 1.55;
		double valor_comissao_esperada = 0.0775;
		
		double retorno = new CalculadoraComissao().calcula(valor_venda);
		
		assertEquals(valor_comissao_esperada, retorno, 0);
	}
}
