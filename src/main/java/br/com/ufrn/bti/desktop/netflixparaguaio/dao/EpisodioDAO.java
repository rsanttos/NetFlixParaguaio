package br.com.ufrn.bti.desktop.netflixparaguaio.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Episodio;
import br.com.ufrn.bti.desktop.netflixparaguaio.util.HibernateUtil;

public class EpisodioDAO extends GenericDAO {
	@SuppressWarnings("unchecked")
	public List<Episodio> listar(){
		List<Episodio> listaEpisodios = new ArrayList<Episodio>();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
		listaEpisodios = session.createQuery("SELECT f FROM Episodio f").getResultList();
		return listaEpisodios;
	}

	@SuppressWarnings({ "deprecation, rawtypes" })
	public Episodio buscarPeloId(int id) {
		Episodio episodio = new Episodio();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
		Query q = session.createQuery("SELECT f FROM Episodio f WHERE f.id = :id");
        q.setInteger("id", id);
		episodio = (Episodio) q.getSingleResult(); 
		return episodio;
	}
}
