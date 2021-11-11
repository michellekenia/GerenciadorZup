package br.zup.GerenciadorZup.gerenciador;


import br.zup.GerenciadorZup.gerenciador.dtos.ContaDTO;
import br.zup.GerenciadorZup.gerenciador.dtos.StatusDTO;
import br.zup.GerenciadorZup.gerenciador.dtos.ResumoDTO;
import br.zup.GerenciadorZup.gerenciador.dtos.RetornoDTO;
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
    public List <ResumoDTO> exibirContas () {

        List <ResumoDTO> contasDTOS = new ArrayList<>();

        for (Conta conta : contaService.exibirTodasAsContas()) {

            ResumoDTO resumoDTO = modelMapper.map(conta, ResumoDTO.class);

            contasDTOS.add(resumoDTO);

        }

         return contasDTOS;
    }


    @PutMapping ("/{id}")
    public RetornoDTO atualizarContas (@PathVariable Integer id, @RequestBody StatusDTO contasPagasDTO) {

       RetornoDTO retornoDTO = modelMapper.map(contaService.atualizarConta(id), RetornoDTO.class);

        return retornoDTO;

    }

}
