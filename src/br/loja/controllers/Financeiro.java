package br.loja.controllers;
import br.loja.entidades.Cliente;
import br.loja.enums.Status;

public class Financeiro {
    private Cliente cliente;
    private Status status;

    public Financeiro(Cliente cliente) {
        this.cliente = cliente;
        this.status = Status.NOVO;
    }
    public void processarPedido(){
        System.out.println("Iniciando processamento do pedido.");
        try {
            if(cliente.isInadimplente()){
                status = Status.FINALIZADO;
            }else{
                status = Status.CANCELADO;
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao processar o cliente",  e);
        }
    }
}