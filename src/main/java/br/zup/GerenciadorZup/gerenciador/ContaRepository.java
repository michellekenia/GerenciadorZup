package br.zup.GerenciadorZup.gerenciador;

import br.zup.GerenciadorZup.gerenciador.enuns.Status;
import br.zup.GerenciadorZup.gerenciador.enuns.Tipo;
import org.springframework.data.repository.CrudRepository;

import javax.print.attribute.IntegerSyntax;
import java.util.List;

public interface ContaRepository extends CrudRepository <Conta, Integer> {

    List <Conta> findAllByStatus (Status status);

    List <Conta> findAllByTipo (Tipo tipo);

    List <Conta> findAllByValor (double valor);

}



