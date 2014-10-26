using MbUnit.Framework;
using System;
using OpenQA.Selenium;
using System.Text;
using OpenQA.Selenium.Chrome;

namespace TestProject1
{
    
    
    public abstract class TesteBase 
    {
        public IWebDriver driver;

        [SetUp]
        public virtual void TestInitialize()
        {
            OperacoesDeTestes.CarregarBancoDeDados(ConfiguracaoDeTestes.Esquema, ConfiguracaoDeTestes.DadosDeTeste);
            driver = new ChromeDriver();


        }

        [TearDown]
        public void TeardownTest()
        {
            try
            {
                driver.Quit();
            }
            catch (Exception)
            {
                // Ignore errors if unable to close the browser
            }

        }

       
        
    }
    

}