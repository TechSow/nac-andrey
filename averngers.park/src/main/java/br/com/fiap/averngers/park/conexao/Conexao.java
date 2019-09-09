package br.com.fiap.averngers.park.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	public static Connection conectar() throws Exception {
		try {
			Class.forName("oracle.jdbc.drive.OracleDriver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "rm82198",
				"140796");
		return con;
	}
}