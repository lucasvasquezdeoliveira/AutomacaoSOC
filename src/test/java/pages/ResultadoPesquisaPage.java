package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultadoPesquisaPage {
    private WebDriver navegador;
    public ResultadoPesquisaPage (WebDriver navegador) {
        this.navegador = navegador;

    }

    public String ResultPesquisa(){

        return navegador.findElement(By.xpath("//h2[@class='pagetitle search']")).getText();


    }
}
