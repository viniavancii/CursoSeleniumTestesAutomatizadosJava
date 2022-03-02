package br.com.alura.leilao;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorldSelenium {
	
	@Test
	public void hello() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //localiza o driver no projeto
		WebDriver browser = new ChromeDriver(); // instanciando o driver
		browser.navigate().to("http://localhost:8080/leiloes"); //irá até o endereço
		browser.quit(); //fecha a janela que abriu
	}
}
