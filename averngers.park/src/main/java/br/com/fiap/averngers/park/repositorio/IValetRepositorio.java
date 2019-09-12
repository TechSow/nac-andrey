package br.com.fiap.averngers.park.repositorio;

import java.util.ArrayList;
<<<<<<< HEAD
import java.sql.Date;
=======
import java.util.Date;
>>>>>>> feature/login

import br.com.fiap.averngers.park.beans.Valet;

public interface IValetRepositorio extends IBaseRepositorio{
	public Valet get(int id) throws Exception;
	public ArrayList<Valet> getAllParked() throws Exception;
<<<<<<< HEAD
	public ArrayList<Valet> getByDay(Date data) throws Exception;
	//public int kill(int id) throws Exception;
	public int park(Valet valet) throws Exception;
	public int setPaymentUnpark(int id,Date saida, double preco) throws Exception;
=======
	//public int kill(int id) throws Exception;
	public int add(Valet valet) throws Exception;
	public int setPayOut(int id,Date saida, double preco) throws Exception;
>>>>>>> feature/login
}
