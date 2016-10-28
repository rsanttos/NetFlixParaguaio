package br.com.ufrn.bti.desktop.netflixparaguaio.view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Pessoa;
import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Usuario;
import br.com.ufrn.bti.desktop.netflixparaguaio.main.Main;
import br.com.ufrn.bti.desktop.netflixparaguaio.service.UsuarioService;
import br.com.ufrn.bti.desktop.netflixparaguaio.util.Alerta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
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
	private PasswordField senhaField;
	@FXML
	private TextField permissaoField;

	private ObservableList<String> opcoesSexoComboBox = FXCollections.observableArrayList("M", "F");
	private ObservableList<String> opcoesPermissaoComboBox = FXCollections.observableArrayList("ADMIN", "USER");
	
	@FXML
	private ComboBox<String> sexoComboBox = new ComboBox<String>();
	@FXML
	private ComboBox<String> permissaoComboBox = new ComboBox<String>();
	
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
		sexoComboBox.getItems().addAll(opcoesSexoComboBox);
		permissaoComboBox.getItems().addAll(opcoesPermissaoComboBox);
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
	
	public PasswordField getSenhaField() {
		return senhaField;
	}

	public void setSenhaField(PasswordField senhaField) {
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
	public void handleCadastrar() throws ParseException {
		if(validaCampos()){
			Pessoa pessoa = new Pessoa();
			Usuario usuario = new Usuario();
			DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
			Date date = (Date)formatter.parse(nascimentoField.getText());
			pessoa.setCpf(cpfField.getText());
			pessoa.setNome(nomeField.getText());
			pessoa.setSexo(sexoComboBox.getValue().charAt(0));
			pessoa.setDataNascimento(date);
			usuario.setLogin(loginField.getText());
			usuario.setSenha(senhaField.getText());
			usuario.setPermissao(permissaoComboBox.getValue());			
			usuario.setPessoa(pessoa);
			usuarioService.salvarOuAtualizar(usuario);
			
			Alerta.alertaSucesso("Tudo certo!", "Usuário cadastrado com sucesso.");
			
			usuario = new Usuario();
			
			stage.close();
		}
	}
	@FXML
    private void handleCancelar() {
        stage.close();
    }
	public boolean validaCampos() {
		if (cpfField.getText() == null || nomeField.getText() == null || nascimentoField.getText() == null
				|| sexoComboBox.getValue() == null || loginField.getText() == null || senhaField.getText() == null 
				|| permissaoComboBox.getValue() == null){
			Alerta.alertaErro("Campos em branco.", "Preencha todos os campos obrigatórios");
			return false;
		}
			return true;
	}

	public ObservableList<String> getOpcoesSexoComboBox() {
		return opcoesSexoComboBox;
	}

	public void setOpcoesSexoComboBox(ObservableList<String> opcoesSexoComboBox) {
		this.opcoesSexoComboBox = opcoesSexoComboBox;
	}

	public ObservableList<String> getOpcoesPermissaoComboBox() {
		return opcoesPermissaoComboBox;
	}

	public void setOpcoesPermissaoComboBox(ObservableList<String> opcoesPermissaoComboBox) {
		this.opcoesPermissaoComboBox = opcoesPermissaoComboBox;
	}

	public ComboBox<String> getSexoComboBox() {
		return sexoComboBox;
	}
	
	public void setSexoComboBox(ComboBox<String> sexoComboBox) {
		this.sexoComboBox = sexoComboBox;
	}

	public ComboBox<String> getPermissaoComboBox() {
		return permissaoComboBox;
	}

	public void setPermissaoComboBox(ComboBox<String> permissaoComboBox) {
		this.permissaoComboBox = permissaoComboBox;
	}
	
	
}
