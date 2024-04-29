package hotelJava;

//import java.time.temporal.ChronoUnit;

import util.Data;

public class Hotel {
	private String nome;
	private Quarto[] quartos;
	
	
	Hotel(){
		
	}
	
	Hotel(String nome, int quantQuartos){
		this.nome = nome;
		this.quartos = new Quarto[quantQuartos];
		for (int i = 0; i < quantQuartos; i++) {
			quartos[i] = new Quarto(i,true);
			
		}
	}

	Hotel(String nome, Quarto[] quartos){
		this.nome = nome;
		this.quartos = quartos;
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
		for (int i = 0; i < quartos.length; i++) {
			
			if(quartos[i].isDisponivel()) {
				chave = true;
				System.out.print(" • " + quartos[i].getNumQuarto() + " • \n");
			}
			
		}
		
		if (!chave) {
			System.out.println("Não há quartos disponiveis neste hotel!");
		}
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
				quartoSelecionado.setDataCheckIn(Data.coletarData());
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
				quartoSelecionado.setDataCheckOut(Data.coletarData());
				quartoSelecionado.setDisponivel(true); // Deixa o quarto disponível
				long diaria = Data.calcularDias(quartoSelecionado.getDataCheckIn(), quartoSelecionado.getDataCheckOut());
				System.out.printf("Você ficou %d dias hospedado! %n" , diaria);
				System.out.println("Quarto liberado!");
				// System.out.printf("A sua despesa é de R$ %.2f! %n" , 20); //alterar o valor depois
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
}
