package hotelJava;

public class Quarto {
	private int numQuarto;
	private boolean disponivel;
	private boolean check;
	
	// Data[] datasAlugadas;
	
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
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	
	public Quarto() {
		
	}
	
	public Quarto(int numQuarto, boolean disponivel, boolean check) {
		this.numQuarto = numQuarto;
		this.disponivel = disponivel;
		this.check = check;
	}
	
	
}
