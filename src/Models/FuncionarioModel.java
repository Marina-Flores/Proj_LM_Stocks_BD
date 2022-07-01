package Models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import Entities.Cargo;
import Entities.Funcionario;
import Entities.Pessoa;
import Repositories.CargoRepository;
import Repositories.FuncionarioRepository;
import Repositories.PessoaRepository;

public class FuncionarioModel {
	private static FuncionarioRepository _funcionarioRepository = new FuncionarioRepository();
	private static PessoaRepository _pessoaRepository = new PessoaRepository();
	private static CargoRepository _cargoRepository = new CargoRepository();

	
	public static Boolean isNullOrEmpty(String s) {
		return s == null || s.isEmpty();
	}
	
	
	public static void GetAll() {
		ArrayList<Funcionario> lista = (ArrayList<Funcionario>) _funcionarioRepository.GetAll();
		int contador = 1;
		for(Funcionario f : lista) {
			System.out.println(contador + " - " + f.getLogin() + " - " + f);
			contador++;
		}
	}
	
	public static Funcionario Insert() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite o Login do funcion�rio: ");
		String login = sc.nextLine();
		
		System.out.print("Digite a Senha do funcion�rio: ");
		String senha = sc.nextLine();
		
		System.out.print("Digite 's' se o funcion�rio est� ativo e 'n' ele n�o estiver ativo: ");
		String ativo = sc.nextLine();
		
		Boolean isAtivo;
		if(ativo == "s")
			isAtivo = true;
		else
			isAtivo = false;
		
		System.out.print("Digite o Salario do funcion�rio: ");
		double salario = sc.nextDouble();
		
		System.out.print("Digite a data de contrata��o do funcion�rio (yyyy-mm-dd): ");
		String contratadoDesde = sc.next();
		
		System.out.print("Digite o login do supervisor do funcion�rio (se houver): ");
		String loginSupervisor = sc.next();		
		
		System.out.print("Digite qual cpf corresponde ao do funcion�rio");
		GetCPFPessoas();
		
		System.out.print("CPF: ");
		String cpf = sc.next();
		
		System.out.println("Digite a op��o com o cargo do funcion�rio");
		GetCargos();
		
		int cargoid = sc.nextInt();				
		
		Funcionario f = new Funcionario(login, senha, isAtivo, salario, Date.valueOf(contratadoDesde), loginSupervisor, cpf, cargoid);	
		
		if(isNullOrEmpty(FuncionarioValido(f)))
			_funcionarioRepository.Insert(f);
		else
			System.out.println(FuncionarioValido(f));		
		
		return f;		
	}
	
	public static Funcionario Update(String identificador) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite o Login do funcion�rio: ");
		String login = sc.nextLine();
		
		System.out.print("Digite a Senha do funcion�rio: ");
		String senha = sc.nextLine();
		
		System.out.print("Digite 's' se o funcion�rio est� ativo e 'n' ele n�o estiver ativo: ");
		String ativo = sc.nextLine();
		
		Boolean isAtivo;
		if(ativo == "s")
			isAtivo = true;
		else
			isAtivo = false;
		
		System.out.print("Digite o Salario do funcion�rio: ");
		double salario = sc.nextDouble();
		
		System.out.print("Digite a data de contrata��o do funcion�rio (yyyy-mm-dd): ");
		String contratadoDesde = sc.next();
		java.sql.Date dtValue = java.sql.Date.valueOf(contratadoDesde);
				
		System.out.print("Digite o login do supervisor do funcion�rio (se houver): ");
		String loginSupervisor = sc.next();		
		sc.nextLine();
		
//		System.out.println("Digite qual cpf corresponde ao do funcion�rio");
//		GetCPFPessoas();
//		
//		System.out.print("CPF: ");
//		String cpf = sc.next();
		
		System.out.println("Digite a op��o com o cargo do funcion�rio");
		GetCargos();
		
		int cargoid = sc.nextInt();				
		
		Funcionario f = new Funcionario(login, senha, isAtivo, salario, dtValue, loginSupervisor, cargoid);		
		
			_funcionarioRepository.Update(f, identificador);		
		
		return f;				
	}
	
	public static Funcionario Get(String identificador) {
		Funcionario f = _funcionarioRepository.Get(identificador);
		return f;
	}
	
	public static void Remover(String identificador) {
		_funcionarioRepository.Remove(identificador);
	}
	
	
	public static void GetCPFPessoas() {
		ArrayList<Pessoa> lista = (ArrayList<Pessoa>) _pessoaRepository.GetAll();
		int contador = 1;
		for(Pessoa p : lista) {
			System.out.println(contador + " - " + p.getCpf());	
			contador++;
		}
	}
	
	public static void GetCargos() {
		ArrayList<Cargo> lista = (ArrayList<Cargo>) _cargoRepository.GetCargos();
		for(Cargo c : lista) {
			System.out.println("------------------------" +
							c.getID() + " - " + c.getDescricao());
		}
	}
	
	
	public static String FuncionarioValido(Funcionario f) {
		
		StringBuilder validacao = new StringBuilder();	
		ArrayList<Funcionario> funcionarios = (ArrayList<Funcionario>) _funcionarioRepository.GetAll();
		
		if(isNullOrEmpty(f.getLogin()))
			validacao.append("Login � obrigat�rio. \n");
		
		if(isNullOrEmpty(f.getSenha()))
			validacao.append("Senha � obrigat�rio. \n");
		
		if(isNullOrEmpty(f.getContratadoDesde().toString()))
			validacao.append("Data de Contrata��o � obrigat�rio. \n");
		
		if(isNullOrEmpty(f.getPessoaCpf()))
			validacao.append("Pessoa CPF � obrigat�rio. \n");
		
		if(f.getCargoId() == 0)
			validacao.append("Cargo � obrigat�rio. \n");
		
		if(Get(f.getLogin()).getLogin() != null) {
			System.out.println(Get(f.getLogin()).getLogin());
			validacao.append("J� existe um funcion�rio cadastrado com esse login. \n");
		}
			
		
		if(isNullOrEmpty(f.getLoginSupervisor()) && (f.getCargoId() != 1 && f.getCargoId() != 2))
			validacao.append("Login do supervisor � obrigat�rio para esse cargo. \n");
		
		if(!isNullOrEmpty(f.getLoginSupervisor()) && (f.getCargoId() == 1 || f.getCargoId() == 2))
			validacao.append("O cargo selecionado n�o precisa de login supervisor. \n");
		
		for(Funcionario funcionario : funcionarios) {
			if(f.getPessoaCpf() == funcionario.getPessoaCpf())
				validacao.append("J� existe um funcion�rio cadastrado com esse cpf. \n");
		}		
		
		return validacao.toString();
		
	}
	
	
	
}
