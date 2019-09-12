package br.com.fiap.averngers.park.dao;

<<<<<<< HEAD
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import br.com.fiap.averngers.park.beans.Valet;
import br.com.fiap.averngers.park.beans.Veiculo;
import br.com.fiap.averngers.park.conexao.Conexao;
import br.com.fiap.averngers.park.repositorio.IValetRepositorio;

public class ValetDAO implements IValetRepositorio {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	private ArrayList<Valet> list;

	public ValetDAO() throws Exception {
		con = Conexao.conectar();
	}

	@Override
	public Valet get(int id) throws Exception {
		stmt = con.prepareStatement("SELECT * FROM VALET WHERE ID_VALET = ?");
		stmt.setInt(1, id);
		rs = stmt.executeQuery();
		if (rs.next()) {
			VeiculoDAO veiculoDAO = new VeiculoDAO();
			Veiculo veiculo = veiculoDAO.get(rs.getString("PLACA_VEICULO"));
			Valet valet = new Valet(rs.getInt("ID_VALET"), rs.getDate("ENTRADA"), rs.getDate("SAIDA"),
					(double) rs.getFloat("PRECO"), veiculo);
			veiculoDAO.close();
			return valet;
		} else {
			return new Valet();
		}
	}
	@Override
	public ArrayList<Valet> getByDay(Date data) throws Exception{
		list = null;
		stmt = con.prepareStatement("SELECT * FROM Valet WHERE SAIDA IS NOT NULL and PRECO IS NOT NULL ");
		rs = stmt.executeQuery();
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		while(rs.next()) {
			Veiculo veiculo = veiculoDAO.get(rs.getString("PLACA_VEICULO"));
			list.add(new Valet(
					rs.getInt("ID_VALET"),
					rs.getDate("ENTRADA"),
					rs.getDate("SAIDA"),
					(double) rs.getFloat("PRECO"),
					veiculo
					));
		}
		veiculoDAO.close();
		return list;

	}
	@Override
	public ArrayList<Valet> getAllParked() throws Exception {
		list = null;
		stmt = con.prepareStatement("SELECT * FROM Valet WHERE SAIDA IS NULL and PRECO IS NULL");
		rs = stmt.executeQuery();
		
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		while(rs.next()) {
			Veiculo veiculo = veiculoDAO.get(rs.getString("PLACA_VEICULO"));
			list.add(new Valet(
					rs.getInt("ID_VALET"),
					rs.getDate("ENTRADA"),
					rs.getDate("SAIDA"),
					(double) rs.getFloat("PRECO"),
					veiculo
					));
		}
		veiculoDAO.close();
		return list;
	}

	@Override
	public int park(Valet valet) throws Exception {
		stmt = con.prepareStatement("INSERT INTO Valet(ID_VALET,ENTRADA,PLACA_VEICULO) VALUES(?,?,?)");
		stmt.setInt(1, valet.getIdValet());
		stmt.setDate(2, valet.getEntrada());
		stmt.setString(3, valet.getVeiculo().getPlaca());
		return stmt.executeUpdate();
	}

	@Override
	public int setPaymentUnpark(int id, Date saida, double preco) throws Exception {
		stmt = con.prepareStatement("UPDATE Valet set SAIDA = ?, PRECO = ? WHERE ID_VALET = ?");
		stmt.setDate(1, saida);
		stmt.setDouble(2, preco);
		stmt.setInt(3, id);
		return stmt.executeUpdate();
=======
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
>>>>>>> feature/login
	}

	@Override
	public void close() throws SQLException {
<<<<<<< HEAD
		con.close();

=======
		// TODO Auto-generated method stub
		
>>>>>>> feature/login
	}
}
