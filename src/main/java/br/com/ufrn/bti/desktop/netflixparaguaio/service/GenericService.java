package br.com.ufrn.bti.desktop.netflixparaguaio.service;

import br.com.ufrn.bti.desktop.netflixparaguaio.dao.GenericDAO;

public class GenericService {
	private GenericDAO genericDao;
	
	public GenericService(){
		genericDao = new GenericDAO();
	}
	
	public void salvarOuAtualizar(Object obj){
		if(obj != null){
			genericDao.salvarOuAtualizar(obj);
		}
	}
	
	public void deletar(Object obj){
		if(obj != null){
			genericDao.deletar(obj);
		}
	}
}
