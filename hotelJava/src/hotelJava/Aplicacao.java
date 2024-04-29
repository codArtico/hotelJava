package hotelJava;

import java.util.Scanner;

public class Aplicacao {
	// Pedir data de hoje para operações
	//Função para reservar quarto (Falta fazer a verificacao da data que ele tá pedindo)

	// Função que controla as funcionalidades do programa
	
	public static void main(String []args) {
		
		Hotel hotel = new Hotel("Boa Vista",10);
		int chave;
		Scanner sc = new Scanner(System.in);
		do {
			
		chave = Hotel.menuPrincipal(hotel,sc);
		
		} while (chave != 0);
	}
}
