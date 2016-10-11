package br.com.ufrn.bti.desktop.netflixparaguaio.view;

import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Usuario;
import br.com.ufrn.bti.desktop.netflixparaguaio.service.UsuarioService;

public class GenericController {
	private Usuario usuarioLogado;
	private UsuarioService usuarioService;
	
	public Usuario getUsuarioLogado(String login) {
		if(usuarioService.buscarPeloLogin(login) != null){
			usuarioLogado = usuarioService.buscarPeloLogin(login);
		}
		return usuarioLogado;
	}
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	
}
