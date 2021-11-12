package br.zup.GerenciadorZup.gerenciador;


import br.zup.GerenciadorZup.gerenciador.dtos.ContaDTO;
import br.zup.GerenciadorZup.gerenciador.dtos.StatusDTO;
import br.zup.GerenciadorZup.gerenciador.dtos.ResumoDTO;
import br.zup.GerenciadorZup.gerenciador.dtos.RetornoDTO;
import br.zup.GerenciadorZup.gerenciador.enuns.Status;
import br.zup.GerenciadorZup.gerenciador.enuns.Tipo;
import br.zup.GerenciadorZup.gerenciador.exceptions.StatusInvalido;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RetornoDTO realizarCadastro (@Valid @RequestBody ContaDTO contaDTo) {

    Conta conta = modelMapper.map(contaDTo , Conta.class);

    RetornoDTO retornoDTO = modelMapper.map(contaService.salvarConta(conta) , RetornoDTO.class);


     return retornoDTO;

    }

    @GetMapping
    public List <ResumoDTO> exibirContas (@RequestParam (required = false)Status status,
                                          @RequestParam (required = false)Tipo tipo,
                                          @RequestParam (required = false) Double valor) {

        List <ResumoDTO> contasDTOS = new ArrayList<>();

        for (Conta conta : contaService.exibirTodasAsContas(status, tipo, valor)) {

            ResumoDTO resumoDTO = modelMapper.map(conta, ResumoDTO.class);

            contasDTOS.add(resumoDTO);

        }

         return contasDTOS;
    }


    @PutMapping ("/{id}")
    public RetornoDTO atualizarContas (@PathVariable Integer id, @RequestBody StatusDTO contasPagasDTO) {

        if (contasPagasDTO.getStatus() == Status.PAGO) {
            return modelMapper.map(contaService.atualizarConta(id), RetornoDTO.class);

        }

        throw new StatusInvalido("Esse tipo de Status de conta não é permitido. Tente novamente.");

    }

    @GetMapping ("/{id}")
    public RetornoDTO buscarContaEspecifica (@PathVariable int id) {

        Conta contaEspecifica = contaService.buscarContaId(id);

        return modelMapper.map(contaEspecifica, RetornoDTO.class);
    }

    @DeleteMapping ("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void deletarConta (@PathVariable int id) {
        contaService.deletarConta(id);
    }

}
