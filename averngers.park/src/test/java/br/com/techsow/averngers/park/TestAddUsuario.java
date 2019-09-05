package br.com.techsow.averngers.park;

import br.com.averngers.park.beans.Usuario;
import br.com.fiap.averngers.park.dao.UsuarioDAO;
import junit.framework.TestCase;

public class TestAddUsuario{
	public static void Main(String[] args) {
		
		UsuarioDAO dao = null;
		try {
			dao.add(new Usuario("teste","teste@teste","1561651231","teste"));
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dao.closeConnection();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	}
}
