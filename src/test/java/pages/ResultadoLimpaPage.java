package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultadoLimpaPage {
    private WebDriver navegador;
    public ResultadoLimpaPage (WebDriver navegador) {
        this.navegador = navegador;

    }

    public String ResultPesquisa(){

        return navegador.findElement(By.xpath("//a[@class='limpar-busca']")).getText();

    }
}
