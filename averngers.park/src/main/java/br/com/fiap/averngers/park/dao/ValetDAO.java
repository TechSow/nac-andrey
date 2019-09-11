package br.com.fiap.averngers.park.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import br.com.fiap.averngers.park.beans.Valet;
import br.com.fiap.averngers.park.beans.Veiculo;
import br.com.fiap.averngers.park.conexao.Conexao;
import br.com.fiap.averngers.park.repositorio.IValetRepositorio;

public class ValetDAO implements IValetRepositorio{

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	public ValetDAO() throws Exception {
		con = Conexao.conectar();
	}
	@Override
	public Valet get(int id) throws Exception {
		stmt = con.prepareStatement("SELECT * FROM VALET WHERE ID_VALET = ?");
		stmt.setInt(1, id);
		rs = stmt.executeQuery();
		if(rs.next()) {
			VeiculoDAO veiculoDAO = new VeiculoDAO();
			Veiculo veiculo = veiculoDAO.get(rs.getString("PLACA_VEICULO"));
			return new Valet(
					rs.getInt("ID_VALET"), 
					rs.getDate("ENTRADA"),
					rs.getDate("SAIDA"),
					(double) rs.getFloat("PRECO"),
					veiculo);
		}else {
			return new Valet();
		}
	}

	@Override
	public ArrayList<Valet> getAllParked() throws Exception {
		
		return null;
	}

	@Override
	public int add(Valet valet) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setPaymentUnpark(int id, Date saida, double preco) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void close() throws SQLException {
		con.close();
		
	}
}
