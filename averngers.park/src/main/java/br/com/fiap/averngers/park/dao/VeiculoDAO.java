package br.com.fiap.averngers.park.dao;

<<<<<<< HEAD
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
=======
>>>>>>> feature/login
import java.sql.SQLException;
import java.util.Date;

import br.com.fiap.averngers.park.beans.Veiculo;
<<<<<<< HEAD
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

=======
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
>>>>>>> feature/login
}
