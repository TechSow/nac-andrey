package br.com.fiap.averngers.park.beans;

public class Veiculo {
	
	private String placa, marca;
	private Proprietario proprietario;
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Proprietario getProprietario() {
		return proprietario;
	}
	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
	public Veiculo( String placa, String marca, Proprietario proprietario) {
		this.placa = placa;
		this.marca = marca;
		this.proprietario = proprietario;
	}
	public Veiculo() {
		super();
	}
	
	
}
