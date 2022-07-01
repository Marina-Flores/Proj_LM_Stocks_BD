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
		
		System.out.print("Digite o Login do funcionário: ");
		String login = sc.nextLine();
		
		System.out.print("Digite a Senha do funcionário: ");
		String senha = sc.nextLine();
		
		System.out.print("Digite 's' se o funcionário está ativo e 'n' ele não estiver ativo: ");
		String ativo = sc.nextLine();
		
		Boolean isAtivo;
		if(ativo == "s")
			isAtivo = true;
		else
			isAtivo = false;
		
		System.out.print("Digite o Salario do funcionário: ");
		double salario = sc.nextDouble();
		
		System.out.print("Digite a data de contratação do funcionário (yyyy-mm-dd): ");
		String contratadoDesde = sc.next();
		
		System.out.print("Digite o login do supervisor do funcionário (se houver): ");
		String loginSupervisor = sc.next();		
		
		System.out.print("Digite qual cpf corresponde ao do funcionário");
		GetCPFPessoas();
		
		System.out.print("CPF: ");
		String cpf = sc.next();
		
		System.out.println("Digite a opção com o cargo do funcionário");
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
		
		System.out.print("Digite o Login do funcionário: ");
		String login = sc.nextLine();
		
		System.out.print("Digite a Senha do funcionário: ");
		String senha = sc.nextLine();
		
		System.out.print("Digite 's' se o funcionário está ativo e 'n' ele não estiver ativo: ");
		String ativo = sc.nextLine();
		
		Boolean isAtivo;
		if(ativo == "s")
			isAtivo = true;
		else
			isAtivo = false;
		
		System.out.print("Digite o Salario do funcionário: ");
		double salario = sc.nextDouble();
		
		System.out.print("Digite a data de contratação do funcionário (yyyy-mm-dd): ");
		String contratadoDesde = sc.next();
		java.sql.Date dtValue = java.sql.Date.valueOf(contratadoDesde);
				
		System.out.print("Digite o login do supervisor do funcionário (se houver): ");
		String loginSupervisor = sc.next();		
		sc.nextLine();
		
//		System.out.println("Digite qual cpf corresponde ao do funcionário");
//		GetCPFPessoas();
//		
//		System.out.print("CPF: ");
//		String cpf = sc.next();
		
		System.out.println("Digite a opção com o cargo do funcionário");
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
			validacao.append("Login é obrigatório. \n");
		
		if(isNullOrEmpty(f.getSenha()))
			validacao.append("Senha é obrigatório. \n");
		
		if(isNullOrEmpty(f.getContratadoDesde().toString()))
			validacao.append("Data de Contratação é obrigatório. \n");
		
		if(isNullOrEmpty(f.getPessoaCpf()))
			validacao.append("Pessoa CPF é obrigatório. \n");
		
		if(f.getCargoId() == 0)
			validacao.append("Cargo é obrigatório. \n");
		
		if(Get(f.getLogin()).getLogin() != null) {
			System.out.println(Get(f.getLogin()).getLogin());
			validacao.append("Já existe um funcionário cadastrado com esse login. \n");
		}
			
		
		if(isNullOrEmpty(f.getLoginSupervisor()) && (f.getCargoId() != 1 && f.getCargoId() != 2))
			validacao.append("Login do supervisor é obrigatório para esse cargo. \n");
		
		if(!isNullOrEmpty(f.getLoginSupervisor()) && (f.getCargoId() == 1 || f.getCargoId() == 2))
			validacao.append("O cargo selecionado não precisa de login supervisor. \n");
		
		for(Funcionario funcionario : funcionarios) {
			if(f.getPessoaCpf() == funcionario.getPessoaCpf())
				validacao.append("Já existe um funcionário cadastrado com esse cpf. \n");
		}		
		
		return validacao.toString();
		
	}
	
	
	
}
