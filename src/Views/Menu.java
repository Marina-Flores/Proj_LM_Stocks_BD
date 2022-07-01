package Views;

import java.util.Scanner;

import Models.EnderecoModel;
import Models.FuncionarioModel;
import Models.PessoaModel;

public class Menu {
	public static void Principal() {
		StringBuilder opcoes = new StringBuilder();		
		opcoes.append("+-----------------------------+").append('\n');
		opcoes.append("        Menu de Opções         ").append('\n');
		opcoes.append("-------------------------------").append('\n');
		opcoes.append(" 1 - Controle de Endereços     ").append('\n');
		opcoes.append(" 2 - Controle de Funcionários  ").append('\n');
		opcoes.append(" 3 - Controle de Pessoas		  ").append('\n');
		opcoes.append(" 0 - Sair            		  ").append('\n');
		opcoes.append("-------------------------------").append('\n');
		
		System.out.println(opcoes.toString());		
	}	
	
	 public static void ControleEndereco() {
	    	Scanner sc = new Scanner(System.in);

			StringBuilder opcoes = new StringBuilder();		
			opcoes.append("+-----------------------------------+").append('\n');
			opcoes.append("          Menu de Opções        		").append('\n');
			opcoes.append("-------------------------------------").append('\n');
			opcoes.append(" 1 - Adicionar Endereço     	 		").append('\n');
			opcoes.append(" 2 - Atualizar Endereço  	  		").append('\n');
			opcoes.append(" 3 - Remover Endereço		  		").append('\n');
			opcoes.append(" 4 - Listar Endereço		      		").append('\n');
			opcoes.append(" 0 - Sair do Controle de Endereços	").append('\n');
			opcoes.append("-------------------------------------").append('\n');		
			
			short opcao = 50;		
			do{
				System.out.println(opcoes.toString());		
		    	System.out.print("Digite o número com a opção que deseja realizar: ");
				opcao = sc.nextShort();
				int id;
				switch(opcao){
					case 1:
						System.out.println("Opção de adicionar endereço escolhida!");	
						EnderecoModel.Insert();
						break;
					case 2:
						System.out.println("Opção de atualizar endereço escolhida!");
						EnderecoModel.GetAll();
						System.out.print("Digite o número do endereço que deseja atualizar: ");
						id = sc.nextInt();
						EnderecoModel.Update(String.valueOf(id));	
						EnderecoModel.Get(String.valueOf(id));
						break;	
					case 3:
						System.out.println("Opção de remover endereço escolhida!");							
						EnderecoModel.GetAll();
						System.out.print("Digite o número do endereço que deseja remover: ");
						id = sc.nextInt();
						EnderecoModel.Remover(String.valueOf(id));
						System.out.println("Endereço removido!");
						break;
					case 4:
						System.out.println("Opção de Listar endereços escolhida!");							
						EnderecoModel.GetAll();
						break;
					case 50:
						System.out.println(opcoes.toString());		
						break;
					case 0:
						Menu.Principal();
						break;
					default:
						Menu.Principal();
						break;
				}
			}while(opcao != 0); 
	 }
	 
	 public static void ControleFuncionario() {
	    	Scanner sc = new Scanner(System.in);

			StringBuilder opcoes = new StringBuilder();		
			opcoes.append("+-----------------------------------+").append('\n');
			opcoes.append("          Menu de Opções        		").append('\n');
			opcoes.append("-------------------------------------").append('\n');
			opcoes.append(" 1 - Adicionar Funcionário     	 	").append('\n');
			opcoes.append(" 2 - Atualizar Funcionário  	  		").append('\n');
			opcoes.append(" 3 - Remover Funcionário		  		").append('\n');
			opcoes.append(" 4 - Listar Funcionário		      	").append('\n');
			opcoes.append(" 0 - Sair do Controle de Funcionário	").append('\n');
			opcoes.append("-------------------------------------").append('\n');		
			
			short opcao = 50;		
			do{
				System.out.println(opcoes.toString());		
		    	System.out.print("Digite o número com a opção que deseja realizar: ");
				opcao = sc.nextShort();
				String login;
				switch(opcao){
					case 1:
						System.out.println("Opção de adicionar funcionário escolhida!");	
						FuncionarioModel.Insert();
						break;
					case 2:
						System.out.println("Opção de atualizar funcionário escolhida!");
						FuncionarioModel.GetAll();
						System.out.print("Digite o login do funcionário que deseja atualizar: ");
						login = sc.next();
						FuncionarioModel.Update(login);	
						FuncionarioModel.Get(login);
						break;	
					case 3:
						System.out.println("Opção de remover funcionário escolhida!");							
						FuncionarioModel.GetAll();
						System.out.print("Digite o login do funcionário que deseja remover: ");
						login = sc.next();
						FuncionarioModel.Remover(login);
						System.out.println("Funcionário removido!");
						break;
					case 4:
						System.out.println("Opção de Listar funcionário escolhida!");							
						FuncionarioModel.GetAll();
						break;
					case 50:
						System.out.println(opcoes.toString());		
						break;
					case 0:
						Menu.Principal();
						break;
					default:
						Menu.Principal();
						break;
				}
			}while(opcao != 0); 
		}
	 
	 public static void ControlePessoa() {
	    	Scanner sc = new Scanner(System.in);

			StringBuilder opcoes = new StringBuilder();		
			opcoes.append("+-----------------------------------+").append('\n');
			opcoes.append("          Menu de Opções        		").append('\n');
			opcoes.append("-------------------------------------").append('\n');
			opcoes.append(" 1 - Adicionar Pessoa     	 		").append('\n');
			opcoes.append(" 2 - Atualizar Pessoa	  	  		").append('\n');
			opcoes.append(" 3 - Remover Pessoa			  		").append('\n');
			opcoes.append(" 4 - Listar Pessoas		      		").append('\n');
			opcoes.append(" 0 - Sair do Controle de Pessoas		").append('\n');
			opcoes.append("-------------------------------------").append('\n');		
			
			short opcao = 50;		
			do{
				System.out.println(opcoes.toString());		
		    	System.out.print("Digite o número com a opção que deseja realizar: ");
				opcao = sc.nextShort();
				
				switch(opcao){
					case 1:
						System.out.println("Opção de adicionar pessoa escolhida!");	
						PessoaModel.Insert();
						break;
					case 2:
						System.out.println("Opção de atualizar pessoa escolhida!");
						PessoaModel.GetAll();
						System.out.print("Digite o cpf da pessoa que deseja atualizar: ");
						String identificador = sc.next();
						PessoaModel.Update(identificador);
						break;	
					case 3:
						System.out.println("Opção de remover pessoa escolhida!");							
						PessoaModel.GetAll();
						System.out.println("Digite o cpf da pessoa escolhida: ");
						var cpf = sc.next();
						PessoaModel.Delete(cpf);
						break;
					case 4:
						System.out.println("Opção de Listar pessoas escolhida!");							
						PessoaModel.GetAll();
						break;
					case 50:
						System.out.println(opcoes.toString());		
						break;
					case 0:
						Menu.Principal();
						break;
					default:
						Menu.Principal();
						break;
				}
			}while(opcao != 0); 
		}
}
