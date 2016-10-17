package br.com.ufrn.bti.desktop.netflixparaguaio.view;

import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Pessoa;
import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Usuario;
import br.com.ufrn.bti.desktop.netflixparaguaio.main.Main;
import br.com.ufrn.bti.desktop.netflixparaguaio.service.UsuarioService;
import br.com.ufrn.bti.desktop.netflixparaguaio.util.Alerta;
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

	private UsuarioService usuarioService;

	private Stage stage;
	private boolean entrarClicked = false;
	private Main main;
	private Usuario usuario;
	
	public CadastroUsuarioController() {
		usuario = new Usuario();
		usuarioService = new UsuarioService();
	}

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
	
	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
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

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@FXML
	public void handleCadastrar() {
		if(validaCampos()){
			Pessoa pessoa = new Pessoa();
			Usuario usuario = new Usuario();
			
			pessoa.setCpf(cpfField.getText());
			pessoa.setNome(nomeField.getText());
			pessoa.setSexo(sexoField.getText().charAt(0));
			usuario.setLogin(loginField.getText());
			usuario.setSenha(senhaField.getText());
			usuario.setPermissao(permissaoField.getText());
			usuario.setPessoa(pessoa);
			usuarioService.salvarOuAtualizar(usuario);
			
			Alerta.alertaSucesso("Tudo certo!", "Usuário cadastrado com sucesso.");
			
			usuario = new Usuario();
		}
	}
	@FXML
    private void handleCancelar() {
        stage.close();
    }
	public boolean validaCampos() {
		if (cpfField.getText() == null || nomeField.getText() == null || nascimentoField.getText() == null
				|| sexoField.getText() == null || loginField.getText() == null || senhaField.getText() == null 
				|| permissaoField.getText() == null){
			Alerta.alertaErro("Campos em branco.", "Preencha todos os campos obrigatórios");
			return false;
		}
			return true;
	}
}
