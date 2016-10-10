package br.com.ufrn.bti.desktop.netflixparaguaio.view;

import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Usuario;
import br.com.ufrn.bti.desktop.netflixparaguaio.main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastroUsuarioController {

	@FXML
	private TextField nomeField;
	@FXML
	private TextField cpfField;
	@FXML
	private TextField nascimentoField;
	@FXML
	private TextField sexoField;
	@FXML
	private TextField loginField;
	@FXML
	private TextField senhaField;
	@FXML
	private TextField permissaoField;

	private Stage dialogStage;
	private boolean entrarClicked = false;
	private Main main;
	private Usuario usuario;

	@FXML
	private void initialize() {
	}

	public TextField getNomeField() {
		return nomeField;
	}

	public void setNomeField(TextField nomeField) {
		this.nomeField = nomeField;
	}

	public TextField getCpfField() {
		return cpfField;
	}

	public void setCpfField(TextField cpfField) {
		this.cpfField = cpfField;
	}

	public TextField getNascimentoField() {
		return nascimentoField;
	}

	public void setNascimentoField(TextField nascimentoField) {
		this.nascimentoField = nascimentoField;
	}

	public TextField getSexoField() {
		return sexoField;
	}

	public void setSexoField(TextField sexoField) {
		this.sexoField = sexoField;
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

	public Stage getDialogStage() {
		return dialogStage;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public boolean isEntrarClicked() {
		return entrarClicked;
	}

	public void setEntrarClicked(boolean entrarClicked) {
		this.entrarClicked = entrarClicked;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TextField getPermissaoField() {
		return permissaoField;
	}

	public void setPermissaoField(TextField permissaoField) {
		this.permissaoField = permissaoField;
	}

	@FXML
	public void handleCadastrar(){
		
	}
}
