package br.com.fiap.averngers.park.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	public static Connection conectar() throws Exception{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
		}catch (ClassNotFoundException ex) {
			System.out.println("Error: unable to load driver class!");
			System.exit(1);
		}catch (IllegalAccessException ex) {
			System.out.println("Error: access problem while loading!");
			System.exit(2);
		}catch(InstantiationException ex) {
			System.out.println("Error: unable to instatiate driver!");
			System.out.println(3);
		}
		
		return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL","rm82198","140796");
	}
	
}
