package br.com.fiap.averngers.park.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

import oracle.jdbc.driver.OracleDriver;

public class Conexao {

	public static Connection conectar() throws Exception {

		DriverManager.registerDriver(new OracleDriver());
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", 
				"rm82198",
				"140796");
		return con;
	}
}