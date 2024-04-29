package hotelJava;

import java.util.Scanner;


public class Aplicacao {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String []args) {
		
		Hotel hotel = new Hotel("Boa Vista",10);

		int chave;
		do {
			
		chave = menuPrincipal(hotel,sc);
		
		} while (chave != 4);
	}

	// Função que controla as funcionalidades do programa
	public static int menuPrincipal(Hotel hotel, Scanner sc) {
		System.out.println("Seja bem vindo ao nosso sistema de reserva para hotel!");
		System.out.println("Escolha uma opcao:\n ");
		System.out.println("[1] - Ver Quartos Disponiveis");
		System.out.println("[2] - Fazer Check-in");
		System.out.println("[3] - Fazer Check-out");
		System.out.println("[4] - Sair");
		int opcao = sc.nextInt();
	
		switch (opcao) {
		
		case 1:
		limparTela();
		Hotel.verQuartos(hotel);
		break;
			
		case 2:
		limparTela();
		System.out.println("Digite o número do quarto que deseja fazer Check-In: ");
		int numCheckIn = sc.nextInt();
		Hotel.checkIn(hotel,numCheckIn);
		break;
			
		case 3:
		limparTela();
		System.out.println("Digite o número do quarto que deseja fazer CheckOut: ");
		int numCheckOut = sc.nextInt();
		Hotel.checkOut(hotel,numCheckOut);
		break;
			
		case 4:
		limparTela();
		System.out.println("Obrigado por utilizar nosso programa!");
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