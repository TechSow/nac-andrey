package br.com.fiap.averngers.park.beans;


import java.sql.Date;


public class Valet {
	private int idValet;
	private Veiculo veiculo;
	private Date entrada, saida;
	private double preco;

	public Valet() {}
	

	public Valet(int idValet, Date entrada, Date saida, double preco, Veiculo veiculo) {

		this.idValet = idValet;
		this.setVeiculo(veiculo);
		this.entrada = entrada;
		this.saida = saida;
		this.preco = preco;
	}

	public Valet(int idValet, Date entrada, Veiculo veiculo) {
		this.idValet = idValet;
		this.setVeiculo(veiculo);
		this.entrada = entrada;
	}
	

	public int getIdValet() {
		return idValet;
	}

	public void setIdValet(int idValet) {
		this.idValet = idValet;
	}

	public Date getEntrada() {
		return entrada;
	}

	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}

	public Date getSaida() {
		return saida;
	}

	public void setSaida(Date saida) {
		this.saida = saida;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	

	public void setSaidaPreco(Date saida, double preco) {
		this.saida = saida;
		this.preco = preco;
	}
}