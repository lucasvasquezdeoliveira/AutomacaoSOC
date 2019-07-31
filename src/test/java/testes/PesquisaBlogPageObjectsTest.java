package testes;

import Suporte.Web;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.BuscaPage;

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

    @After
    public void tearDown() {
            navegador.close();
        }
}