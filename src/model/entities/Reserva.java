package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import model.exceptions.MyExceptions;

public class Reserva {
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	protected Integer numero;
	protected LocalDate dataReserva;
	protected LocalDate dataEntrada;
	protected LocalDate dataSaida;

	protected Suite suite;
	protected Pessoa pessoa;

	public Reserva() {
	}

	public Reserva(Integer numero, LocalDate dataReserva, LocalDate dataEntrada, LocalDate dataSaida, Suite suite,
			Pessoa pessoa) {

		validarDatas(dataReserva, dataEntrada, dataSaida);
		validarSuite(suite);
		validarPessoa(pessoa);

		this.numero = numero;
		this.dataReserva = dataReserva;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.suite = suite;
		this.pessoa = pessoa;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public LocalDate getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(LocalDate dataReserva) {
		this.dataReserva = dataReserva;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Suite getSuite() {
		return suite;
	}

	public void setSuite(Suite suite) {
		this.suite = suite;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void validarDatas(LocalDate dataReserva, LocalDate dataEntrada, LocalDate dataSaida) {
		if (dataReserva.isAfter(dataEntrada)) {
			throw new MyExceptions("A data de reserva não poder ser depois da data de entrada.");
		}

		if (dataReserva.isAfter(dataSaida)) {
			throw new MyExceptions("A data de reserva não poder ser depois da data de saida.");
		}

		if (dataEntrada.isAfter(dataSaida)) {
			throw new MyExceptions("A data de entrada não poder ser depois da data de saida.");
		}
	}

	public void validarSuite(Suite suite) {
		if (suite == null) {
			throw new MyExceptions("A suite deve ser informada na reserva.");
		}
	}

	public void validarPessoa(Pessoa pessoa) {
		if (pessoa == null) {
			throw new MyExceptions("Um hospede deve ser informado na reserva.");
		}
	}

	@Override
	public String toString() {
		return "Numero: " + numero + " Data da reserva: " + dtf.format(dataReserva) + " Data entrada: " + dataEntrada
				+ " Data saida: " + dataSaida;
	}

//	Retorna quantas noites foram reservadas
	public long calcPeriodo() {
		if (dataEntrada == null || dataSaida == null) {
			throw new MyExceptions("Datas de entrada ou saida não podem ser nulas.");
		}

		return ChronoUnit.DAYS.between(dataEntrada, dataSaida);
	}

}
