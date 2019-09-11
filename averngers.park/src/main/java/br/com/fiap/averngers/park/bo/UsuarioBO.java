package br.com.fiap.averngers.park.bo;

import br.com.fiap.averngers.park.beans.Usuario;
import br.com.fiap.averngers.park.dao.UsuarioDAO;

public class UsuarioBO {
	

	public boolean validarCpf(String cpf) {

		return UtilsBO.isCpf(cpf.replaceAll("[./-]", ""));

	}

	public Usuario get(String cpf) {
		UsuarioDAO dao = null;
		Usuario usuario = null;
		try {
			dao = new UsuarioDAO();
			usuario = dao.get(cpf);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				dao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return usuario;
	}
}
