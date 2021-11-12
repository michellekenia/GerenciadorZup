package br.zup.GerenciadorZup.gerenciador;

import br.zup.GerenciadorZup.gerenciador.enuns.Status;
import br.zup.GerenciadorZup.gerenciador.enuns.Tipo;
import br.zup.GerenciadorZup.gerenciador.exceptions.IdNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public List<Conta> exibirTodasAsContas(Status status, Tipo tipo, Double valor) {

        if (status != null) {
            return contaRepository.findAllByStatus(status);
        }

        if (tipo != null) {
            return contaRepository.findAllByTipo(tipo);
        }

        if (valor != null) {
            return contaRepository.findAllAproximatedContas(valor);
        }

        List<Conta> contas = (List<Conta>) contaRepository.findAll();
        return contas;

    }

    public Conta buscarContaId(int id) {
        Optional<Conta> conta = contaRepository.findById(id);

        if (conta.isEmpty()) {
            throw new IdNaoEncontrado("Id não encontrado.");
        }

        return conta.get();
    }

    public Conta atualizarConta(int id) {

        Conta conta = buscarContaId(id);
        conta.setStatus(Status.PAGO);
        conta.setDataDePagamento(LocalDateTime.now());
        contaRepository.save(conta);

        return conta;
    }

    public void deletarConta(int id) {

        if (contaRepository.existsById(id)) {
            contaRepository.deleteById(id);
        } else {
            throw new IdNaoEncontrado("Essa conta não existe.");
        }

    }

}
