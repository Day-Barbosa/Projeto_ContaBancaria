package conta_bancaria.model;

import java.math.BigDecimal;

public class ContaPoupanca extends Conta {

	private int aniversario;

	public ContaPoupanca(int numero, int agencia, String titular, BigDecimal saldo, int aniversario) {
		super(numero, agencia, TipoConta.POUPANCA, titular, saldo);
		this.aniversario = aniversario;
	}

	public int getAniversario() {
		return aniversario;
	}

	public void setAniversario(int aniversario) {
		this.aniversario = aniversario;
	}

	@Override
	public String visualizar() {
		return super.visualizar()
				+ "Aniversário da Conta: " + aniversario + "\n"
				+ "****************************************\n";
	}
}