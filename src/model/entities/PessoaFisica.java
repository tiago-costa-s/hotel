package model.entities;

public class PessoaFisica extends Pessoa {
	protected Integer idade;
	protected String documento;

	public PessoaFisica(String nome, String telefone, String email, Integer idade, String documento) {
		super(nome, telefone, email);
		this.idade = idade;
		this.documento = documento;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	@Override
	public String toString() {
		return "Nome:" + super.nome + "Telefone:" + super.telefone + "e-mail: " + super.email;
	}

}
