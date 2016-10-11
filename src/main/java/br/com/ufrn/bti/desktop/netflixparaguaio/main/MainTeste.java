package br.com.ufrn.bti.desktop.netflixparaguaio.main;

import br.com.ufrn.bti.desktop.netflixparaguaio.dao.PessoaDAO;
import br.com.ufrn.bti.desktop.netflixparaguaio.dao.UsuarioDAO;
import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Pessoa;
import br.com.ufrn.bti.desktop.netflixparaguaio.dominio.Usuario;

public class MainTeste {

	public static void main(String[] args) {
		Pessoa p = new Pessoa();
		p.setCpf("10904368408");
		p.setNome("Ramon");
		p.setSexo('M');
		Usuario usuario = new Usuario();
		usuario.setAtivo(true);
		usuario.setLogin("ramonsantos");
		usuario.setPermissao("USER");
		usuario.setSenha("ramon");
		usuario.setPessoa(p);
		PessoaDAO pDao = new PessoaDAO();
		pDao.salvarOuAtualizar(p);
		UsuarioDAO usuarioDao = new UsuarioDAO();
		usuarioDao.salvarOuAtualizar(usuario);
	}

}
