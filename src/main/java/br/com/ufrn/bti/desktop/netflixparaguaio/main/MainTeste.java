package br.com.ufrn.bti.desktop.netflixparaguaio.main;

import br.com.ufrn.bti.desktop.netflixparaguaio.dao.FilmeDAO;
import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Filme;

public class MainTeste {

	public static void main(String[] args) {
		Filme f = new Filme();
		FilmeDAO fDao = new FilmeDAO();
		
		f.setCaminhoArquivo("teste");
		f.setDuracao("2999");
		
		fDao.salvarOuAtualizar(f);
	}

}
