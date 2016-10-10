package br.com.ufrn.bti.desktop.netflixparaguaio.main;

import br.com.ufrn.bti.desktop.netflixparaguaio.dao.ConteudoDAO;
import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Conteudo;
import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Filme;
import br.com.ufrn.bti.desktop.netflixparaguaio.service.FilmeService;

public class MainTeste {

	public static void main(String[] args) {
		Conteudo c = new Conteudo();
		c.setAnoLancamento(2006);
		c.setAtorPrincipal("Ramon");
		c.setClassificacaoEtaria(10);
		c.setNome("Teste");
		c.setTipo("Filme");
		ConteudoDAO cDao = new ConteudoDAO();
		//cDao.salvarOuAtualizar(c);
		
		Filme f = new Filme();
		FilmeService fService = new FilmeService();
		f.setConteudo(c);
		f.setCaminhoArquivo("teste");
		f.setDuracao("2999");
		
		fService.salvarOuAtualizar(f);
	}

}
