package br.zup.GerenciadorZup.gerenciador.dtos;

import br.zup.GerenciadorZup.gerenciador.enuns.Tipo;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class ContaDTO {

    @NotBlank
    @Size (min = 2 , message = "Nome menor do que o permitido" )
    private String nome;
    @NotNull
    @DecimalMin(value = "0.01", message = "Valor menor do que o permitido")
    private double valor;
    private Tipo tipo;
    @NotNull (message = "A data de vencimento está em branco")
    private LocalDate dataDeVencimento;

    public ContaDTO() {
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(LocalDate dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

}
