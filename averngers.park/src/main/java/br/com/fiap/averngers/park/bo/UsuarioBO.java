package br.com.fiap.averngers.park.bo;

import br.com.fiap.averngers.park.beans.Usuario;
import br.com.fiap.averngers.park.dao.UsuarioDAO;

public class UsuarioBO {

	private UsuarioDAO uDao;

	public UsuarioBO() throws Exception {
		uDao = new UsuarioDAO();
	}

	public boolean validarCpf(String cpf) {

		return UtilsBO.isCpf(cpf.replaceAll("[./-]", ""));

	}

	public String add(String nome, String email, String cpf, String senha, String confirmarSenha) {
		if (nome.isEmpty()) {
			return "Insira o nome";
		}
		if (nome.length() < 2) {
			return "O nome tem que ter no mínimo de 3 letras";
		}

		if (email.isEmpty()) {
			return "Insira o email";
		}

		if (cpf.isEmpty()) {
			return "Insira o cpf";
		}
		if (senha.isEmpty()) {
			return "Insira a senha";
		}
		if (senha.length() < 5) {
			return "A senha tem que ter no mínimo 5 dígitos";
		}
		if (confirmarSenha.isEmpty()) {
			return "Confirme a senha";
		}
		if (!UtilsBO.isCpf(cpf)) {
			return "CPF inválido";
		}
		if (!UtilsBO.isEmail(email)) {
			return "E-mail inválido";
		}
		int r = 0;
		try {
			r = uDao.add(new Usuario(nome, email, cpf, senha));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				uDao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (r == 1) {
			return "Usuario cadastrado com sucesso!";
		} else {
			return "Houve um erro no processamento, por favor, tente novamente mais tarde";
		}
	}

	public Usuario get(String cpf) {
		Usuario usuario = null;
		try {
			usuario = uDao.get(cpf);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				uDao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return usuario;
	}

	public int login(String email, String senha) throws Exception {

		UsuarioDAO dao = new UsuarioDAO();

		if (dao.login(email, senha) == 1) {

			return 1;
		} else {
			return 0;
		}

	}

	public int cadastro(String cpf, String senha, String email, String nome) throws Exception {

		Usuario usuario = new Usuario();
		usuario.setCpf(cpf);
		usuario.setEmail(email);
		usuario.setNome(nome);
		usuario.setSenha(senha);

		UsuarioDAO dao = new UsuarioDAO();

		if (dao.add(usuario) == 1) {

			return 1;
		} else {

			return 0;
		}
	}

}
