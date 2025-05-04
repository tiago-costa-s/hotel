package model.entities;

public abstract class Suite {
	protected String number;
	protected Integer quarto;

	public abstract double getPrecoDiaria();

	public Suite(String number, Integer quarto) {
		this.number = number;
		this.quarto = quarto;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getQuarto() {
		return quarto;
	}

	public void setQuarto(Integer quarto) {
		this.quarto = quarto;
	}

}
