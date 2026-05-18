package conta_bancaria.model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public abstract class Conta {

	private final int numero;
	private int agencia;
	private final TipoConta tipo;
	private String titular;
	private BigDecimal saldo;

	protected Conta(int numero, int agencia, TipoConta tipo, String titular, BigDecimal saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}

	public int getNumero() {
		return numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public TipoConta getTipo() {
		return tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	protected void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public boolean sacar(BigDecimal valor) {
		if (valorInvalido(valor) || saldo.compareTo(valor) < 0) {
			return false;
		}

		saldo = saldo.subtract(valor);
		return true;
	}

	public boolean depositar(BigDecimal valor) {
		if (valorInvalido(valor)) {
			return false;
		}

		saldo = saldo.add(valor);
		return true;
	}

	protected boolean valorInvalido(BigDecimal valor) {
		return valor == null || valor.compareTo(BigDecimal.ZERO) <= 0;
	}

	protected String formatarMoeda(BigDecimal valor) {
		NumberFormat formatoBrasil = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		return formatoBrasil.format(valor);
	}

	public String visualizar() {
		return """
				
				****************************************
				Dados da Conta
				****************************************
				Número da Conta: %d
				Agência: %d
				Tipo da Conta: %s
				Titular: %s
				Saldo: %s
				""".formatted(
				numero,
				agencia,
				tipo.getDescricao(),
				titular,
				formatarMoeda(saldo)
		);
	}
}