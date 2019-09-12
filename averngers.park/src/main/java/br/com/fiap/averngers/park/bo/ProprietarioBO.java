package br.com.fiap.averngers.park.bo;

import br.com.fiap.averngers.park.beans.Proprietario;
import br.com.fiap.averngers.park.dao.ProprietarioDAO;

public class ProprietarioBO {

	private ProprietarioDAO pDao;

	public ProprietarioBO() throws Exception {
		pDao = new ProprietarioDAO();
	}

	public Proprietario get(String cpf) {
		if (cpf.isEmpty()) {
			return null;
		}

		if (!UtilsBO.isCpf(cpf)) {
			return null;
		}

		Proprietario proprietario = null;

		try {
			proprietario = pDao.get(cpf);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pDao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return proprietario;

	}

	public String add(String cpf, String nome, String email) {
		if(cpf.isEmpty()) {
			return "Informe o cpf do proprietário";
		}
		
		if(nome.isEmpty()) {
			return "Informe o nome do proprietário";
		}
		if(email.isEmpty()) {
			return "Informe o email do proprietário";
		}
		
		if(!UtilsBO.isEmail(email)) {
			return "Email inválido";
		}
		
		if(!UtilsBO.isCpf(cpf)) {
			return "CPF inválido";
		}
		int r = 0;
		
		Proprietario validarP =null;
		try {
			validarP = this.get(cpf);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(validarP.getCpf() == null) {		
		Proprietario p = new Proprietario(cpf,nome,email);
		try {			
			r = pDao.add(p);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pDao.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		}
		if(r == 1) 
			return "Proprietário cadastrado";
		else
			return "Aconteceu um erro, por favor, tente novamente mais tarde.";
		
	}

}
