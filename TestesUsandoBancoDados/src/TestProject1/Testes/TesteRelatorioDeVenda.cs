using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using MbUnit.Framework;
using SistemaVendas.Negocio;
using NHibernate;

namespace TestProject1.Testes
{
    [TestFixture]
    public class TesteRelatorioDeVenda : TesteBase
    {
        private ISession _session;
        private RelatorioVendas _relatorioVendas;

        [SetUp]
        public void Initialize()
        {
            //colocar codigo comum a varios testes dentro deste metodo. Ele é rodado antes dos testes.
            _session = Contexto.SessionFactory.OpenSession();
            _relatorioVendas = new RelatorioVendas(_session);
        }

        [Test]
        public void teste_consulta_vendedor_inexistente()
        {
            decimal valorEsperado = 0;
            int idVendedor = 0;
            int ano = 2011;

            decimal valorAnual = _relatorioVendas.ObterVendaAnualVendedor(idVendedor, ano);
            
            Assert.AreEqual(valorEsperado, valorAnual);
        }
        [Test]
        public void teste_consulta_vendedor_com_uma_venda()
        {
            decimal valorEsperado = 1000;
            int idVendedor = 1;
            int ano = 2011;

            decimal valorAnual = _relatorioVendas.ObterVendaAnualVendedor(idVendedor, ano);

            Assert.AreEqual(valorEsperado, valorAnual);
        }
        [Test]
        public void teste_consulta_vendedor_duas_ou_mais_vendas_ano()
        {
            decimal valorEsperado = 1500;
            int idVendedor = 2;
            int ano = 2012;

            decimal valorAnual = _relatorioVendas.ObterVendaAnualVendedor(idVendedor, ano);

            Assert.AreEqual(valorEsperado, valorAnual);
        }
        [Test]
        public void teste_consulta_vendedor_vendas_em_mais_de_1_ano()
        {
            decimal valorEsperado = 101;
            int idVendedor = 3;
            int ano = 2013;

            decimal valorAnual = _relatorioVendas.ObterVendaAnualVendedor(idVendedor, ano);

            Assert.AreEqual(valorEsperado, valorAnual);
        }
        [Test]
        public void teste_consulta_vendedor_com_venda_compartilhada()
        {
            decimal valorEsperado = 200;
            int idVendedor = 4;
            int ano = 2004;

            decimal valorAnual = _relatorioVendas.ObterVendaAnualVendedor(idVendedor, ano);

            Assert.AreEqual(valorEsperado, valorAnual);
        }
    }
}
