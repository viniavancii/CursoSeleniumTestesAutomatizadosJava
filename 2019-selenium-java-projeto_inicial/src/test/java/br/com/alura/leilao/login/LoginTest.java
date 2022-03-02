package br.com.alura.leilao.login;

import static org.junit.Assert.assertFalse;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	
	private LoginPage paginaDeLogin;

	@BeforeEach
	public void BeforeAll() {
		this.paginaDeLogin = new LoginPage();
	}
		
	@AfterEach
	public void AfterEach() {
		this.paginaDeLogin.fechar();
	}


	@Test
	public void DeveriaEfetuarLoginComDadosValidos () {
		paginaDeLogin.preencheFormulario("fulano", "pass");
		paginaDeLogin.efetuaLogin();

		Assert.assertFalse(paginaDeLogin.isPaginaDeLogin()); //verifica se não está mais na pagina de login
		Assert.assertEquals("fulano", paginaDeLogin.getNomeUserLogado()); //verifica um elemento pelo seu texto	
	}
	
	@Test
	public void NaoDeveriLogarComDadosInvalidos (){
		paginaDeLogin.preencheFormulario("invalido", "123");
		paginaDeLogin.efetuaLogin();
		
		Assert.assertTrue(paginaDeLogin.isPaginaDeLoginComDadosInvalidos()); //verifica se não está mais na pagina de login
		Assert.assertNull(paginaDeLogin.getNomeUserLogado()); //verifica um elemento pelo seu texto	
		Assert.assertTrue(paginaDeLogin.contemTexto("Usuário e senha inválidos."));
	}
	
	@Test
	public void NaoDeveriAcessarPaginaRestritaSemEstarAutenticado() {
		paginaDeLogin.navegaParaPaginaDeLances("invalido", "123");
		Assert.assertTrue(paginaDeLogin.isPaginaDeLogin()); //verifica se não está mais na pagina de login
		Assert.assertFalse(paginaDeLogin.contemTexto("Dados do Leilão")); //verifica se na pagina atual não tem esse elemento
	}
}
