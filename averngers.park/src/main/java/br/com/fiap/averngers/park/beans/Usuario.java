package br.com.fiap.averngers.park.beans;

public class Usuario {
	private String nome,email,cpf,senha;
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Usuario(String nome, String email, String cpf, String senha) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.senha= senha;
	}
	
	public Usuario() {}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", senha=" + senha + "]";
	}
	
	
}
