package br.zup.GerenciadorZup.gerenciador;

import br.zup.GerenciadorZup.gerenciador.enuns.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public Conta salvarConta(Conta conta) {

        conta.setDataDePagamento(null);
        LocalDate dataAtual = LocalDate.now();

        if (conta.getDataDeVencimento().isBefore(dataAtual)) {
            conta.setStatus(Status.VENCIDA);
        } else {
            conta.setStatus(Status.AGUARDANDO);
        }

        return contaRepository.save(conta);

    }

    public List <Conta> exibirTodasAsContas () {

        List <Conta> contas = (List<Conta>) contaRepository.findAll();
        return contas;

    }


}
