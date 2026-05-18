package conta_bancaria.model;

import java.math.BigDecimal;

public class ContaCorrente extends Conta {

	private BigDecimal limite;

	public ContaCorrente(int numero, int agencia, String titular, BigDecimal saldo, BigDecimal limite) {
		super(numero, agencia, TipoConta.CORRENTE, titular, saldo);
		this.limite = limite;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public void setLimite(BigDecimal limite) {
		this.limite = limite;
	}

	@Override
	public boolean sacar(BigDecimal valor) {
		if (valorInvalido(valor)) {
			return false;
		}

		BigDecimal saldoComLimite = getSaldo().add(limite);

		if (saldoComLimite.compareTo(valor) < 0) {
			return false;
		}

		setSaldo(getSaldo().subtract(valor));
		return true;
	}

	@Override
	public String visualizar() {
		return super.visualizar()
				+ "Limite de Crédito: " + formatarMoeda(limite) + "\n"
				+ "****************************************\n";
	}
}