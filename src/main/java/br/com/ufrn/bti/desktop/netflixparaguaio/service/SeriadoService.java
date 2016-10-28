package br.com.ufrn.bti.desktop.netflixparaguaio.service;

import java.util.ArrayList;
import java.util.List;

import br.com.ufrn.bti.desktop.netflixparaguaio.dao.ConteudoDAO;
import br.com.ufrn.bti.desktop.netflixparaguaio.dao.SeriadoDAO;
import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Seriado;

public class SeriadoService extends GenericService {
	private SeriadoDAO seriadoDao;
	private ConteudoService conteudoService;
	
	public SeriadoService(){
		seriadoDao = new SeriadoDAO();
		conteudoService = new ConteudoService();
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
	
	public Seriado buscarPeloIdConteudo(int id){
		Seriado seriadoAux = new Seriado();
		if(id > 0){
			seriadoAux = seriadoDao.buscarPeloIdConteudo(id);
		}
		if(seriadoAux != null){
			return seriadoAux;
		}
		return seriadoAux;
	}

	public void salvarOuAtualizar(Seriado seriado){
		if(seriado != null){
			conteudoService.salvarOuAtualizar(seriado.getConteudo());
			seriadoDao.salvarOuAtualizar(seriado);
		}
	}
}
