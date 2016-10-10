package br.com.ufrn.bti.desktop.netflixparaguaio.service;

import java.util.ArrayList;
import java.util.List;

import br.com.ufrn.bti.desktop.netflixparaguaio.dao.EpisodioDAO;
import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Episodio;

public class EpisodioService extends GenericService {
	private EpisodioDAO episodioDao;
	
	public EpisodioService(){
		episodioDao = new EpisodioDAO();
	}
	
	public List<Episodio> listar(){
		List<Episodio> episodios = new ArrayList<Episodio>();
		if(episodioDao.listar().size() > 0){
			episodios = episodioDao.listar();
		}
		return episodios;
	}
	
	public Episodio buscarPeloId(int id){
		Episodio episodioAux = new Episodio();
		if(id > 0){
			episodioAux = episodioDao.buscarPeloId(id);
		}
		if(episodioAux != null){
			return episodioAux;
		}
		return episodioAux;
	}
}
