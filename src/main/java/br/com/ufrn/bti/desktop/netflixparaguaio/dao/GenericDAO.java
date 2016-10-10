package br.com.ufrn.bti.desktop.netflixparaguaio.dao;

import org.hibernate.Session;

import br.com.ufrn.bti.desktop.netflixparaguaio.util.HibernateUtil;

public class GenericDAO {

	private static Session session;

	/**
	 * Método para remover um objeto.
	 * 
	 * @param obj
	 */
	// public void remover(Object obj) {
	// Session session = getSession();
	// session.clear();
	// session.delete(obj);
	// session.flush();
	// }

	/**
	 * Método para salvar ou atualizar um objeto.
	 * 
	 * @param obj
	 */

	// public void salvarOuAtualizar(Object obj) {
	// Session session = getSession();
	// session.clear();
	// session.saveOrUpdate(obj);
	// session.flush();
	// session.clear();
	// }
	//
	// public void atualizar(Object obj) {
	// Session session = getSession();
	// session.clear();
	// session.merge(obj);
	// session.flush();
	// session.clear();
	// }

	/**
	 * Método para retornar a sessão do hibernate.
	 * 
	 * @return //
	 */
	// public Session getSession() {
	// if(session == null) {
	// HibernateUtil.getSessionFactory();
	// session = HibernateUtil.getSession();
	// }
	// return session;
	// }

	public void salvar(Object obj) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.save(obj);

		session.getTransaction().commit();

	}

}
