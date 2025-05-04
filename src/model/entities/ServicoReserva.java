package model.entities;

import java.time.LocalDate;

public class ServicoReserva {

	protected Reserva reserva;
	protected Suite suite;

	public Reserva criarReserva(int numero, LocalDate dataReserva, LocalDate dataEntrada, LocalDate dataSaida,
			Suite suite, Pessoa pessoa) {
		return new Reserva(numero, dataReserva, dataEntrada, dataSaida, suite, pessoa);
	}

	public double calcValorReserva() {
		double valorFinal = 0.0;
		if (suite instanceof SuiteStandard) {
			valorFinal = reserva.calcPeriodo() * suite.getPrecoDiaria();
		} else if (suite instanceof SuiteMaster) {
			valorFinal = reserva.calcPeriodo() * suite.getPrecoDiaria();
		}
		return valorFinal;
	}
}
