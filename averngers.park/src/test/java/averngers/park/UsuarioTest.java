package averngers.park;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.com.averngers.park.beans.Usuario;
import br.com.fiap.averngers.park.dao.UsuarioDAO;
import junit.framework.Assert;

public class UsuarioTest {
	
	
	
	@Before
	public void antesDoTeste() {
		System.out.println("isso vai ser iniciado antes do teste");
		
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
	
	@Test
	public void testGetUsuario() {
		UsuarioDAO dao = null;
		try {
			dao = new UsuarioDAO();
			
			Usuario u = new Usuario("teste","teste","teste","teste");
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
	
	
}
