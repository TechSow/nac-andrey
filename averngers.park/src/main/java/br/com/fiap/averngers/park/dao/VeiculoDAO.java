package br.com.fiap.averngers.park.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import br.com.fiap.averngers.park.beans.Veiculo;
import br.com.fiap.averngers.park.conexao.Conexao;
import br.com.fiap.averngers.park.repositorio.IVeiculoRepositorio;

public class VeiculoDAO implements IVeiculoRepositorio {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	public VeiculoDAO() throws Exception {
		con = Conexao.conectar();
	}

	@Override
	public Veiculo get(String placa) throws Exception {
		stmt = con.prepareStatement("select * from VEICULO where PLACA_VEICULO=?");
		stmt.setString(1, placa);
		rs = stmt.executeQuery();
		if (rs.next()) {

			ProprietarioDAO dao = new ProprietarioDAO();

			Veiculo veiculo = new Veiculo(rs.getString("PLACA_VEICULO"), rs.getString("MARCA_VEICULO"),
					dao.get(rs.getString("CPF_PROPRIETARIO")));
			dao.close();
			return veiculo;

		} else {
			return new Veiculo();

		}

	}

	@Override
	public int add(Veiculo v) throws Exception {
		stmt=con.prepareStatement("insert into Veiculo(PLACA_VEICULO,MARCA_VEICULO,CPF_PROPRIETARIO)values(?,?,?)");
		stmt.setString(1, v.getPlaca());
		stmt.setString(2, v.getMarca());
		stmt.setString(3, v.getProprietario().getCpf());
		return stmt.executeUpdate();
		
	}

	

	@Override
	public void close() throws SQLException {
		con.close();

	}

	
}