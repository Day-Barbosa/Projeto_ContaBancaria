package conta_bancaria.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository {

	private final List<Conta> contas = new ArrayList<>();
	private int proximoNumero = 1;

	public int gerarNumero() {
		return proximoNumero++;
	}

	@Override
	public Conta cadastrar(Conta conta) {
		contas.add(conta);
		return conta;
	}

	@Override
	public List<Conta> listarTodas() {
		return Collections.unmodifiableList(contas);
	}

	@Override
	public Optional<Conta> buscarPorNumero(int numero) {
		return contas.stream()
				.filter(conta -> conta.getNumero() == numero)
				.findFirst();
	}

	@Override
	public boolean atualizar(Conta contaAtualizada) {
		for (int indice = 0; indice < contas.size(); indice++) {
			Conta conta = contas.get(indice);

			if (conta.getNumero() == contaAtualizada.getNumero()) {
				contas.set(indice, contaAtualizada);
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean deletar(int numero) {
		return contas.removeIf(conta -> conta.getNumero() == numero);
	}

	@Override
	public boolean sacar(int numero, BigDecimal valor) {
		return buscarPorNumero(numero)
				.map(conta -> conta.sacar(valor))
				.orElse(false);
	}

	@Override
	public boolean depositar(int numero, BigDecimal valor) {
		return buscarPorNumero(numero)
				.map(conta -> conta.depositar(valor))
				.orElse(false);
	}

	@Override
	public boolean transferir(int numeroOrigem, int numeroDestino, BigDecimal valor) {
		if (numeroOrigem == numeroDestino) {
			return false;
		}

		Optional<Conta> contaOrigem = buscarPorNumero(numeroOrigem);
		Optional<Conta> contaDestino = buscarPorNumero(numeroDestino);

		if (contaOrigem.isEmpty() || contaDestino.isEmpty()) {
			return false;
		}

		boolean saqueRealizado = contaOrigem.get().sacar(valor);

		if (!saqueRealizado) {
			return false;
		}

		contaDestino.get().depositar(valor);
		return true;
	}
}