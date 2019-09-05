package br.com.fiap.averngers.park.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.averngers.park.beans.Usuario;
import br.com.fiap.averngers.park.conexao.Conexao;

public class UsuarioDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public UsuarioDAO() throws Exception {
		con = Conexao.conectar();
	}
	
	public int add(Usuario u) throws Exception{
		stmt = con.prepareStatement("INSERT INTO USUARIO(cpf, nome, email, senha) VALUES(?,?,?,?)");
		stmt.setString(1, u.getCpf());
		stmt.setString(2, u.getNome());
		stmt.setString(3, u.getEmail());
		stmt.setString(4, u.getSenha());
		return stmt.executeUpdate();
	}
	
	public Usuario get(String cpf) throws Exception{
		stmt = con.prepareStatement("SELECT * FROM USUARIO WHERE cpf = ?");
		stmt.setString(1, cpf);
		
		return new Usuario();
	}
	
	public void closeConnection() throws SQLException {
		con.close();
	}
	
}
