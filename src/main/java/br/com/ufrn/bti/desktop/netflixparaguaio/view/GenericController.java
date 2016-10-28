package br.com.ufrn.bti.desktop.netflixparaguaio.view;

import java.io.File;

import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Usuario;
import br.com.ufrn.bti.desktop.netflixparaguaio.service.UsuarioService;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class GenericController {
	private Usuario usuarioLogado;
	private UsuarioService usuarioService;
	
	
	public Usuario buscarUsuarioLogado(String login) {
		if(usuarioService.buscarPeloLogin(login) != null){
			usuarioLogado = usuarioService.buscarPeloLogin(login);
		}
		return usuarioLogado;
	}
	
	public Usuario getUsuarioLogado() {
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
	
	@FXML
	public File escolheArquivo(Stage stage){
		FileChooser fileChooser = new FileChooser();
		File arquivo = fileChooser.showOpenDialog(stage);
		if(arquivo != null){
			return arquivo;
		}
		return null;
	}
}
