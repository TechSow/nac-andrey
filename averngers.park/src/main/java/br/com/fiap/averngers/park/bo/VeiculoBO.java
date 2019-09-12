package br.com.fiap.averngers.park.bo;

import br.com.fiap.averngers.park.beans.Proprietario;
import br.com.fiap.averngers.park.beans.Veiculo;
import br.com.fiap.averngers.park.dao.ProprietarioDAO;
import br.com.fiap.averngers.park.dao.VeiculoDAO;

public class VeiculoBO {
	private VeiculoDAO vDao;

	public VeiculoBO() throws Exception {
		vDao = new VeiculoDAO();
	}

	public Veiculo get(String placa) {
		if (placa.isEmpty()) {
			return null;
		}

		if (!UtilsBO.isPlaca(placa)) {
			return null;
		}
		Veiculo v = null;
		try {
			v = vDao.get(placa);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				vDao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return v;
	}

	public String add(String placa, String marca, String cpf) {
		if (marca.isEmpty()) {
			return "Informe a marca do veículo";
		}

		if (placa.isEmpty()) {
			return "Informe a placa do veículo";
		}

		if (cpf.isEmpty()) {
			return "Informe o cpf do proprietário do veículo";
		}

		if (!UtilsBO.isPlaca(placa)) {
			return "Placa inválida";
		}

		if (!UtilsBO.isCpf(cpf)) {
			return "CPF inválido";
		}
		ProprietarioDAO pDao = null;
		Veiculo v = null;
		int r = 0;
		try {
			pDao = new ProprietarioDAO();
			r = vDao.add(new Veiculo(placa, marca, pDao.get(cpf)));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pDao.close();
				vDao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if(r == 1) {
			return "Veículo cadastrado.";
		}else {
			return "Houve uma falha por favor, tente novamente mais tarde.";
		}
	}

}
