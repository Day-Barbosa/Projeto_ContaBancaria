package conta_bancaria.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import conta_bancaria.model.Conta;

public interface ContaRepository {

	Conta cadastrar(Conta conta);

	List<Conta> listarTodas();

	Optional<Conta> buscarPorNumero(int numero);

	boolean atualizar(Conta conta);

	boolean deletar(int numero);

	boolean sacar(int numero, BigDecimal valor);

	boolean depositar(int numero, BigDecimal valor);

	boolean transferir(int numeroOrigem, int numeroDestino, BigDecimal valor);
}