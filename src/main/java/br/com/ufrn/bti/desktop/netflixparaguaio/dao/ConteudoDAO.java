package br.com.ufrn.bti.desktop.netflixparaguaio.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Conteudo;
import br.com.ufrn.bti.desktop.netflixparaguaio.util.HibernateUtil;

public class ConteudoDAO extends GenericDAO {
	@SuppressWarnings("unchecked")
	public List<Conteudo> listar(){
		List<Conteudo> listaConteudos = new ArrayList<Conteudo>();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
		listaConteudos = session.createQuery("SELECT f FROM Conteudo f").getResultList();
		return listaConteudos;
	}

	@SuppressWarnings({ "deprecation, rawtypes" })
	public Conteudo buscarPeloId(int id) {
		Conteudo conteudo = new Conteudo();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
		Query q = session.createQuery("SELECT f FROM Conteudo f WHERE f.id = :id");
        q.setInteger("id", id);
		conteudo = (Conteudo) q.getSingleResult(); 
		return conteudo;
	}
}
