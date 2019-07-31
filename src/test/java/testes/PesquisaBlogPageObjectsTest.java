package testes;

import Suporte.Web;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.BuscaFalhaPage;
import pages.BuscaPage;
import pages.LimparPage;

import static org.junit.Assert.assertEquals;

public class PesquisaBlogPageObjectsTest {
    private WebDriver navegador;

    @Before
    public void setUp() {
        navegador = Web.createChrome();
    }

    @Test
    public void testPesquisaBlog () {
        String resultpesquisa = new BuscaPage(navegador)
                .clickBusca("teste")
                .ResultPesquisa();

        assertEquals("RESULTADO DA SUA BUSCA NO BLOG: TESTE", resultpesquisa);
    }
    @Test

    public void testPesquisaBlogfalha () {
        String resultpesquisa = new BuscaFalhaPage(navegador)
                .clickBusca("adujsdhgjhas")
                .ResultFalhaPage();

        assertEquals("Nenhum post encontrado. Tente uma busca diferente", resultpesquisa);
    }
    @Test

    public void testPesquisaBloglimpar () {
        String resultpesquisa = new LimparPage(navegador)
                .clickLimpar("Lucas")
                .ResultPesquisa();

        assertEquals("", resultpesquisa);
    }


    @After
    public void tearDown() {
            navegador.close();
        }
}