package br.loja.controllers;
import br.loja.enums.Status;

public class Expedir {
    Status status;

    public Expedir(Status status) {
        this.status = Status.NOTA_EMITIDA;
    }

    private void separarMercadorias(){
        System.out.println("Departamento de expedição: Mercadorias separadas para entrega.");
        status = Status.EM_EXPEDICAO;
    }
}
