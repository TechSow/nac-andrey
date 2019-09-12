package br.com.fiap.averngers.park.repositorio;

import java.util.ArrayList;
import java.util.Date;

import br.com.fiap.averngers.park.beans.Veiculo;

public interface IVeiculoRepositorio extends IBaseRepositorio{
	public Veiculo get(String placa) throws Exception;
	public int add(Veiculo v) throws Exception;

}
