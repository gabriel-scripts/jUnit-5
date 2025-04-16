package br.loja.controllers;
import br.loja.enums.Status;
import br.loja.entidades.Pedido;

public class Vendas {
    public static float venda(Pedido pedido) {
        System.out.println(pedido);
        return pedido.calcularValorTotal();
    }
}
