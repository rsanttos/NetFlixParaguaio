//package br.com.ufrn.bti.desktop.netflixparaguaio.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import br.com.ufrn.bti.desktop.netflixparaguaio.dao.TemporadaDAO;
//import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Temporada;
//
//public class TemporadaService extends GenericService {
//	
//	private TemporadaDAO temporadaDao;
//	private SeriadoService seriadoService;
//	
//	public TemporadaService(){
//		temporadaDao = new TemporadaDAO();
//		seriadoService = new SeriadoService();
//	}
//	
//	public List<Temporada> listar(){
//		List<Temporada> temporadas = new ArrayList<Temporada>();
//		if(temporadaDao.listar().size() > 0){
//			temporadas = temporadaDao.listar();
//		}
//		return temporadas;
//	}
//	
//	public Temporada buscarPeloId(int id){
//		Temporada temporadaAux = new Temporada();
//		if(id > 0){
//			temporadaAux = temporadaDao.buscarPeloId(id);
//		}
//		if(temporadaAux != null){
//			return temporadaAux;
//		}
//		return temporadaAux;
//	}
//
//	public void salvarOuAtualizar(Temporada temporada){
//		if(temporada != null){
//			//seriadoService.salvarOuAtualizar(temporada.getSeriado());
//			temporadaDao.salvarOuAtualizar(temporada);
//		}
//	}
//}
