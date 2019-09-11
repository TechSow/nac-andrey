package averngers.park;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import br.com.fiap.averngers.park.beans.Proprietario;
import br.com.fiap.averngers.park.beans.Veiculo;
import br.com.fiap.averngers.park.dao.VeiculoDAO;

public class VeiculoTest {

	@Ignore
	public void addVeiculoTeste() {
		VeiculoDAO dao = null;
		int r=0;
		try {
			dao = new VeiculoDAO();
			Proprietario p = new Proprietario();
			p.setCpf("cpf");
			p.setEmail("email");
			p.setNome("nome");
			Veiculo v = new Veiculo();

			v.setMarca("marca");
			v.setPlaca("placa");
			v.setProprietario(p);
			r=dao.add(v);
			assertEquals(1, r);
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			try {
				
				dao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				assertEquals(1, r);
			}
		}

	}
	@Test
	public void GetVeiculo() {
		VeiculoDAO dao=null;
		Veiculo v=null;
		try {
			dao=new VeiculoDAO();
			v = dao.get("placa");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dao.close();
				System.out.println(v.getProprietario().getCpf());
			assertEquals("cpf", v.getProprietario().getCpf());
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
