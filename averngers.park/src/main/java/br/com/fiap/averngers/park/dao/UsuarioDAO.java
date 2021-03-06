package br.com.fiap.averngers.park.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.averngers.park.beans.Usuario;
import br.com.fiap.averngers.park.conexao.Conexao;
import br.com.fiap.averngers.park.repositorio.IUsuarioRepositorio;

public class UsuarioDAO implements IUsuarioRepositorio {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	public UsuarioDAO() throws Exception {
		con = Conexao.conectar();
	}

	@Override
	public int add(Usuario u) throws Exception {
		stmt = con.prepareStatement(
				"INSERT INTO USUARIO(USUARIO_CPF, USUARIO_NOME, USUARIO_EMAIL, USUARIO_SENHA) VALUES(?,?,?,?)");
		stmt.setString(1, u.getCpf());
		stmt.setString(2, u.getNome());
		stmt.setString(3, u.getEmail());
		stmt.setString(4, u.getSenha());
		return stmt.executeUpdate();
	}

	@Override
	public Usuario get(String cpf) throws Exception {
		stmt = con.prepareStatement("SELECT * FROM USUARIO WHERE USUARIO_CPF = ?");
		stmt.setString(1, cpf);

		rs = stmt.executeQuery();

		if (rs.next()) {
			return new Usuario(rs.getString("USUARIO_NOME"), rs.getString("USUARIO_EMAIL"), rs.getString("USUARIO_CPF"),
					rs.getString("USUARIO_SENHA"));
		}

		return new Usuario();
	}

	@Override
	public int kill(String cpf) throws Exception {
		stmt = con.prepareStatement("DELETE FROM USUARIO WHERE USUARIO_CPF = ?");
		stmt.setString(1, cpf);
		return stmt.executeUpdate();

	}





	@Override
	public void close() throws SQLException {
		con.close();
	}



        @Override
	public int login(String email, String senha) throws Exception {

		stmt = con.prepareStatement("SELECT USUARIO_NOME, USUARIO_SENHA FROM USUARIO WHERE USUARIO_EMAIL=? AND USUARIO_SENHA=?");
		stmt.setString(1, email);
		stmt.setString(2, senha);

		rs = stmt.executeQuery();
		if(rs.next()) {
			return 1;
		}else {

			return 0;
		}
	}


}
