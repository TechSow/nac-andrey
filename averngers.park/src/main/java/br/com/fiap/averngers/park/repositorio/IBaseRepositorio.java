package br.com.fiap.averngers.park.repositorio;

import java.sql.SQLException;

public interface IBaseRepositorio {
	public void close() throws SQLException;
}
