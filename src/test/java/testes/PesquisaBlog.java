package testes;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PesquisaBlog {
    @Test
    public void testPesquisaBlog(){
        //Abrindo o Navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Navegando até a Página da SOC
        navegador.get("https://ww2.soc.com.br/blog/");

        //Identificando o formulário de Pesquisa
        WebElement pesquisa = navegador.findElement(By.xpath("//input[@placeholder='Buscar']"));

        //Digitar no campo com name "s" que está dentro do formulário de id "blog" o texto "teste"
        pesquisa.sendKeys("teste");
        pesquisa.submit();

        //Validar que dentro do elemento com class "pagetitle search" está o texto "teste"
        WebElement res = navegador.findElement(By.xpath("//*[@id='blog']/div/div[1]/div/h2/span"));
        String textores = res.getText();
        assertEquals("TESTE",textores);

        // Fechar o Navegador
        navegador.close()


    }
}