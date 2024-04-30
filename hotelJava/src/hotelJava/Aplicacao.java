package hotelJava;

import java.util.Scanner;

import entidades.Cliente;

public class Aplicacao {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String []args) {
		Scanner input = new Scanner(System.in);
        Cliente[] arrayClientes = new Cliente[1];
		
		int quantidadeClientes = 0;

		Hotel hotel = new Hotel("Boa Vista",10);
		
		int opcao = 0;
        do {
            //limparTela(); + um pause.
            System.out.println("Menu:");
            System.out.println("1. Criar nova conta");
            System.out.println("2. Fazer login");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opção >> ");

            opcao = input.nextInt();
            switch (opcao) {
            case 0:
            limparTela();
            System.out.println("Encerrando...");
            break;

            case 1:
            limparTela();
            arrayClientes = Cliente.cadastrarUsuario(arrayClientes, quantidadeClientes);
            quantidadeClientes++;
            break;

            case 2:
            limparTela();
            Cliente login = new Cliente();
            login = Cliente.realizarLogin(arrayClientes);
            if (login != null){
				limparTela();

				int chave;
				do {
				chave = menuPrincipal(hotel,sc,login);
				} while (chave != 5);
            }
            break;

            default:
            limparTela();
            System.out.println("Opção inválida.");
            break;

            }
        } while (opcao != 0);
        input.close();
	}

	// Função que controla as funcionalidades do HOTEL
	public static int menuPrincipal(Hotel hotel, Scanner sc, Cliente login) {
		System.out.println("Seja bem vindo ao nosso sistema de reserva para hotel!");
		System.out.println("Escolha uma opcao:\n ");
		System.out.println("[1] - Ver Quartos Disponiveis");
		System.out.println("[2] - Fazer Check-in");
		System.out.println("[3] - Fazer Check-out");
		System.out.println("[4] - Ver Perfil");
		System.out.println("[5] - Sair");
		int opcao = sc.nextInt();
	
		switch (opcao) {
		
		case 1:
		limparTela();
		Hotel.verQuartos(hotel);
		break;
			
		case 2:
		limparTela();
		if(!Cliente.verificarQuartoAlugado(login)) {
		System.out.println("Digite o número do quarto que deseja fazer Check-In: ");
		int numCheckIn = sc.nextInt();
		Hotel.checkIn(hotel, numCheckIn, login);
		}
		else {
			System.out.println("Você ja possui um quarto alugado!");
		}
		break;
			
		case 3:
		limparTela();
		Hotel.checkOut(hotel, login);
		break;
		
		case 4:
		limparTela();
		System.out.println(login.toString());
		break;
			
		case 5:
		limparTela();
		System.out.println("Obrigado por utilizar nosso programa!");
		login.deslogar();
		break;
			
		default:
		limparTela();
		System.out.println("Digite uma opcao valida: ");
		break;
			
		}
		
		return opcao;
		
		}
	
	private static void limparTela(){
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}