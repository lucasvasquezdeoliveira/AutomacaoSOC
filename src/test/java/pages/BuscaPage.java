package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuscaPage {

    private WebDriver navegador;

    public BuscaPage(WebDriver navegador){
        this.navegador = navegador;
    }


    public ResultadoPesquisaPage clickBusca(String pesquisa){
       navegador.findElement(By.xpath("//input[@placeholder='Buscar']")).click();
       navegador.findElement(By.xpath("//input[@placeholder='Buscar']")).sendKeys(pesquisa);
       navegador.findElement(By.xpath("//input[@placeholder='Buscar']")).submit();


        return new ResultadoPesquisaPage(navegador);
    }


}
