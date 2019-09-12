package br.com.fiap.averngers.park.repositorio;

import br.com.fiap.averngers.park.beans.Proprietario;

public interface IProprietarioRepositorio extends IBaseRepositorio{
	public Proprietario get(String cpf) throws Exception;
	//public int kill(String cpf) throws Exception;
	
	public int add(Proprietario p) throws Exception;
}
