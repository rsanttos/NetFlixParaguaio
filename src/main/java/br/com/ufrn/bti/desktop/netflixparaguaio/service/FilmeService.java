package br.com.ufrn.bti.desktop.netflixparaguaio.service;

import java.util.ArrayList;
import java.util.List;

import br.com.ufrn.bti.desktop.netflixparaguaio.dao.ConteudoDAO;
import br.com.ufrn.bti.desktop.netflixparaguaio.dao.FilmeDAO;
import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Filme;
import javafx.collections.ObservableList;

public class FilmeService extends GenericService {
	
	private ConteudoDAO conteudoDao;
	private FilmeDAO filmeDao;
	
	public FilmeService(){
		conteudoDao = new ConteudoDAO();
		filmeDao = new FilmeDAO();
	}
	
	public List<Filme> listar(){
		List<Filme> filmes = new ArrayList<Filme>();
		if(filmeDao.listar().size() > 0){
			filmes = filmeDao.listar();
		}
		return filmes;
	}
	
	public Filme buscarPeloId(int id){
		Filme filmeAux = new Filme();
		if(id > 0){
			filmeAux = filmeDao.buscarPeloId(id);
		}
		if(filmeAux != null){
			return filmeAux;
		}
		return filmeAux;
	}
	
	public Filme buscarPeloIdConteudo(int id){
		Filme filmeAux = new Filme();
		if(id > 0){
			filmeAux = filmeDao.buscarPeloIdConteudo(id);
		}
		if(filmeAux != null){
			return filmeAux;
		}
		return filmeAux;
	}
	
	public void salvarOuAtualizar(Filme filme){
		if(filme != null){
			conteudoDao.salvarOuAtualizar(filme.getConteudo());
			filmeDao.salvarOuAtualizar(filme);
		}
	}
	
	public ObservableList<Filme> listagemFilmes(){
		return (ObservableList<Filme>) filmeDao.listar();
	}
	
}
