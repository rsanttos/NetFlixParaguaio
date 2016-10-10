package br.com.ufrn.bti.desktop.netflixparaguaio.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Usuario;
import br.com.ufrn.bti.desktop.netflixparaguaio.util.HibernateUtil;

public class UsuarioDAO extends GenericDAO {
	@SuppressWarnings("unchecked")
	public List<Usuario> listar(){
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
		listaUsuarios = session.createQuery("SELECT f FROM Usuario f").getResultList();
		return listaUsuarios;
	}

	@SuppressWarnings({ "deprecation, rawtypes" })
	public Usuario buscarPeloId(int id) {
		Usuario filme = new Usuario();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
		Query q = session.createQuery("SELECT f FROM Usuario f WHERE f.id = :id");
        q.setInteger("id", id);
		filme = (Usuario) q.getSingleResult(); 
		return filme;
	}
}
