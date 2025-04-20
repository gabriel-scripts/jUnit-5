package test;

import br.loja.entidades.Cliente;
import br.loja.entidades.Pedido;
import br.loja.entidades.Produto;
import br.loja.entidades.Vendedor;
import br.loja.externo.BancoDeDados;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VendasTest {
    @BeforeAll
    static void antes() {
        Cliente c = new Cliente("Gabriel", "123456789", 21);
        c.validateAge(c.getAge());
        c.setSaldo(550);
        c.changeInadimplencia();
        BancoDeDados.addCliente(c);
        System.out.println(c.toString());

        Produto iphone = new Produto(900, 1, "Motorola", 121239);
        Produto kinder = new Produto(20, 10, "Kinder ovo", 123955);
        BancoDeDados.addProduto(iphone);
        BancoDeDados.addProduto(kinder);

        Vendedor v = new Vendedor(12131233, "Mario", 1550, 26);
        BancoDeDados.addVendedor(v);

        System.out.println(BancoDeDados.getVendedor(12131233));
    }

    @Test
    void venda() {
        Cliente cliente = BancoDeDados.getCliente(String.valueOf(123456789));
        Vendedor vendedor1 = BancoDeDados.getVendedor(12131233);

        Pedido pedido = new Pedido( cliente, vendedor1 );

        Produto iphone = BancoDeDados.getProduto(121239);
        pedido.adicionarProduto(iphone);

        float valorTotaldoPedido = iphone.getPrice();

        Produto kinder = BancoDeDados.getProduto(123955);

        for (int i = 0; i < 7; i++) {
            pedido.adicionarProduto(kinder);
            valorTotaldoPedido = valorTotaldoPedido + kinder.getPrice();
        }

        System.out.println(pedido.toString());

        assertEquals(valorTotaldoPedido, pedido.calcularValorTotal(), 0.01f);
    }

    @AfterAll
    static void after(){
        BancoDeDados.clearBD();
    }
}
