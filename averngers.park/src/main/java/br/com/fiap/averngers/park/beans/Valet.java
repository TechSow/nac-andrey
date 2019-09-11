package br.com.fiap.averngers.park.beans;

import java.util.Date;

public class Valet {
	private int idValet;
	private Veiculo veiculo;
	private Date entrada, saida;
	private double preco;

	public Valet() {}
	
	public Valet(int idValet, Date entrada, Date saida, double preco, Veiculo veiculo) {
		super();
		this.idValet = idValet;
		this.setVeiculo(veiculo);
		this.entrada = entrada;
		this.saida = saida;
		this.preco = preco;
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
	
	
}
