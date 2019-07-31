package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultadoFalhaPage {
    private WebDriver navegador;
    public ResultadoFalhaPage (WebDriver navegador) {
        this.navegador = navegador;

    }

    public String ResultFalhaPage(){

        return navegador.findElement(By.xpath("//div[@class='col-md-9']/p")).getText();


    }
}