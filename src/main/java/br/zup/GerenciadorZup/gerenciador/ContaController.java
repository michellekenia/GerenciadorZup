package br.zup.GerenciadorZup.gerenciador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;
}
