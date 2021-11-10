package br.zup.GerenciadorZup.gerenciador;

import org.springframework.stereotype.Service;

@Service
public class ContaService {

    private ContaRepository contaRepository;

    public Conta salvarConta (Conta conta) {

        return contaRepository.save(conta);

    }


}
