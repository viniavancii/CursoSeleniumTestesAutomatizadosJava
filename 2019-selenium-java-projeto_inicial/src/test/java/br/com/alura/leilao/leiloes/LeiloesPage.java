package br.com.alura.leilao.leiloes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import br.com.alura.leilao.PageObject;

public class LeiloesPage extends PageObject{
	private static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";
	private static final String URL_LEILOES = "http://localhost:8080/leiloes";
	
	public LeiloesPage(WebDriver browser) {
		super(browser);
	}

	public CadastroLeilaoPage carregarForm() {
		this.browser.navigate().to(URL_CADASTRO_LEILAO);
		return new CadastroLeilaoPage(browser);
	}

	public boolean isLeilaoCadastrado(String nome, String hoje, String valor) {
		WebElement ultimalinhaDaTabela = this.browser.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
		WebElement colunaNome = ultimalinhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
		WebElement colunaData = ultimalinhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
		WebElement colunaValor = ultimalinhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));
		return colunaNome.getText().equals(nome) &&
				colunaData.getText().equals(hoje) &&
				colunaValor.getText().equals(valor);
	}

	public boolean isPaginAtual() {
		return browser.getCurrentUrl().contentEquals(URL_LEILOES);
	}	
	
	
}
