package testes;

import Suporte.Web;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.BuscaFalhaPage;
import pages.BuscaPage;
import pages.LimparPage;

import static org.junit.Assert.assertEquals;


@Epic("Pesquisa")
@Feature("Pesquisa")
public class PesquisaBlogPageObjectsTest {
    private WebDriver navegador;

    @Before
    public void setUp() {
        navegador = Web.createChrome();
    }
    @Test
    @Story("Usuário tenta pesquisar teste")
    @Description("Pesquisa Válida")
    public void testPesquisaBlog () {
        String resultpesquisa = new BuscaPage(navegador)
                .clickBusca("teste")
                .ResultPesquisa();

        assertEquals("RESULTADO DA SUA BUSCA NO BLOG: TESTE", resultpesquisa);
    }
    @Test
    @Story("Usuário tenta pesquisar adujsdhgjhas")
    @Description("Pesquisa Inválida")
    public void testPesquisaBlogfalha () {
        String resultpesquisa = new BuscaFalhaPage(navegador)
                .clickBusca("adujsdhgjhas")
                .ResultFalhaPage();

        assertEquals("Nenhum post encontrado. Tente uma busca diferente", resultpesquisa);
    }
    @Test
    @Story("Usuário tenta Limpar pesquisar Lucas")
    @Description("Limpar Pesquisa")

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