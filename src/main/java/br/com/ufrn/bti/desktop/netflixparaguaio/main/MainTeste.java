package br.com.ufrn.bti.desktop.netflixparaguaio.main;

import br.com.ufrn.bti.desktop.netflixparaguaio.dao.FilmeDAO;
import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Filme;

public class MainTeste {

	public static void main(String[] args) {
		Filme f = new Filme();
		FilmeDAO fDao = new FilmeDAO();
		
		f = fDao.buscarPeloId(1);
		
		System.out.println(f.getId());
		System.out.println(f.getDuracao());
	}

}
