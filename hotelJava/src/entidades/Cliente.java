package entidades;

import hotelJava.Quarto;

public class Cliente extends Usuario{
    private Quarto quartoAlugado;

    public Cliente(){}

    public Cliente(String email, String nome, String senha, Quarto quartoAlugado) {
        super(email, nome, senha);
        this.quartoAlugado = quartoAlugado;
    }

    public Quarto getQuartoAlugado() {
        return quartoAlugado;
    }

    public void setQuartoAlugado(Quarto quartoAlugado) {
        this.quartoAlugado = quartoAlugado;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "quartoAlugado=" + quartoAlugado +
                '}';
    }
}
