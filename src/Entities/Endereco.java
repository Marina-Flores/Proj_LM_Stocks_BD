package Entities;

public class Endereco {
	private int Id;
	private String Estado;
	private String Cidade;
	private String Bairro;
	private String Logradouro;
	private int Numero;
	private String Cep;
	
	public Endereco() {}
	
	public Endereco(String estado, String cidade, String bairro, String logradouro, int numero, String cep ) {
		this.Estado = estado;
		this.Cidade = cidade;
		this.Bairro = bairro;
		this.Logradouro = logradouro;
		this.Numero = numero;
		this.Cep = cep;
	}
	
	public int getId() {
		return Id;
	}
	
	public void setId(int id) {
		Id = id;
	}
	
	public String getEstado() {
		return Estado;
	}
	
	public void setEstado(String estado) {
		Estado = estado;
	}
	
	public String getCidade() {
		return Cidade;
	}
	
	public void setCidade(String cidade) {
		Cidade = cidade;
	}
	
	public String getBairro() {
		return Bairro;
	}
	
	public void setBairro(String bairro) {
		Bairro = bairro;
	}
	
	public String getLogradouro() {
		return Logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		Logradouro = logradouro;
	}
	
	public int getNumero() {
		return Numero;
	}
	
	public void setNumero(int numero) {
		Numero = numero;
	}
	
	public String getCep() {
		return Cep;
	}
	
	public void setCep(String cep) {
		Cep = cep;
	}
	
	@Override
	public String toString() {
		return String.format("%s %d, %s, %s - %s, %s ", 
					this.Logradouro,
					this.Numero,
					this.Bairro,
					this.Cidade,
					this.Estado,
					this.Cep);
	}
	
	
	

}
