package br.com.ufrn.bti.desktop.netflixparaguaio.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Filme;
import br.com.ufrn.bti.desktop.netflixparaguaio.util.HibernateUtil;

@SuppressWarnings("deprecation")
public class FilmeDAO extends GenericDAO {
	
	public FilmeDAO(){
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Filme> listar(){
		List<Filme> listaFilmes = new ArrayList<Filme>();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
		listaFilmes = session.createQuery("SELECT f FROM Filme f").getResultList();
		session.clear();
		session.close();
		return listaFilmes;
	}

	@SuppressWarnings({ "deprecation, rawtypes" })
	public Filme buscarPeloId(int id) {
		Filme filme = new Filme();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
		Query q = session.createQuery("SELECT f FROM Filme f WHERE f.id = :id");
        q.setInteger("id", id);
		filme = (Filme) q.getSingleResult(); 
		session.clear();
		session.close();
		return filme;
	}

	@SuppressWarnings({ "deprecation, rawtypes" })
	public Filme buscarPeloIdConteudo(int id) {
		Filme filme = new Filme();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
		Query q = session.createQuery("SELECT f FROM Filme f WHERE f.conteudo.id = :id");
        q.setInteger("id", id);
		filme = (Filme) q.getSingleResult(); 
		session.clear();
		session.close();
		return filme;
	}
}
