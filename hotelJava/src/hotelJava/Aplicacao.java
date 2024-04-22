package hotelJava;

import java.util.Scanner;

public class Aplicacao {
	
	public static int menuPrincipal() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Seja bem vindo ao nosso sistema de reserva para hotel!");
		System.out.println("Escolha uma opcao: ");
		System.out.println(" ");
		System.out.println("[1] - Reservar Quarto");
		System.out.println("[2] - Ver Quartos Disponiveis");
		System.out.println("[3] - Fazer Check-in");
		System.out.println("[4] - Fazer Check-out");
		System.out.println("[5] - Sair");
		int opcao = sc.nextInt();
		
		while(opcao<1 || opcao>5) {
			System.out.println("Digite uma opcao valida: ");
			opcao = sc.nextInt();
		}
		sc.close();
		return opcao;
		
	
	}
	
	public static void main(String []args) {
		do {
			menuPrincipal();
			
		} while(menuPrincipal() != 5);
	}
}
