package br.com.fiap.averngers.park.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.averngers.park.beans.Proprietario;
import br.com.fiap.averngers.park.conexao.Conexao;

public class ProprietarioDAO implements IBaseDAO {
	
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public ProprietarioDAO() throws Exception{
		con = Conexao.conectar();
	}
	
	@Override
	public Object get(String cpf) throws Exception {
		stmt = con.prepareStatement("SELECT * FROM PROPRIETARIO WHERE CPF_PROPRIETARIO = ?");
		stmt.setString(1, cpf);
		
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			return new Proprietario(rs.getString("CPF_PROPRIETARIO"), rs.getString("NOME_PROPRIETARIO"), rs.getString("EMAIL_PROPRIETARIO"));
		}else {
			return new Proprietario();
		}
	}

	@Override
	public int kill(String cpf) throws Exception {
		stmt = con.prepareStatement("DELETE FROM PROPRIETARIO WHERE CPF_PROPRIETARIO = ?");
		stmt.setString(1, cpf);
		return stmt.executeUpdate();
	}

	
	public int add(Proprietario p) throws Exception {

		return 0;
	}

	@Override
	public int update(String x) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}

