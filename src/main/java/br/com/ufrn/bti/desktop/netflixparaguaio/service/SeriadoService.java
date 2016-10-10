package br.com.ufrn.bti.desktop.netflixparaguaio.service;

import java.util.ArrayList;
import java.util.List;

import br.com.ufrn.bti.desktop.netflixparaguaio.dao.SeriadoDAO;
import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Seriado;

public class SeriadoService extends GenericService {
	private SeriadoDAO seriadoDao;
	
	public SeriadoService(){
		seriadoDao = new SeriadoDAO();
	}
	
	public List<Seriado> listar(){
		List<Seriado> seriados = new ArrayList<Seriado>();
		if(seriadoDao.listar().size() > 0){
			seriados = seriadoDao.listar();
		}
		return seriados;
	}
	
	public Seriado buscarPeloId(int id){
		Seriado seriadoAux = new Seriado();
		if(id > 0){
			seriadoAux = seriadoDao.buscarPeloId(id);
		}
		if(seriadoAux != null){
			return seriadoAux;
		}
		return seriadoAux;
	}
}
