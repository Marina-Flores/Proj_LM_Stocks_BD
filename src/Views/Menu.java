package Views;

import java.util.Scanner;

import Models.EnderecoModel;
import Models.FuncionarioModel;
import Models.PessoaModel;

public class Menu {
	public static void Principal() {
		StringBuilder opcoes = new StringBuilder();		
		opcoes.append("+-----------------------------+").append('\n');
		opcoes.append("        Menu de Op��es         ").append('\n');
		opcoes.append("-------------------------------").append('\n');
		opcoes.append(" 1 - Controle de Endere�os     ").append('\n');
		opcoes.append(" 2 - Controle de Funcion�rios  ").append('\n');
		opcoes.append(" 3 - Controle de Pessoas		  ").append('\n');
		opcoes.append(" 0 - Sair            		  ").append('\n');
		opcoes.append("-------------------------------").append('\n');
		
		System.out.println(opcoes.toString());		
	}	
	
	 public static void ControleEndereco() {
	    	Scanner sc = new Scanner(System.in);

			StringBuilder opcoes = new StringBuilder();		
			opcoes.append("+-----------------------------------+").append('\n');
			opcoes.append("          Menu de Op��es        		").append('\n');
			opcoes.append("-------------------------------------").append('\n');
			opcoes.append(" 1 - Adicionar Endere�o     	 		").append('\n');
			opcoes.append(" 2 - Atualizar Endere�o  	  		").append('\n');
			opcoes.append(" 3 - Remover Endere�o		  		").append('\n');
			opcoes.append(" 4 - Listar Endere�o		      		").append('\n');
			opcoes.append(" 0 - Sair do Controle de Endere�os	").append('\n');
			opcoes.append("-------------------------------------").append('\n');		
			
			short opcao = 50;		
			do{
				System.out.println(opcoes.toString());		
		    	System.out.print("Digite o n�mero com a op��o que deseja realizar: ");
				opcao = sc.nextShort();
				int id;
				switch(opcao){
					case 1:
						System.out.println("Op��o de adicionar endere�o escolhida!");	
						EnderecoModel.Insert();
						break;
					case 2:
						System.out.println("Op��o de atualizar endere�o escolhida!");
						EnderecoModel.GetAll();
						System.out.print("Digite o n�mero do endere�o que deseja atualizar: ");
						id = sc.nextInt();
						EnderecoModel.Update(String.valueOf(id));	
						EnderecoModel.Get(String.valueOf(id));
						break;	
					case 3:
						System.out.println("Op��o de remover endere�o escolhida!");							
						EnderecoModel.GetAll();
						System.out.print("Digite o n�mero do endere�o que deseja remover: ");
						id = sc.nextInt();
						EnderecoModel.Remover(String.valueOf(id));
						System.out.println("Endere�o removido!");
						break;
					case 4:
						System.out.println("Op��o de Listar endere�os escolhida!");							
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
			opcoes.append("          Menu de Op��es        		").append('\n');
			opcoes.append("-------------------------------------").append('\n');
			opcoes.append(" 1 - Adicionar Funcion�rio     	 	").append('\n');
			opcoes.append(" 2 - Atualizar Funcion�rio  	  		").append('\n');
			opcoes.append(" 3 - Remover Funcion�rio		  		").append('\n');
			opcoes.append(" 4 - Listar Funcion�rio		      	").append('\n');
			opcoes.append(" 0 - Sair do Controle de Funcion�rio	").append('\n');
			opcoes.append("-------------------------------------").append('\n');		
			
			short opcao = 50;		
			do{
				System.out.println(opcoes.toString());		
		    	System.out.print("Digite o n�mero com a op��o que deseja realizar: ");
				opcao = sc.nextShort();
				String login;
				switch(opcao){
					case 1:
						System.out.println("Op��o de adicionar funcion�rio escolhida!");	
						FuncionarioModel.Insert();
						break;
					case 2:
						System.out.println("Op��o de atualizar funcion�rio escolhida!");
						FuncionarioModel.GetAll();
						System.out.print("Digite o login do funcion�rio que deseja atualizar: ");
						login = sc.next();
						FuncionarioModel.Update(login);	
						FuncionarioModel.Get(login);
						break;	
					case 3:
						System.out.println("Op��o de remover funcion�rio escolhida!");							
						FuncionarioModel.GetAll();
						System.out.print("Digite o login do funcion�rio que deseja remover: ");
						login = sc.next();
						FuncionarioModel.Remover(login);
						System.out.println("Funcion�rio removido!");
						break;
					case 4:
						System.out.println("Op��o de Listar funcion�rio escolhida!");							
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
			opcoes.append("          Menu de Op��es        		").append('\n');
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
		    	System.out.print("Digite o n�mero com a op��o que deseja realizar: ");
				opcao = sc.nextShort();
				
				switch(opcao){
					case 1:
						System.out.println("Op��o de adicionar pessoa escolhida!");	
						PessoaModel.Insert();
						break;
					case 2:
						System.out.println("Op��o de atualizar pessoa escolhida!");
						PessoaModel.GetAll();
						System.out.print("Digite o cpf da pessoa que deseja atualizar: ");
						String identificador = sc.next();
						PessoaModel.Update(identificador);
						break;	
					case 3:
						System.out.println("Op��o de remover pessoa escolhida!");							
						PessoaModel.GetAll();
						System.out.println("Digite o cpf da pessoa escolhida: ");
						var cpf = sc.next();
						PessoaModel.Delete(cpf);
						break;
					case 4:
						System.out.println("Op��o de Listar pessoas escolhida!");							
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
