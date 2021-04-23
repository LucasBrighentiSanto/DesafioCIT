import org.junit.rules.TestName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.SearchPage;
import pages.HomePage;
import pages.ResultSearchPage;

public class Steps {
	
	WebDriver driver;
	
	public TestName sign = new TestName();
	                                   
	@Dado("que navego para a página de busca do banco de questões")
	public void que_navego_para_a_página_de_busca_do_banco_de_questões() {
		driver = Browser.createMozila();
		new HomePage(driver).click();
	}

	@E("digito {string} no campo de busca")
	public void digito_no_campo_de_busca(String string) {
		new SearchPage(driver).typeSearch(string);
	}

	@Quando("clico no botão de buscar")
	public void clico_no_botão_de_buscar() {   
		new SearchPage(driver).clickSearch();
	}

	@Então("visualizo uma mensagem de erro com o texto {string}")
	public void visualizo_uma_mensagem_de_erro_com_o_texto(String string) {
		String ErrorMessage = new ResultSearchPage(driver).getMessage(string);
		assertEquals(string, ErrorMessage);
		
		Screen.screenshot(driver, "C:\\Users\\lucas\\eclipse-workspace\\DesafioCIT\\target\\test-classes\\Screenshots\\" + Generator.dataHora() + "MensagemDeErro.png");
	}

	@E("seleciono a opção {string}")
	public void seleciono_a_opção(String string) {
		new SearchPage(driver).chooseOption(string);
	}
	
	@Então("verifico se a listagem de questões está com {int} itens")
	public void verifico_se_a_listagem_de_questões_está_com_itens (Integer int1) {
		List<WebElement> row_total = new ResultSearchPage(driver).verifyRows();  
		Integer row_count = row_total.size();
		assertEquals(int1, row_count);
	}
	
	@E("se o controle de paginação irá aparecer")
	public void se_o_controle_de_paginação_irá_aparecer() {
		Boolean pagination = new ResultSearchPage(driver).isPag();
		assertEquals(true, pagination);
		
		Screen.screenshot(driver, "C:\\Users\\lucas\\eclipse-workspace\\DesafioCIT\\target\\test-classes\\Screenshots\\" + Generator.dataHora() + "TopoPaginação.png");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		Screen.screenshot(driver, "C:\\Users\\lucas\\eclipse-workspace\\DesafioCIT\\target\\test-classes\\Screenshots\\" + Generator.dataHora() + "FimPaginação.png");
	}
	
	@Então("verifico que há {int} questão na dificuldade {string}")
	public void verifico_que_há_questão_na_dificuldade (Integer int2, String string2) {
		List<WebElement> text_total = new ResultSearchPage(driver).verifyItems(string2);
		Integer text_count = text_total.size();
		assertEquals(int2, text_count);
	}
	
	@E("faço a ordenação pelo ID")
	public void faço_a_ordenação_pelo_ID() {   
		new ResultSearchPage(driver).orderByID();
		Screen.screenshot(driver, "C:\\Users\\lucas\\eclipse-workspace\\DesafioCIT\\target\\test-classes\\Screenshots\\" + Generator.dataHora() + "OrdenaçãoPorID.png");
	}
}
