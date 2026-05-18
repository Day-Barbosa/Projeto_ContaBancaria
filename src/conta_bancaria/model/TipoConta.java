package conta_bancaria.model;

import java.util.Optional;

public enum TipoConta {

	CORRENTE(1, "Conta Corrente"),
	POUPANCA(2, "Conta Poupança");

	private final int codigo;
	private final String descricao;

	TipoConta(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Optional<TipoConta> buscarPorCodigo(int codigo) {
		for (TipoConta tipoConta : values()) {
			if (tipoConta.codigo == codigo) {
				return Optional.of(tipoConta);
			}
		}

		return Optional.empty();
	}
}