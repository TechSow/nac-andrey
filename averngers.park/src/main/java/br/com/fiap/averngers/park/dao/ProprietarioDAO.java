package br.com.fiap.averngers.park.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.averngers.park.beans.Proprietario;
import br.com.fiap.averngers.park.conexao.Conexao;
import br.com.fiap.averngers.park.repositorio.IProprietarioRepositorio;

public class ProprietarioDAO implements IProprietarioRepositorio {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	public ProprietarioDAO() throws Exception {
		con = Conexao.conectar();
	}
	@Override
	public Proprietario get(String cpf) throws Exception {
		stmt = con.prepareStatement("SELECT * FROM PROPRIETARIO WHERE CPF_PROPRIETARIO = ?");
		stmt.setString(1, cpf);

		rs = stmt.executeQuery();

		if (rs.next()) {
			return new Proprietario(rs.getString("CPF_PROPRIETARIO"), rs.getString("NOME_PROPRIETARIO"),
					rs.getString("EMAIL_PROPRIETARIO"));
		} else {
			return new Proprietario();
		}
	}
	@Override
	public int kill(String cpf) throws Exception {
		stmt = con.prepareStatement("DELETE FROM PROPRIETARIO WHERE CPF_PROPRIETARIO = ?");
		stmt.setString(1, cpf);
		return stmt.executeUpdate();
	}
	@Override
	public int add(Proprietario p) throws Exception {
		stmt = con.prepareStatement(
				"INSERT INTO PROPRIETARIO VALUES(CPF_PROPRIETARIO, NOME_PROPRIETARIO, EMAIL_PROPRIETARIO) VALUES(?,?,?)");
		stmt.setString(1, p.getCpf());
		stmt.setString(2, p.getNome());
		stmt.setString(3, p.getEmail());
		return stmt.executeUpdate();
	}
	@Override
	public void close() throws SQLException{
		con.close();
	}
}
