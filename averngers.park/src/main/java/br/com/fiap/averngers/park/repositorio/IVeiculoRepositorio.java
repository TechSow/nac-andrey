package br.com.fiap.averngers.park.repositorio;

import java.util.ArrayList;
import java.util.Date;

import br.com.fiap.averngers.park.beans.Veiculo;

public interface IVeiculoRepositorio extends IBaseRepositorio{
	public Veiculo get(String placa) throws Exception;
<<<<<<< HEAD
//	public int kill(String placa) throws Exception;
	public int add(Veiculo v) throws Exception;
//	public int setPayOut(int id,Date saida, double preco) throws Exception;
=======
	public int kill(String placa) throws Exception;
	public int add(Veiculo v, String cpfProprietario) throws Exception;
	public int setPayOut(int id,Date saida, double preco) throws Exception;
>>>>>>> feature/login

}
