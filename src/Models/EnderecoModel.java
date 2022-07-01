package Models;

import java.util.ArrayList;
import java.util.Scanner;
import Entities.Endereco;
import Repositories.EnderecoRepository;
import Repositories.PessoaRepository;

public class EnderecoModel {
	private static EnderecoRepository _enderecoRepository = new EnderecoRepository();
	private static PessoaRepository _pessoaRepository = new PessoaRepository();

	public static Boolean isNullOrEmpty(String s) {
		return s == null || s.isEmpty();
	}
	
	public static Endereco Insert() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite o Estado (UF) do endere�o: ");
		String estado = sc.nextLine();
		System.out.print("Digite a Cidade do endere�o: ");
		String cidade = sc.nextLine();
		System.out.print("Digite o Bairro do endere�o: ");
		String bairro = sc.nextLine();
		System.out.print("Digite o Logradouro do endere�o: ");
		String rua = sc.nextLine();
		System.out.print("Digite o N�mero do endere�o: ");
		int numero = sc.nextInt();
		System.out.print("Digite o CEP do endere�o: ");
		String cep = sc.next();		
		
		Endereco e = new Endereco(estado, cidade, bairro, rua, numero, cep);
		if(isNullOrEmpty(EnderecoValido(e)))
			_enderecoRepository.Insert(e);
		else
			System.out.println(EnderecoValido(e));

		return e;		
	}
	
	public static void GetAll() {
		ArrayList<Endereco> lista = (ArrayList<Endereco>) _enderecoRepository.GetAll();
		for(Endereco e : lista) {
			System.out.println(e.getId()+ " - " + e);
		}
	}
	
	public static Endereco Update(String identificador) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite o Estado (UF) do endere�o: ");
		String estado = sc.nextLine();
		System.out.print("Digite a Cidade do endere�o: ");
		String cidade = sc.nextLine();
		System.out.print("Digite o Bairro do endere�o: ");
		String bairro = sc.nextLine();
		System.out.print("Digite o Logradouro do endere�o: ");
		String rua = sc.nextLine();
		System.out.print("Digite o N�mero do endere�o: ");
		int numero = sc.nextInt();
		System.out.print("Digite o CEP do endere�o: ");
		String cep = sc.next();		
		
		Endereco e = new Endereco(estado, cidade, bairro, rua, numero, cep);
		
		if(isNullOrEmpty(EnderecoValido(e)))
			_enderecoRepository.Update(e, identificador);
		else
			System.out.println(EnderecoValido(e));
		
		return e;		
	}
	
	public static Endereco Get(String identificador) {
		Endereco e = new Endereco();
		e = _enderecoRepository.Get(identificador);		
		return e;
	}
	
	public static void Remover(String identificador) {
		Scanner sc = new Scanner(System.in);
		
		if(_pessoaRepository.GetByEndereco(identificador).getCpf() == null) {
			_enderecoRepository.Remove(identificador);
			System.out.println("Endere�o removido com sucesso!");
		}
		else {
			System.out.println("Existem pessoas dependendo desse registro. Deseja continuar a opera��o?");
			System.out.print("Digite 1 para continuar e 0 para cancelar a exclus�o: ");
			int op = sc.nextInt();
			
			if(op == 0) {
				System.out.println("Opera��o cancelada!");
			}
			else if(op == 1) {
				_enderecoRepository.Remove(identificador);
				System.out.println("Endere�o removido com sucesso!");
			}
			else {
				System.out.println("Valor inv�lido. Tente novamente.");
			}
		}		
	}
	
	public static String EnderecoValido(Endereco e) {
		StringBuilder validacao = new StringBuilder();
		
		if(isNullOrEmpty(e.getEstado()))
			validacao.append("Estado � obrigat�rio. \n");
		if(isNullOrEmpty(e.getCidade()))
			validacao.append("Cidade � obrigat�ria. \n");
		if(isNullOrEmpty(e.getBairro()))
			validacao.append("Bairro � obrigat�rio. \n");
		if(isNullOrEmpty(e.getLogradouro()))
			validacao.append("Logradouro � obrigat�rio. \n ");
		if(isNullOrEmpty(e.getCep()))
			validacao.append("CEP � obrigat�rio. \n");		
		
		return validacao.toString();
		
	}
}




