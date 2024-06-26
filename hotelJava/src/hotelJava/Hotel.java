package hotelJava;

import entidades.Cliente;

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
		for (int i = quartos.length -1; i >= 0; i--) {
			
			if(quartos[i].isDisponivel()) {
				System.out.print(" • " + quartos[i].getNumQuarto() + " • Valor diária: R$ " + quartos[i].getValorDiaria() + "\n");
			}
			
		}
	}
	
	public static void verQuartos(Hotel hotel) {
		hotel.verificarDisponiveis();
		System.out.println(" ");
		System.out.println(" ");
	}

	public static void checkIn(Hotel hotel, int numeroQuarto, Cliente login) {
		Quarto[] quartos = hotel.getQuartos();
	
		if (numeroQuarto >= 0 && numeroQuarto < quartos.length) {
			Quarto quartoSelecionado = quartos[numeroQuarto];

		
			if (quartoSelecionado.isDisponivel()) {
				System.out.printf("Você está alugando o quarto %d por R$ %.2f %n", quartoSelecionado.getNumQuarto(), quartoSelecionado.getValorDiaria());
				quartoSelecionado.setDataCheckIn(Data.coletarData());
				quartoSelecionado.setDisponivel(false);
				System.out.println("Check-in Realizado!");
				login.setQuartoAlugado(quartoSelecionado);
			}
		
			else {
				System.out.println("Quarto já tem gente!");
			}
		}
		else {
			System.out.println("Número de quarto inválido.");
		}	
	}

	public static void checkOut(Hotel hotel, Cliente cliente) {
		Quarto[] quartos = hotel.getQuartos();
		Quarto quartoAlugado = cliente.getQuartoAlugado();
		if(quartoAlugado == null){
			System.out.println("Você não tem quartos alugados!");
		}
		else if (quartoAlugado.getNumQuarto() >= 0 && quartoAlugado.getNumQuarto() < quartos.length) {
			Quarto quartoSelecionado = quartoAlugado;
			
			if (!quartoSelecionado.isDisponivel()) {
				quartoSelecionado.setDataCheckOut(Data.coletarData());
				long diaria = Math.abs(Data.calcularDias(quartoSelecionado.getDataCheckIn(), quartoSelecionado.getDataCheckOut()));
				float valorTotal = quartoSelecionado.getValorDiaria() * diaria;

				quartoSelecionado.setDisponivel(true); // Deixa o quarto disponível
				cliente.setQuartoAlugado(null);
				System.out.printf("Você ficou %d dias hospedado! %n" , diaria);
				System.out.println("Quarto liberado!");
				System.out.printf("A sua despesa é de R$ %.2f! %n" , valorTotal);
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
