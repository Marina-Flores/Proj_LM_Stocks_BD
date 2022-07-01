package Entities;

import java.sql.Date;

public class Pessoa {
	private String Cpf;
	private String Nome;
	private Date DataNascimento;
	private int EnderecoId;
	
	public Pessoa(String cpf, String nome, Date datanascimento, int enderecoid) {
		this.Cpf = cpf;
		this.Nome = nome;
		this.DataNascimento = datanascimento;
		this.EnderecoId = enderecoid;
	}
	
	public Pessoa() {
		
	}
	
	public String getCpf() {
		return Cpf;
	}
	
	public void setCpf(String cpf) {
		Cpf = cpf;
	}
	
	public String getNome() {
		return Nome;
	}
	
	public void setNome(String nome) {
		Nome = nome;
	}
	
	public Date getDataNascimento() {
		return DataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		DataNascimento = dataNascimento;
	}
	
	public int getEnderecoId() {
		return EnderecoId;
	}
	
	public void setEnderecoId(int enderecoId) {
		EnderecoId = enderecoId;
	}
}
