import java.util.Scanner;

import Views.Menu;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);  
    	
       	short opcao = 50;		
		do{
	    	Menu.Principal();
	    	System.out.print("Digite o n�mero com a op��o que deseja realizar: ");
			opcao = sc.nextShort();
			
			switch(opcao){
				case 1:
					System.out.println("Op��o de CRUD de Endere�os escolhida!");
					Menu.ControleEndereco();
					break;
				case 2:
					System.out.println("Op��o de CRUD de Funcion�rios escolhida!");				
					Menu.ControleFuncionario();
					break;	
				case 3:
					System.out.println("Op��o de CRUD de Pessoas escolhida!");							
					Menu.ControlePessoa();
					break;
				case 50:
			    	Menu.Principal();
					break;
				default:
			}
		}while(opcao != 0);    
    	
    	
    	
    
    }
}