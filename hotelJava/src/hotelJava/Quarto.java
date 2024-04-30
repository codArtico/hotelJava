package hotelJava;

import java.util.Random;
import util.Data;

public class Quarto {
	private int numQuarto;
	private boolean disponivel;
	private Data dataCheckIn;
	private Data dataCheckOut;
	private float valorDiaria;
	
	
	public int getNumQuarto() {
		return numQuarto;
	}
	public void setNumQuarto(int numQuarto) {
		this.numQuarto = numQuarto;
	}
	
	public boolean isDisponivel() {
		return disponivel;
	}
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	public Data getDataCheckIn() {
		return dataCheckIn;
	}
	public void setDataCheckIn(Data dataCheckIn) {
		this.dataCheckIn = dataCheckIn;
	}

	public Data getDataCheckOut() {
		return dataCheckOut;
	}
	public void setDataCheckOut(Data dataCheckOut) {
		this.dataCheckOut = dataCheckOut;
	}
	
	public float getValorDiaria() {
		return valorDiaria;
	}
	public void setValorDiaria(float valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public Quarto() {
		
	}
	
	public Quarto(int numQuarto, boolean disponivel) {
		this.numQuarto = numQuarto;
		this.disponivel = disponivel;
		this.valorDiaria = gerarValorDiariaAleatorio();
	}
	
	private float gerarValorDiariaAleatorio() {
        Random rand = new Random();

	  	int numeroInteiro = rand.nextInt(601) + 400; // Gera um número de 0 a 600 e soma 400
	    float numeroComDuasCasasDecimais = (float) numeroInteiro / 100;

		return numeroComDuasCasasDecimais;
    }
}