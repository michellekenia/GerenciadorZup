package br.zup.GerenciadorZup.gerenciador;

import br.zup.GerenciadorZup.gerenciador.enuns.Status;
import br.zup.GerenciadorZup.gerenciador.enuns.Tipo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ContaRepository extends CrudRepository <Conta, Integer> {

    List <Conta> findAllByStatus (Status status);

    List <Conta> findAllByTipo (Tipo tipo);

    @Query(value = "SELECT * FROM conta_zup WHERE VALOR BETWEEN :valor*0.7 AND :valor*1.3", nativeQuery = true)
    List <Conta> findAllAproximatedContas (double valor);

}



