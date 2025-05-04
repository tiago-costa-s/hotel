package model.entities;

public class SuiteMaster extends Suite {
	protected Boolean arCondicionado;

	public SuiteMaster(String number, Integer quarto, Boolean arCondicionado) {
		super(number, quarto);
		this.arCondicionado = arCondicionado;
	}

	public Boolean getArCondicionado() {
		return arCondicionado;
	}

	public void setArCondicionado(Boolean arCondicionado) {
		this.arCondicionado = arCondicionado;
	}

	@Override
	public double getPrecoDiaria() {
		// TODO Auto-generated method stub
		return 0;
	}

}
