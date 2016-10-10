package br.com.ufrn.bti.desktop.netflixparaguaio.view;

import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Usuario;
import br.com.ufrn.bti.desktop.netflixparaguaio.main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	private TextField loginField;
	@FXML
	private TextField senhaField;

	private Stage dialogStage;
	private boolean entrarClicked = false;
	private Main main;

	private Usuario usuario;

	@FXML
	private void initialize() {
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public TextField getLoginField() {
		return loginField;
	}

	public void setLoginField(TextField loginField) {
		this.loginField = loginField;
	}

	public TextField getSenhaField() {
		return senhaField;
	}

	public void setSenhaField(TextField senhaField) {
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

	public Stage getDialogStage() {
		return dialogStage;
	}

	@FXML
	private void handleEntrar() {
		if(validaEntradas()){
			usuario.setLogin(loginField.getText());
			usuario.setSenha(senhaField.getText());
			System.out.println("aeho");
		}
	}

	private boolean validaEntradas() {
		if (loginField.getText() != null) {
			if (senhaField.getText() != null) {
				return true;
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Campos Inválidos");
				alert.setHeaderText("Ops..");
				alert.setContentText("Por favor, digite a senha.");
				alert.showAndWait();
				return false;
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Campos Inválidos");
			alert.setHeaderText("Ops..");
			alert.setContentText("Login e senha precisam ser informados.");
			alert.showAndWait();
			return false;
		}
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
}
