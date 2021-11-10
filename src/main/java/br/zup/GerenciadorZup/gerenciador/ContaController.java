package br.zup.GerenciadorZup.gerenciador;


import br.zup.GerenciadorZup.gerenciador.dtos.ContaDTO;
import br.zup.GerenciadorZup.gerenciador.dtos.RetornoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)

    public RetornoDTO realizarCadastro (@RequestBody ContaDTO contaDTo) {

    Conta conta = modelMapper.map(contaDTo , Conta.class);

    RetornoDTO retornoDTO = modelMapper.map(contaService.salvarConta(conta) , RetornoDTO.class);


     return retornoDTO;

    }


}
