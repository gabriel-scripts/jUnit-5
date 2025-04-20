package br.loja.controllers;
import br.loja.entidades.Cliente;
import br.loja.enums.Status;
import br.loja.entidades.Pedido;

public class Vendas {
    public static float venda(Pedido pedido) {
        System.out.println(pedido);
        return pedido.calcularValorTotal();
    }
    public static boolean processarPagamento(Cliente cliente, Pedido pedido){
        Financeiro financeiro = new Financeiro( cliente );
        financeiro.processarPedido();

        Status aguardandoPagamento = Status.AGUARDANDO_PAGAMENTO;
        System.out.printf(String.valueOf(aguardandoPagamento));

        if (cliente.getSaldo() <= 0 ){ System.out.println("Saldo inválido"); }
        if (pedido.calcularValorTotal() == 0){ System.out.println("pedido invalido"); }

        float total = pedido.calcularValorTotal();
        float calcular = cliente.getSaldo() - total;

        if (calcular < 0 ){
            System.out.println("Não foi possível realizar pagamento");
            cliente.setSaldo(0);
        }
        cliente.setSaldo((calcular));

        Expedir expedir = new Expedir(pedido);

        return true;
    }
}