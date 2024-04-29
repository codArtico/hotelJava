package util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

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
	
	static Scanner sc = new Scanner(System.in);
	public static Data coletarData() {
		System.out.print("Digite a data no formato dd/mm/aaaa: ");

		String dataInput = sc.nextLine();
		
		String[] partesData = dataInput.split("/");

        int dia = Integer.parseInt(partesData[0]);
        int mes = Integer.parseInt(partesData[1]);
        int ano = Integer.parseInt(partesData[2]);
        
        Data data = new Data(dia,mes,ano);
        return data;
	}
	
	public static long calcularDias (Data dataIni, Data dataFin) {
		long diferencaEmDias = ChronoUnit.DAYS.between(dataIni.getData(), dataFin.getData());
		return diferencaEmDias;
	}
}