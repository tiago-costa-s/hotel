package aplication;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Pessoa;
import model.entities.PessoaFisica;
import model.entities.Reserva;
import model.entities.SuiteStandard;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");		
		Pessoa p1 = new PessoaFisica("Tiago", "3199193-2470", "tiago@gmail.com", 36, "12050060");
		SuiteStandard s1 = new SuiteStandard("01", 1);

		System.out.print("Numero da Reserva: ");
		int numeroReserva = sc.nextInt();
		sc.nextLine();

		System.out.print("Data da Reserva: ");
		String dataReserva = sc.nextLine();

		System.out.print("Entrada: ");
		String dataEntrada = sc.nextLine();

		System.out.print("Saida: ");
		String dataSaida = sc.nextLine();

		try {
			LocalDate dReserva = LocalDate.parse(dataReserva, formatter);
			LocalDate entrada = LocalDate.parse(dataEntrada, formatter);
			LocalDate saida = LocalDate.parse(dataSaida, formatter);
			Reserva res1 = new Reserva(numeroReserva, dReserva, entrada, saida, s1, p1);

			System.out.println("Reserva: " + res1);
			System.out.println("Periodo: " + res1.calcPeriodo() + " noite(s)");
		} catch (DateTimeParseException e) {
			System.out.println("Erro: formato inválido de data.");
		}

		sc.close();

	}

}
