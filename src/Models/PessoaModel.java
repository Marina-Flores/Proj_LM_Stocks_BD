package Models;


import java.util.ArrayList;
import java.util.Scanner;

import Entities.Pessoa;
import Repositories.FuncionarioRepository;
import Repositories.PessoaRepository;

public class PessoaModel {
	
	public static PessoaRepository _pessoaRepository = new PessoaRepository();
	public static FuncionarioRepository _funcionarioRepository = new FuncionarioRepository();

	public static Boolean isNullOrEmpty(String s) {
		return s == null || s.isEmpty();
	}
	
	public static void Insert() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o nome da pessoa: ");
		String nome = sc.nextLine();
		System.out.println("Digite o CPF da pessoa: ");
		String cpf = sc.nextLine();
		System.out.println("Digite a data de nascimento da pessoa: ");
		String dataNascimento = sc.nextLine();
		System.out.println("Escolha o endereço da pessoa: ");
		EnderecoModel.GetAll();
		System.out.println("Digite o número do endereço desejado: ");
		int enderecoid = sc.nextInt();
		
		java.sql.Date dtValue = java.sql.Date.valueOf(dataNascimento);
		
		Pessoa p = new Pessoa(cpf, nome, dtValue, enderecoid);
		
		System.out.print(dtValue);
		
		if(isNullOrEmpty(PessoaValida(p)))
			_pessoaRepository.Insert(p);
		else
			System.out.println(PessoaValida(p));       
	}
	
	public static void GetAll() {
		ArrayList<Pessoa> pessoas = (ArrayList<Pessoa>) _pessoaRepository.GetAll();
		int contador = 1;
		
		for(Pessoa p : pessoas) {
			System.out.println(contador+" - "+p.getNome() + ", " + p.getCpf());
			contador++;
		}
	}
	
	public static Pessoa Get(String identificador) {
		Pessoa p = _pessoaRepository.Get(identificador);
		return p;
	}

	public static void Update(String identificador) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o nome da pessoa: ");
		String nome = sc.nextLine();		
		System.out.println("Digite a data de nascimento da pessoa: ");
		String dataNascimento = sc.nextLine();
		System.out.println("Escolha o endereço da pessoa: ");
		EnderecoModel.GetAll();
		System.out.println("Digite o número do endereço desejado: ");
		int enderecoid = sc.nextInt();
		
		java.sql.Date dtValue = java.sql.Date.valueOf(dataNascimento);

		Pessoa p = new Pessoa(identificador, nome, dtValue, enderecoid);
		
			_pessoaRepository.Update(p, identificador);
     
	}
	
	public static void Delete(String identificador) {
		Scanner sc = new Scanner(System.in);

		if(_funcionarioRepository.GetByCPF(identificador).getLogin() == null) {
			_pessoaRepository.Remove(identificador);
			System.out.println("Pessoa removida com sucesso!");
		}
		else {
			System.out.println("Existem funcionários dependendo desse registro. Deseja continuar a operação?");
			System.out.print("Digite 1 para continuar e 0 para cancelar a exclusão: ");
			int op = sc.nextInt();
			
			if(op == 0) {
				System.out.println("Operação cancelada!");
			}
			else if(op == 1) {
				_pessoaRepository.Remove(identificador);
				System.out.println("Pessoa removida com sucesso!");
			}
			else {
				System.out.println("Valor inválido. Tente novamente.");
			}
		}		
	}
	
	public static String PessoaValida(Pessoa p) {
		StringBuilder validacao = new StringBuilder();
		
		if(Get(p.getCpf()).getCpf() != null)
			validacao.append("Já existe uma pessoa com esse cpf cadastrada. \n");
		
		if(isNullOrEmpty(p.getNome()))
			validacao.append("Nome é obrigatório. \n");
		
		if(isNullOrEmpty(p.getCpf()))
			validacao.append("CPF é obrigatório. \n");
		
		if(isNullOrEmpty(p.getDataNascimento().toString()))
			validacao.append("Data de Nascimento é obrigatório. \n");
		
		if(p.getEnderecoId() == 0)
			validacao.append("Endereço é obrigatório. \n");
		
		return validacao.toString();
		
	}
}
