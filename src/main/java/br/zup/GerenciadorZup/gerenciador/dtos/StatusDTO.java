package br.zup.GerenciadorZup.gerenciador.dtos;

import br.zup.GerenciadorZup.gerenciador.enuns.Status;
import br.zup.GerenciadorZup.gerenciador.enuns.Tipo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class StatusDTO {


    private Status status;

    public StatusDTO() {
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
