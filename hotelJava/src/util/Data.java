package util;

import java.time.LocalDate;

public class Data {
	private int dia;
	private int mes;
	private int ano;
	private LocalDate data;
	
	public Data (int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.data = LocalDate.of(ano, mes, dia);
	}
	
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return dia + "/" + mes + "/" + ano;
	}
}
