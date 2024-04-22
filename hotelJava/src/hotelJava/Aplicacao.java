package hotelJava;

import java.util.Scanner;

public class Aplicacao {
	
	//Função para reservar quarto (Falta fazer a verificacao da data que ele tá pedindo)
	
	public static boolean reservarQuarto(Hotel hotel, int numeroQuarto) {
	    Quarto[] quartos = hotel.getQuartos();

	    if (numeroQuarto >= 0 && numeroQuarto < quartos.length) {
	        Quarto quartoSelecionado = quartos[numeroQuarto];

	        if (quartoSelecionado.isDisponivel()) {
	            quartoSelecionado.setDisponivel(false); // Atualiza a disponibilidade do quarto
	            return true;
	        }
	        
	        else {
	            System.out.println("Quarto não está disponível para reserva.");
	        }
	        
	    }
	    else {
	        System.out.println("Número de quarto inválido.");
	    }

	    return false;
	}
	
	public static void verQuartos(Hotel hotel) {
		hotel.verificarDisponiveis();
		
	}

	
	// Função que controla as funcionalidades do programa
	
	public static int menuPrincipal(Hotel hotel) {
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
		
		
		switch (opcao) {
		case 1:
			int numQuarto;
			
			System.out.println("Informe o numero do quarto que deseja alugar: ");
			
			numQuarto = sc.nextInt();
			
			if(reservarQuarto(hotel,numQuarto)) {
				System.out.println("Quarto reservado com sucesso!");
			}
			
			break;
			
		case 2:
			verQuartos(hotel);
			break;
			
		default:
			break;
		}
		
		
		sc.close();
		return opcao;
		
	
	}
	
	public static void main(String []args) {
		
		Hotel hotel = new Hotel();
		do {
			menuPrincipal(hotel);
			
		} while(menuPrincipal(hotel) != 5);
	}
}
