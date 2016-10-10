package br.com.ufrn.bti.desktop.netflixparaguaio.dao;

import org.hibernate.Session;

import br.com.ufrn.bti.desktop.netflixparaguaio.util.HibernateUtil;

public class GenericDAO {

	public static Session session;

	public void salvarOuAtualizar(Object obj) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(obj);
		session.getTransaction().commit();
		session.close();
	}
	
	public void deletar(Object obj){
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.remove(obj);
		session.getTransaction().commit();
		session.close();
	}

}
