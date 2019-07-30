package testes;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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
       //Abrindo o Navegador
       System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
       navegador = new ChromeDriver();
       navegador.manage().window().maximize();
       navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

       //Navegando até a Página da SOC
       navegador.get("https://ww2.soc.com.br/blog/");
   }

    @Test
    public void testPesquisaBlog(){


        //Identificando o formulário de Pesquisa
        WebElement pesquisa = navegador.findElement(By.xpath("//input[@placeholder='Buscar']"));

        //Digitar no campo o texto "teste"
        pesquisa.sendKeys("teste");
        pesquisa.submit();

        //Validar que dentro do elemento com class "pagetitle search" está o texto "RESULTADO DA SUA BUSCA NO BLOG: TESTE"
        WebElement res = navegador.findElement(By.xpath("//h2[@class='pagetitle search']"));
        String textores = res.getText();
        assertEquals("RESULTADO DA SUA BUSCA NO BLOG: TESTE",textores);
   }

    @Test
    public void testPesquisaBlogfalha(){


        //Identificando o formulário de Pesquisa
        WebElement pesquisa = navegador.findElement(By.xpath("//input[@placeholder='Buscar']"));

        //Digitar o texto da pesquisa falha "sasfsfdgf"
        pesquisa.sendKeys("sasfsfdgf");
        pesquisa.submit();

        //Validar que dentro do elemento está o texto "Nenhum post encontrado. Tente uma busca diferente"
        WebElement res = navegador.findElement(By.xpath("//div[@class='col-md-9']/p"));
        String textoresult = res.getText();
        assertEquals("Nenhum post encontrado. Tente uma busca diferente",textoresult);
    }
    @Test
    public void testPesquisaBlogLimpar(){


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
        assertEquals("",textolimpa);
    }

    @After
    public void tearDown() {
        // Fechar o Navegador
        navegador.close();
    }
}