package hotelJava;

import java.util.Scanner;
import java.time.temporal.ChronoUnit;
import util.Data;

public class Aplicacao {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String []args) {
		
		Hotel hotel = new Hotel("Boa Vista",10);
		int chave;
		do {
			
		chave = menuPrincipal(hotel,sc);
		
		} while (chave != 5);
	}

	public static Data coletarData() {
		System.out.print("Digite a data no formato dd/mm/aaaa: ");
		sc.nextLine();
		String dataInput = sc.nextLine();
		
		String[] partesData = dataInput.split("/");

        int dia = Integer.parseInt(partesData[0]);
        int mes = Integer.parseInt(partesData[1]);
        int ano = Integer.parseInt(partesData[2]);
        
        Data data = new Data(dia,mes,ano);
        return data;
	}
	
	public static long calcularDias (Data dataIni, Data dataFin) {
		long diferencaEmDias = ChronoUnit.DAYS.between(dataIni.getData(), dataFin.getData());
		return diferencaEmDias;
	}

	public static void verQuartos(Hotel hotel) {
		hotel.verificarDisponiveis();
		System.out.println(" ");
		System.out.println(" ");
	}

	public static void checkIn(Hotel hotel, int numeroQuarto) {
		Quarto[] quartos = hotel.getQuartos();
	
		if (numeroQuarto >= 0 && numeroQuarto < quartos.length) {
			Quarto quartoSelecionado = quartos[numeroQuarto];
		
			if (quartoSelecionado.isDisponivel()) {
				quartoSelecionado.setDataCheckIn(coletarData());
				quartoSelecionado.setDisponivel(false);
				System.out.println("Check-in Realizado!");
			}
		
			else {
				System.out.println("Quarto já tem gente!");
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
			
			if (!quartoSelecionado.isDisponivel()) {
				quartoSelecionado.setDataCheckOut(coletarData());
				quartoSelecionado.setDisponivel(true); // Deixa o quarto disponível
				long diaria = calcularDias(quartoSelecionado.getDataCheckIn(), quartoSelecionado.getDataCheckOut());
				System.out.printf("Você ficou %d dias hospedado! %n" , diaria);
				System.out.println("Quarto liberado!");
				System.out.printf("A sua despesa é de R$ %.2f! %n" , 20); //alterar o valor depois
				System.out.println("Volte sempre!");
				System.out.println();
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
		System.out.println("[1] - Ver Quartos Disponiveis");
		System.out.println("[2] - Fazer Check-in");
		System.out.println("[3] - Fazer Check-out");
		System.out.println("[4] - Sair");
		int opcao = sc.nextInt();
		
		while(opcao<1 || opcao>4) {
			System.out.println("Digite uma opcao valida: ");
			opcao = sc.nextInt();
		}
	
	
		switch (opcao) {
		
		case 1:
			verQuartos(hotel);
			break;
			
		case 2:
			int numCheckIn;
			System.out.println("Digite o número do quarto que deseja fazer Check-In: ");
			numCheckIn = sc.nextInt();
			checkIn(hotel,numCheckIn);
			break;
			
		case 3:
			int numCheckOut;
			System.out.println("Digite o número do quarto que deseja fazer CheckOut: ");
			numCheckOut = sc.nextInt();
			checkOut(hotel,numCheckOut);
			break;
			
		case 4:
			System.out.println("Obrigado por utilizar nosso programa!");
			break;
			
		default:
			break;
			
		}
		
		return opcao;
		
		}
	
}