package hotelJava;

public class Hotel {
	private String nome;
	private Quarto[] quartos;
	
	
	Hotel(){
		
	}
	
	Hotel(String nome, int quantQuartos){
		this.nome = nome;
		this.quartos = new Quarto[quantQuartos];
		for (int i =0; i<quantQuartos; i++) {
			quartos[i] = new Quarto(i,true);
			
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
	
}
