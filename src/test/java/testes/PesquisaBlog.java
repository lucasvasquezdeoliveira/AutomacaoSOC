package testes;

import static org.junit.Assert.*;

import Suporte.Web;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PesquisaBlog {
    private WebDriver navegador;

    @Before
    public void setUp() {
        navegador = Web.createChrome();

    }
    @Test
    public void testPesquisaBlogfalha () {


        //Identificando o formulário de Pesquisa
        WebElement pesquisa = navegador.findElement(By.xpath("//input[@placeholder='Buscar']"));

        //Digitar o texto da pesquisa falha "sasfsfdgf"
        pesquisa.sendKeys("sasfsfdgf");
        pesquisa.submit();

        //Validar que dentro do elemento está o texto "Nenhum post encontrado. Tente uma busca diferente"
        WebElement res = navegador.findElement(By.xpath("//div[@class='col-md-9']/p"));
        String textoresult = res.getText();
        assertEquals("Nenhum post encontrado. Tente uma busca diferente", textoresult);
    }
    @Test
    public void testPesquisaBlogLimpar () {


        //Identificando o formulário de Pesquisa
        WebElement pesquisa = navegador.findElement(By.xpath("//input[@placeholder='Buscar']"));

        //Digitar o texto da pesquisa  "Lucas"
        pesquisa.sendKeys("Lucas");

        //Encontrar Elemento Limpar
        WebElement limpar = navegador.findElement(By.xpath("//a[@class='limpar-busca']"));

        //Clicar em Limpar
        limpar.click();

        //Validar que dentro do elemento não está o texto "Lucas"
        String textolimpa = pesquisa.getText();
        assertEquals("", textolimpa);
    }

    @After
    public void tearDown () {
        // Fechar o Navegador
        navegador.close();
    }
}