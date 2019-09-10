package br.com.fiap.averngers.park.dao;


public interface IBaseDAO {
	public Object get(String x) throws Exception;
	public int kill(String x) throws Exception;
	//public int add(Object T) throws Exception;
	public int update(String x) throws Exception;
}
