package averngers.park;

import org.junit.Ignore;
import org.junit.Test;

import br.com.averngers.park.beans.Usuario;
import br.com.fiap.averngers.park.dao.UsuarioDAO;
import junit.framework.Assert;

public class UsuarioTest {
	
	
	
	@Ignore
	public void testKillUsuario() throws Exception {
		UsuarioDAO dao = null;
		try {
			dao = new UsuarioDAO();
			
			Assert.assertEquals(1, dao.kill("teste"));
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dao.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	

	@Ignore
	public void testGetUsuario() {
		UsuarioDAO dao = null;
		try {
			dao = new UsuarioDAO();
			
			Assert.assertEquals("teste", dao.get("teste").getCpf());
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dao.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@Ignore
	public void testIsCreated() {
		UsuarioDAO dao = null;
		try {
			dao = new UsuarioDAO();
			
			Usuario u = new Usuario("teste","teste","teste","teste");
			Assert.assertEquals(1, dao.add(u));
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dao.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
