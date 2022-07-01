package Entities;

import java.sql.Date;

public class Funcionario {
	private String Login;
	private String Senha;
	private boolean Ativo;
	private double Salario;
	private Date ContratadoDesde;
	private String LoginSupervisor;
	private String PessoaCpf; 
	private int CargoId;
	private String NomePessoa;
	private String NomeCargo;

 	public Funcionario() {}
	
	public Funcionario(String login, String senha, boolean ativo, double salario, Date contratadoDesde, String loginSupervisor, String pessoacpf, int cargoid) {
		this.Login = login;
		this.Senha = senha;
		this.Ativo = ativo;
		this.Salario = salario;
		this.ContratadoDesde = contratadoDesde;
		this.LoginSupervisor = loginSupervisor;
		this.PessoaCpf = pessoacpf;
		this.CargoId = cargoid;		
	}
	
	public Funcionario(String login, String senha, boolean ativo, double salario, Date contratadoDesde, String loginSupervisor, int cargoid) {
		this.Login = login;
		this.Senha = senha;
		this.Ativo = ativo;
		this.Salario = salario;
		this.ContratadoDesde = contratadoDesde;
		this.LoginSupervisor = loginSupervisor;		
		this.CargoId = cargoid;		
	}
	
	
	public String getNomePessoa() {
		return NomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		NomePessoa = nomePessoa;
	}

	public String getNomeCargo() {
		return NomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		NomeCargo = nomeCargo;
	}
	
	public String getLogin() {
		return Login;
	}
	
	public void setLogin(String login) {
		Login = login;
	}
	
	public String getSenha() {
		return Senha;
	}
	
	public void setSenha(String senha) {
		Senha = senha;
	}
	
	public double getSalario() {
		return Salario;
	}
	
	public void setSalario(double salario) {
		Salario = salario;
	}
	
	public boolean getAtivo() {
		return Ativo;
	}
	
	public void setAtivo(boolean ativo) {
		Ativo = ativo;
	}

	public Date getContratadoDesde() {
		return ContratadoDesde;
	}

	public void setContratadoDesde(Date contratadoDesde) {
		ContratadoDesde = contratadoDesde;
	}

	public int getCargoId() {
		return CargoId;
	}

	public void setCargoId(int cargoId) {
		CargoId = cargoId;
	}
	
	public String getPessoaCpf() {
		return PessoaCpf;
	}

	public void setPessoaCpf(String pessoaCpf) {
		PessoaCpf = pessoaCpf;
	}

	public String getLoginSupervisor() {
		return LoginSupervisor;
	}

	public void setLoginSupervisor(String loginSupervisor) {
		LoginSupervisor = loginSupervisor;
	}
	
	@Override
	public String toString() {
		return this.NomePessoa + " - " + this.NomeCargo;
	}

}
