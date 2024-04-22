package hotelJava;

public class Quarto {
	String numQuarto;
	private boolean disponivel;
	private boolean check;
	
	// Data[] datasAlugadas;
	
	public String getNumQuarto() {
		return numQuarto;
	}
	public void setNumQuarto(String numQuarto) {
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
	
	@Override
	public String toString() {
		return "Quarto [disponivel=" + disponivel + ", check=" + check + "]";
	}
	
	
}
