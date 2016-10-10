package br.com.ufrn.bti.desktop.netflixparaguaio.service;

import java.util.ArrayList;
import java.util.List;

import br.com.ufrn.bti.desktop.netflixparaguaio.dao.UsuarioDAO;
import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Usuario;

public class UsuarioService extends GenericService {
	private UsuarioDAO usuarioDao;
	
	public UsuarioService(){
		
	}
	
	public List<Usuario> listar(){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		if(usuarioDao.listar().size() > 0){
			usuarios = usuarioDao.listar();
		}
		return usuarios;
	}
	
	public void desativar(Usuario usuario){
		if(usuario != null){
			usuario.setAtivo(false);
			usuarioDao.salvarOuAtualizar(usuario);
		}
	}
	
	public Usuario buscarPeloId(int id){
		Usuario usuarioAux = new Usuario();
		if(id > 0){
			usuarioAux = usuarioDao.buscarPeloId(id);
		}
		if(usuarioAux != null){
			return usuarioAux;
		}
		return usuarioAux;
	}
}
