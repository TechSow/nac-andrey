//package averngers.park;
//
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//
//import org.junit.Ignore;
//import org.junit.Test;
//
//import br.com.fiap.averngers.park.beans.Usuario;
//import br.com.fiap.averngers.park.bo.UsuarioBO;
//import br.com.fiap.averngers.park.dao.UsuarioDAO;
//import junit.framework.Assert;
//
//public class UsuarioTest {
//	
//	
//	
//	@Ignore
//	public void testKillUsuario() throws Exception {
//		UsuarioDAO dao = null;
//		try {
//			dao = new UsuarioDAO();
//			
//			Assert.assertEquals(1, dao.kill("teste"));
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				dao.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//		
//	}
//	
//
//	@Test
//	public void testGetUsuario() {
//		UsuarioDAO dao = null;
//		try {
//			dao = new UsuarioDAO();
//			Usuario user = dao.get("13");
//			System.out.println("fueda");
//			System.out.println(user.getNome());
//			
//			Assert.assertEquals("13", dao.get("13").getCpf());
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				dao.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}
//	
//	
//	@Ignore
//	public void testIsCreated() {
//		UsuarioDAO dao = null;
//		try {
//			dao = new UsuarioDAO();
//			
//			Usuario u = new Usuario("teste","teste","teste","teste");
//			Assert.assertEquals(1, dao.add(u));
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				dao.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//		
//	}
//
//	@Ignore
//	public void testIsCpf() {
//		UsuarioBO bo = new UsuarioBO();
//		
//		Assert.assertTrue(bo.validarCpf("503.386.998-10"));
//		
//	}
//	
//}
