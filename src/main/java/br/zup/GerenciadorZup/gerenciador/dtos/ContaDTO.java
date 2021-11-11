package br.zup.GerenciadorZup.gerenciador.dtos;

import br.zup.GerenciadorZup.gerenciador.enuns.Tipo;
import com.sun.istack.NotNull;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class ContaDTO {

    @Size (min = 2 , message = "Nome menor do que o permitido" )
    private String nome;
    @DecimalMin("0.01")
    private double valor;
    private Tipo tipo;
    @NotNull
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
