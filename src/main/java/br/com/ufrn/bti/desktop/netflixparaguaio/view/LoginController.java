package br.com.ufrn.bti.desktop.netflixparaguaio.view;

import java.io.IOException;

import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Usuario;
import br.com.ufrn.bti.desktop.netflixparaguaio.main.Main;
import br.com.ufrn.bti.desktop.netflixparaguaio.service.UsuarioService;
import br.com.ufrn.bti.desktop.netflixparaguaio.util.Alerta;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController extends GenericController {

	@FXML
	private TextField loginField;
	@FXML
	private PasswordField senhaField;

	private Stage stage;
	private boolean entrarClicked = false;
	
	private Main main;

	private Usuario usuario;
	private UsuarioService usuarioService;

	public LoginController() {
		usuario = new Usuario();
		usuarioService = new UsuarioService();
	}

	@FXML
	private void initialize() {
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public TextField getLoginField() {
		return loginField;
	}

	public void setLoginField(TextField loginField) {
		this.loginField = loginField;
	}

	public PasswordField getSenhaField() {
		return senhaField;
	}

	public void setSenhaField(PasswordField senhaField) {
		this.senhaField = senhaField;
	}

	public boolean isEntrarClicked() {
		return entrarClicked;
	}

	public void setEntrarClicked(boolean entrarClicked) {
		this.entrarClicked = entrarClicked;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@FXML
	private void handleEntrar() {
		if (validaEntradas()) {
			Usuario usuario = new Usuario();
			String login = loginField.getText();
			usuario = usuarioService.buscarPeloLogin(login);
			if (usuario != null) {
				if (senhaField.getText().equals(usuario.getSenha())) {
					if (usuario.getPermissao().equals("ADMIN")) {
						this.stage.close();
						setUsuarioLogado(usuario);
						boolean entrarClicked = main.showListagemFilmesAdmin(usuario);
					} else if (usuario.getPermissao().equals("USER")) {
						this.stage.close();
						setUsuarioLogado(usuario);
						boolean entrarClicked = main.showListagemFilmesUser(usuario);
					}
				} else {
					Alerta.alertaErro("Vixe.", "Verifique se digitou a senha corretamente.");
				}
			} else {
				Alerta.alertaErro("Eita.", "Verifique se digitou um login cadastrado.");
			}
		}
	}

	private boolean validaEntradas() {
		if (!(loginField.getText().isEmpty())) {
			if (!(senhaField.getText().isEmpty())) {
				System.out.println(loginField.getText());
				System.out.println(senhaField.getText());
				return true;
			} else {
				Alerta.alertaErro("Ops..", "Por favor, digite a senha.");
				return false;
			}
		} else {
			Alerta.alertaErro("Ops..", "Login e senha precisam ser informados.");
			return false;
		}
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public void showCadastroUsuario() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/cadastroUsuario.fxml"));
			AnchorPane listageFilmesOverview = (AnchorPane) loader.load();

			//rootLayout.setCenter(listageFilmesOverview);

			// Dá ao controlador acesso à the main app.
			CadastroUsuarioController controller = loader.getController();
			controller.setMain(main);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
