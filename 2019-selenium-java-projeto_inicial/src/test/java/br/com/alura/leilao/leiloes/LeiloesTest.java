package br.com.alura.leilao.leiloes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.login.LoginPage;

public class LeiloesTest {
	
	private LeiloesPage paginaDeLeiloes;
	private CadastroLeilaoPage paginaDeCadastro;
		
	@BeforeEach
	public void BeforeEach() {
		LoginPage paginaDeLogin = new LoginPage();
		paginaDeLogin.preencheFormulario("fulano", "pass");
		this.paginaDeLeiloes = paginaDeLogin.efetuaLogin();
		this.paginaDeCadastro = paginaDeLeiloes.carregarForm();
	}
	
	@AfterEach
	public void AfterEach() {
		this.paginaDeLeiloes.fechar();
	}

	@Test
	public void DeveriaCadastrarLeilao() {
		String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")); //irá formatar a data
		String nome = "Leilao do dia " +hoje;
		String valor = "500.00";
		
		this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao(nome, hoje, valor);
		Assert.assertTrue(paginaDeLeiloes.isLeilaoCadastrado(nome, hoje, valor));
	}
	
	@Test
	public void DeveriaValidarCadastroDeLeilao() {
		this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao("", "", "");
		Assert.assertTrue(this.paginaDeLeiloes.isPaginAtual());
		Assert.assertTrue(this.paginaDeCadastro.MensagensValidacoesVisiveis());
	}
}
	

