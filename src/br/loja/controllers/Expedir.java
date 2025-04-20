package br.loja.controllers;
import br.loja.entidades.Pedido;
import br.loja.enums.Status;

public class Expedir {
    Status status;
    Pedido pedido;

    public Expedir(Pedido pedido) {
        this.pedido = pedido;
        this.status = Status.NOTA_EMITIDA;
    }

    private void separarMercadorias(){
        System.out.println("Departamento de expedição: Mercadorias separadas para entrega.");
        status = Status.EM_EXPEDICAO;
    }
}