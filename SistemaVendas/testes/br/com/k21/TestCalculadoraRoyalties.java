package br.com.k21;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.k21.dao.VendaRepository;
import br.com.k21.modelo.Venda;

public class TestCalculadoraRoyalties {
	
	private CalculadoraComissao calComissaoMock;
	private VendaRepository repositoryMock;

	@Before
	public void inicializarMocks()
	{
		calComissaoMock = Mockito.mock( CalculadoraComissao.class);
		repositoryMock = Mockito.mock( VendaRepository.class);
		
	}
	
	@Test
	public void calcula_royalties_para_um_mes_sem_vendas() {
		double valor_royalties_esperado = 0;
		int mes = 01; 
		int ano = 2014;
		
		CalculadoraRoyalties calculadoraRoyalties = new CalculadoraRoyalties(calComissaoMock, repositoryMock);
		double valor_retornado = calculadoraRoyalties.calcula(mes, ano);
		
		assertEquals(valor_royalties_esperado, valor_retornado, 0);
	}
	
	@Test
	public void calcula_royalties_para_um_mes_com_uma_venda() {
		
		double valor_royalties_esperado = 19;
		
		int mes = 01; 
		int ano = 2014;
		
		List<Venda> vendas = Arrays.asList(new Venda(1, 1, mes, ano, 100));
		Mockito.when(repositoryMock.obterVendasPorMesEAno(ano, mes)).thenReturn(vendas);
		Mockito.when(calComissaoMock.calcula(100)).thenReturn(5.0);
		
		CalculadoraRoyalties calculadoraRoyalties = new CalculadoraRoyalties(calComissaoMock, repositoryMock);
		double valor_retornado = calculadoraRoyalties.calcula(mes, ano);
		
		assertEquals(valor_royalties_esperado, valor_retornado, 0);
	}
	
}
