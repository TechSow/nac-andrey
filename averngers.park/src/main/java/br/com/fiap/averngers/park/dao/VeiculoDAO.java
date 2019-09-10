package br.com.fiap.averngers.park.dao;

import java.sql.SQLException;
import java.util.Date;

import br.com.fiap.averngers.park.beans.Veiculo;
import br.com.fiap.averngers.park.repositorio.IVeiculoRepositorio;

public class VeiculoDAO implements IVeiculoRepositorio{


	@Override
	public Veiculo get(String placa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int kill(String placa) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(Veiculo v, String cpfProprietario) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setPayOut(int id, Date saida, double preco) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void close() throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
