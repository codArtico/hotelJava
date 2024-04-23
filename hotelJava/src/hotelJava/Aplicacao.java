package hotelJava;

import java.util.Scanner;

public class Aplicacao {
	// Pedir data de hoje para operações
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
		System.out.println(" ");
		System.out.println(" ");
	}
	
	public static void checkIn(Hotel hotel, int numeroQuarto) {
		
		// Lembrar de pedir data do check-in
		Quarto[] quartos = hotel.getQuartos();

	    if (numeroQuarto >= 0 && numeroQuarto < quartos.length) {
	        Quarto quartoSelecionado = quartos[numeroQuarto];

	        if (!quartoSelecionado.isCheck() && !quartoSelecionado.isDisponivel()) {
	            quartoSelecionado.setCheck(true); // Fazer o check in
	            // Colocar função para check - in só ser valido data de entrada e data de saida
	            System.out.println("Check-in Realizado!");
	        }
	        
	        else if (quartoSelecionado.isCheck() && !quartoSelecionado.isDisponivel()) {
	            System.out.println("Quarto já tem gente!");
	        }
	        
	        else {
	        	System.out.println("Quarto não tem reserva agendada!");
	        }
	        
	    }
	    else {
	        System.out.println("Número de quarto inválido.");
	    }
	}
	
	public static void checkOut(Hotel hotel, int numeroQuarto) {
		Quarto[] quartos = hotel.getQuartos();

	    if (numeroQuarto >= 0 && numeroQuarto < quartos.length) {
	        Quarto quartoSelecionado = quartos[numeroQuarto];

	        if (quartoSelecionado.isCheck()) {
	            quartoSelecionado.setCheck(false); // Indica que não há ninguém no quarto;
	            quartoSelecionado.setDisponivel(true); // Deixa o quarto disponível
	            System.out.println("Quarto liberado!");
	        }
	        
	        else {
	            System.out.println("Quarto não tinha ninguém!");
	        }
	        
	    }
	    else {
	        System.out.println("Número de quarto inválido.");
	    }
	}

	// Função que controla as funcionalidades do programa
	
	public static int menuPrincipal(Hotel hotel, Scanner sc) {
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
			
		case 3:
			int numCheckIn;
			System.out.println("Digite o número do quarto que deseja fazer Check-In: ");
			numCheckIn = sc.nextInt();
			checkIn(hotel,numCheckIn);
			break;
			
		case 4:
			int numCheckOut;
			System.out.println("Digite o número do quarto que deseja fazer CheckOut: ");
			numCheckOut = sc.nextInt();
			checkOut(hotel,numCheckOut);
			break;
			
		case 5:
			System.out.println("Obrigado por utilizar nosso programa!");
			break;
			
		default:
			break;
			
		}

		return opcao;
		
	
	}
	
	public static void main(String []args) {
		
		Hotel hotel = new Hotel("Boa Vista",10);
		int chave;
		Scanner sc = new Scanner(System.in);
		do {
			
		chave = menuPrincipal(hotel,sc);
		
		} while (chave != 5);
	}
}
