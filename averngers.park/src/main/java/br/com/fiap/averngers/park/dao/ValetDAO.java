package br.com.fiap.averngers.park.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import br.com.fiap.averngers.park.beans.Valet;
import br.com.fiap.averngers.park.repositorio.IValetRepositorio;

public class ValetDAO implements IValetRepositorio{


	@Override
	public Valet get(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Valet> getAllParked() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(Valet valet) throws Exception {
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
