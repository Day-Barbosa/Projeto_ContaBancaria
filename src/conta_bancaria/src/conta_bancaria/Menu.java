package conta_bancaria;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		
	Scanner leia = new Scanner (System.in);
	
	int Opcao;
	
	while (true) {
		
		System.out.println("****************************************");
		System.out.println("                                        ");
		System.out.println("                  BANCDAY               ");
		System.out.println("                                        ");
		System.out.println("****************************************");
		System.out.println("                                        ");
		System.out.println("Selecione a opção desejada              ");
		System.out.println("                                        ");
		System.out.println(" 1 - Criar Conta                        ");
		System.out.println(" 2 - Listar todas as contas             ");
		System.out.println(" 3 - Acessar conta por número           ");	
		System.out.println(" 4 - Atualizar dados da conta           ");	
		System.out.println(" 5 - Excluir conta                      ");	
		System.out.println(" 6 - Sacar                              ");	
		System.out.println(" 7 - Depositar                          ");	
		System.out.println(" 8 - Transferir entre contas            ");	
		System.out.println(" 0 - Sair                               ");	
		System.out.println("                                        ");
		System.out.println("****************************************");
		
		Opcao = leia.nextInt();
		
		if (Opcao == 0) {
			System.out.println("\nBANCDAY - O SEU FUTURO COMEÇA AQUI!");
			sobre();
			leia.close();
			System.exit(0);
			
			switch (Opcao) {
			case 1:
				System.out.println("Criar conta\n\n");
				
				break;
			case 2:
				System.out.println("Listar todas as contas\n\n");
				
				break;
			case 3:
				System.out.println("Acessar conta por número\n\n");
				
				break;
			case 4:
				System.out.println("Atualizar dados da conta\n\n");
				
				break;
			case 5:
				System.out.println("Excluir conta\n\n");
				
				break;
			case 6:
				System.out.println("Saque\n\n");
				
				break;
			case 7:
				System.out.println("Depósito\n\n");
				
				break;
			case 8:
				System.out.println("Transferência entre contas\n\n");
			
				break;
			default:
					System.out.println ("\nOpção inválida\n");
			break;
			}
	}
	}
}

	private static void sobre() {
		System.out.println ("\n*********************************************************");
		System.out.println (" Projeto Desenvolvido por:                                 ");
		System.out.println (" Dayana Barbosa  -  day_sbarbosa@hotmail.com               ");
		System.out.println (" nhttps://github.com/Day-Barbosa/Projeto_Conta_Bancaria    ");
		System.out.println ("\n*********************************************************");
	}
}