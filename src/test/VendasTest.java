package test;

import br.loja.entidades.Cliente;
import br.loja.entidades.Pedido;
import br.loja.entidades.Produto;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;
import br.loja.externo.BancoDeDados;
import org.junit.jupiter.api.Test;


class VendasTest {
    @BeforeAll
    static void antes() {
        Cliente c = new Cliente("Gabriel", "123456789", 21, true);
        BancoDeDados.addCliente(c);

        Produto p1 = new Produto(8000, 1, "Iphone 16 pro max", 1239);
        Produto p2 = new Produto(16, 1, "Kinder ovo", 121239);

        BancoDeDados.addProduto(p1);
        BancoDeDados.addProduto(p2);
    }

    @Test
    void venda() {
        Cliente cliente = BancoDeDados.getCliente("123456789");
        Pedido pedido = new Pedido(cliente);

        Produto iphone = BancoDeDados.getProduto(121239);
        pedido.adicionarProduto(iphone);

        float valorTotaldoPedido = iphone.getPrice();
        for (int i = 0; i < 7; i++) {
            Produto kinder = BancoDeDados.getProduto(1239);
            pedido.adicionarProduto(kinder);
            valorTotaldoPedido += kinder.getPrice();
        }

        assertEquals(valorTotaldoPedido, pedido.calcularValorTotal());
    }

    @AfterAll
    static void after(){

    }

}