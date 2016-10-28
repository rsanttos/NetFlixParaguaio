package br.com.ufrn.bti.desktop.netflixparaguaio.service;

import java.util.ArrayList;
import java.util.List;

import br.com.ufrn.bti.desktop.netflixparaguaio.dao.ConteudoDAO;
import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Conteudo;

public class ConteudoService extends GenericService {
	
	private ConteudoDAO conteudoDao;
	
	public ConteudoService(){
		conteudoDao = new ConteudoDAO();
	}
	
	public List<Conteudo> listar(){
		List<Conteudo> conteudos = new ArrayList<Conteudo>();
		if(conteudoDao.listar().size() > 0){
			conteudos = conteudoDao.listar();
		}
		return conteudos;
	}
	
	
	public List<Conteudo> buscarPorNomeEAtor(String nome, String atorPrincipal){
		List<Conteudo> conteudos = new ArrayList<Conteudo>();
		conteudos = conteudoDao.buscarPorNomeEAtor(nome, atorPrincipal);
		if(conteudos.size() > 0){
			return conteudos;
		}
		return conteudos;
	}
	
	public Conteudo buscarPeloId(int id){
		Conteudo conteudoAux = new Conteudo();
		if(id > 0){
			conteudoAux = conteudoDao.buscarPeloId(id);
		}
		if(conteudoAux != null){
			return conteudoAux;
		}
		return conteudoAux;
	}

	public void salvarOuAtualizar(Conteudo conteudo){
		if(conteudo != null){
			conteudoDao.salvarOuAtualizar(conteudo);
		}
	}
	
	
}
