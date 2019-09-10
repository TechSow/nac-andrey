package br.com.fiap.averngers.park.repositorio;

import br.com.fiap.averngers.park.beans.Usuario;

public interface IUsuarioRepositorio extends IBaseRepositorio{
	public Usuario get(String cpf) throws Exception;
	public int add(Usuario user) throws Exception;
	public int kill(String cpf) throws Exception;
}
