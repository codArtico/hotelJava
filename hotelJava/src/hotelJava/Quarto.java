package hotelJava;

import util.Data;

public class Quarto {
	private int numQuarto;
	private boolean disponivel;
	private Data dataCheckIn;
	private Data dataCheckOut;
	
	
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
	
	public Quarto() {
		
	}
	
	public Quarto(int numQuarto, boolean disponivel) {
		this.numQuarto = numQuarto;
		this.disponivel = disponivel;
	}
	
	
}
