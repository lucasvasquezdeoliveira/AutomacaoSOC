package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BuscaFalhaPage {

    private WebDriver navegador;

    public BuscaFalhaPage(WebDriver navegador){
        this.navegador = navegador;
    }


    public ResultadoFalhaPage clickBusca(String pesquisa){
        navegador.findElement(By.xpath("//input[@placeholder='Buscar']")).click();
        navegador.findElement(By.xpath("//input[@placeholder='Buscar']")).sendKeys(pesquisa);
        navegador.findElement(By.xpath("//input[@placeholder='Buscar']")).submit();


        return new ResultadoFalhaPage(navegador);
    }


}
