package br.com.alura.leilao.login;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.leiloes.LeiloesPage;

public class LoginPage extends PageObject{
	private static final String URL_LOGIN = "http://localhost:8080/login";
	
	public LoginPage() {
		super(null);
		this.browser.navigate().to(URL_LOGIN); //irá até essa página
	}

	public void preencheFormulario(String username, String password) {
		browser.findElement(By.id("username")).sendKeys(username); //insere texto no campo
		browser.findElement(By.id("password")).sendKeys(password);		
	}

	public LeiloesPage efetuaLogin() {
		browser.findElement(By.id("login-form")).submit(); //serve para submeter um form
		return new LeiloesPage(browser);
	}

	public boolean isPaginaDeLogin() {
		return browser.getCurrentUrl().equals(URL_LOGIN);
	}

	public Object getNomeUserLogado() {
		try {
			return browser.findElement(By.id("usuario-logado")).getText(); //traz o texto do elemento usuario-logado
		} catch (NoSuchElementException e) {
			return null; //retorna nulo quando há a exception
		}
	}

	public void navegaParaPaginaDeLances(String string, String string2) {
		this.browser.navigate().to("http://localhost:8080/login/leiloes/2"); //irá até essa página
		
	}

	public boolean contemTexto(String texto) {
		return browser.getPageSource().contains(texto);
	}

	public boolean isPaginaDeLoginComDadosInvalidos() {
		return browser.getCurrentUrl().equals(URL_LOGIN + "?error");
	}		
}
