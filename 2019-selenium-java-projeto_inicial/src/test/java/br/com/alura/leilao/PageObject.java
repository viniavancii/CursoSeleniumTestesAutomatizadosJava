package br.com.alura.leilao;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {
	protected WebDriver browser;
	
	public PageObject(WebDriver browser) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //localiza o driver no projeto
		
		if(browser == null) {
			this.browser = new ChromeDriver();
		}
		else {
			this.browser = browser; // instanciando o driver - abre o browser
		}
		
		this.browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS).pageLoadTimeout(10, TimeUnit.SECONDS); //aguardar no máximo 5 sec quando procurar um elemento na tela e 10 sec para a pagina carregar 
	}
	
	public void fechar() {
		this.browser.quit();
	}
}
