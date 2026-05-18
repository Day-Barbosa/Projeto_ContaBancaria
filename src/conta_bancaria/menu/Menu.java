package conta_bancaria.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		int opcao;

		while (true) {

			exibirMenu();

			try {
				opcao = leia.nextInt();

			} catch (InputMismatchException erro) {
				System.out.println("\nEntrada inválida! Digite apenas números.\n");
				leia.nextLine(); // Limpa a entrada inválida do Scanner
				continue; // Volta para o início do menu
			}

			if (opcao == 0) {
				System.out.println("\nBANCDAY - O SEU FUTURO COMEÇA AQUI!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("\nCriar conta\n");
				break;

			case 2:
				System.out.println("\nListar todas as contas\n");
				break;

			case 3:
				System.out.println("\nAcessar conta por número\n");
				break;

			case 4:
				System.out.println("\nAtualizar dados da conta\n");
				break;

			case 5:
				System.out.println("\nExcluir conta\n");
				break;

			case 6:
				System.out.println("\nSaque\n");
				break;

			case 7:
				System.out.println("\nDepósito\n");
				break;

			case 8:
				System.out.println("\nTransferência entre contas\n");
				break;

			default:
				System.out.println("\nOpção inválida! Escolha uma opção entre 0 e 8.\n");
				break;
			}
		}
	}

	private static void exibirMenu() {
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
		System.out.print("Digite uma opção: ");
	}

	private static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println(" Projeto Desenvolvido por:                              ");
		System.out.println(" Dayana Barbosa - day_sbarbosa@hotmail.com              ");
		System.out.println(" GitHub: https://github.com/Day-Barbosa/Projeto_ContaBancaria");
		System.out.println("*********************************************************");
	}
}