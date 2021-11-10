package br.zup.GerenciadorZup.gerenciador.dtos;

import br.zup.GerenciadorZup.gerenciador.enuns.Status;

public class ResumoDTO {

    private int id;
    private String nome;
    private double valor;
    private Status status;

    public ResumoDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
