package br.com.ufrn.bti.desktop.netflixparaguaio.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Seriado;
import br.com.ufrn.bti.desktop.netflixparaguaio.util.HibernateUtil;

public class SeriadoDAO extends GenericDAO {
	@SuppressWarnings("unchecked")
	public List<Seriado> listar(){
		List<Seriado> listaSeriados = new ArrayList<Seriado>();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
		listaSeriados = session.createQuery("SELECT f FROM Seriado f").getResultList();
		session.clear();
		session.close();
		return listaSeriados;
	}

	@SuppressWarnings({ "deprecation, rawtypes" })
	public Seriado buscarPeloId(int id) {
		Seriado seriado = new Seriado();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
		Query q = session.createQuery("SELECT f FROM Seriado f WHERE f.id = :id");
        q.setInteger("id", id);
		seriado = (Seriado) q.getSingleResult(); 
		session.clear();
		session.close();
		return seriado;
	}

	@SuppressWarnings({ "deprecation, rawtypes" })
	public Seriado buscarPeloIdConteudo(int id) {
		Seriado seriado = new Seriado();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
		Query q = session.createQuery("SELECT f FROM Seriado f WHERE f.conteudo.id = :id");
        q.setInteger("id", id);
		seriado = (Seriado) q.getSingleResult(); 
		session.clear();
		session.close();
		return seriado;
	}
}
