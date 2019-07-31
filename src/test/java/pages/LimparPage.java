package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LimparPage {

private WebDriver navegador;

public LimparPage (WebDriver navegador){
        this.navegador = navegador;
        }


public ResultadoLimpaPage clickLimpar(String pesquisa){
        navegador.findElement(By.xpath("//input[@placeholder='Buscar']")).click();
        navegador.findElement(By.xpath("//input[@placeholder='Buscar']")).sendKeys(pesquisa);
        navegador.findElement(By.xpath("//a[@class='limpar-busca']")).click();

        return new ResultadoLimpaPage(navegador);
        }


        }