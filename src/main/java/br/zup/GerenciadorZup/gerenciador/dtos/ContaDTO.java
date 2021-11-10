package br.zup.GerenciadorZup.gerenciador.dtos;

import br.zup.GerenciadorZup.gerenciador.enuns.Tipo;

import java.time.LocalDate;

public class ContaDTO {

    private String nome;
    private double valor;
    private Tipo tipo;
    private LocalDate dataDeVencimento;

    public ContaDTO() {
    }

    public ContaDTO(String nome, double valor, Tipo tipo, LocalDate dataDeVencimento) {
        this.nome = nome;
        this.valor = valor;
        this.tipo = tipo;
        this.dataDeVencimento = dataDeVencimento;
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
