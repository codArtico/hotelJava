package hotelJava;

import java.util.Scanner;

public class Hotel {
	private String nome;
	private Quarto[] quartos;
	
	Hotel(){}
	
	Hotel(String nome, int quantQuartos){
		this.nome = nome;
		this.quartos = new Quarto[quantQuartos];
		for (int i =0; i<quantQuartos; i++) {
			quartos[i] = new Quarto(i,true,false);
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Quarto[] getQuartos() {
		return quartos;
	}

	public void setQuartos(Quarto[] quartos) {
		this.quartos = quartos;
	}

	public void verificarDisponiveis() {
		boolean chave = false;
		for (int i = 0; i<quartos.length; i++) {
			
			if(quartos[i].isDisponivel()) {
				chave = true;
				System.out.print(" • " + quartos[i].getNumQuarto() + " • ");
			}
			
		}
		
		if (!chave) {
			System.out.println("Não há quartos disponiveis neste hotel!");
		}
	}

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

	public static int menuPrincipal(Hotel hotel, Scanner sc) {
		
		System.out.println("Seja bem vindo ao nosso sistema de reserva para hotel!");
		System.out.println("Escolha uma opcao: ");
		System.out.println(" ");
		System.out.println("[1] - Reservar Quarto");
		System.out.println("[2] - Ver Quartos Disponiveis");
		System.out.println("[3] - Fazer Check-in");
		System.out.println("[4] - Fazer Check-out");
		System.out.println("[0] - Sair");
		
		int opcao = sc.nextInt();
		
		switch (opcao) {
		case 1:
			System.out.println("Informe o numero do quarto que deseja alugar: ");
			int numQuarto = sc.nextInt();
			if(Hotel.reservarQuarto(hotel,numQuarto)) {
				System.out.println("Quarto reservado com sucesso!");
			}
			break;

		case 2:
			Hotel.verQuartos(hotel);
			break;
			
		case 3:
			System.out.println("Digite o número do quarto que deseja fazer Check-In: ");
			int numCheckIn = sc.nextInt();
			Hotel.checkIn(hotel,numCheckIn);
			break;
			
		case 4:
			System.out.println("Digite o número do quarto que deseja fazer CheckOut: ");
			int numCheckOut = sc.nextInt();
			Hotel.checkOut(hotel,numCheckOut);
			break;
			
		case 0:
			System.out.println("Encerrando...\nObrigado por utilizar nosso programa!");
			break;
			
		default:
			System.out.println("Digite uma opcao valida: ");
			break;
		}

		return opcao;
	}

}
