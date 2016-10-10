package br.com.ufrn.bti.desktop.netflixparaguaio.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Temporada;
import br.com.ufrn.bti.desktop.netflixparaguaio.util.HibernateUtil;

@SuppressWarnings("deprecation")
public class TemporadaDAO extends GenericDAO {
	
	public TemporadaDAO(){
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Temporada> listar(){
		List<Temporada> listaTemporadas = new ArrayList<Temporada>();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
		listaTemporadas = session.createQuery("SELECT f FROM Temporada f").getResultList();
		return listaTemporadas;
	}

	@SuppressWarnings({ "deprecation, rawtypes" })
	public Temporada buscarPeloId(int id) {
		Temporada temporada = new Temporada();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
		Query q = session.createQuery("SELECT f FROM Temporada f WHERE f.id = :id");
        q.setInteger("id", id);
		temporada = (Temporada) q.getSingleResult(); 
		return temporada;
	}
}
