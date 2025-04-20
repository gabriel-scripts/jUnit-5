package test;

import static br.loja.controllers.Vendas.processarPagamento;
import static org.junit.jupiter.api.Assertions.*;

import br.loja.entidades.Cliente;
import br.loja.entidades.Pedido;
import br.loja.entidades.Produto;
import br.loja.entidades.Vendedor;
import br.loja.externo.BancoDeDados;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class pagamentoTest {
    @BeforeAll
    static void antes() {
        Cliente c = new Cliente("Gabriel", "123456789", 21);
        Cliente c1 = new Cliente("Pedro", "01213123", 24);
        Cliente c2 = new Cliente("Gabriel2", "012321312", 50);

        //saldo insuficiente
        c1.setSaldo(0);
        c1.validateAge(c1.getAge());
        c1.changeInadimplencia();
        BancoDeDados.addCliente(c1);

        //saldo suficiente
        c.setSaldo(100000);
        c.validateAge(c.getAge());
        c.changeInadimplencia();
        BancoDeDados.addCliente(c);

        //inadimplente
        c2.setSaldo(200);
        c2.validateAge(c2.getAge());
        BancoDeDados.addCliente(c2);

        Produto iphone = new Produto(900, 1, "iphone", 121239);
        Produto kinder = new Produto(20, 10, "Kinder ovo", 123955);
        BancoDeDados.addProduto(iphone);
        BancoDeDados.addProduto(kinder);

        Vendedor v = new Vendedor(12131233, "Mario", 1550, 26);
        BancoDeDados.addVendedor(v);

        System.out.println(BancoDeDados.getClienteName(String.valueOf(123456789)));
        System.out.println(BancoDeDados.getClienteName("01213123"));
        System.out.println(BancoDeDados.getClienteName("012321312"));
    }

    @Test
    void testPagamentoComSaldoSuficiente() {
        Cliente cliente = BancoDeDados.getCliente("123456789");
        Vendedor vendedor1 = BancoDeDados.getVendedor(12131233);

        Produto iphone = BancoDeDados.getProduto(121239);
        Produto kinder = BancoDeDados.getProduto(123955);

        Pedido pedido = new Pedido( cliente, vendedor1 );

        pedido.adicionarProduto(iphone);
        pedido.adicionarProduto(kinder);

        float diferenca = cliente.getSaldo() - pedido.calcularValorTotal();
        if (diferenca < 0){
            cliente.setSaldo(0);
        }
        boolean resultado = processarPagamento(cliente, pedido);

        assertTrue(resultado);
        assertEquals(diferenca, cliente.getSaldo());
    }
    @Test
    void testPagamentoComSaldoInsuficiente() {
        Cliente cliente3 = BancoDeDados.getCliente("01213123");
        Vendedor vendedor1 = BancoDeDados.getVendedor(12131233);

        Produto iphone = BancoDeDados.getProduto(121239);
        Produto kinder = BancoDeDados.getProduto(123955);

        Pedido pedido = new Pedido( cliente3, vendedor1 );

        pedido.adicionarProduto(iphone);
        pedido.adicionarProduto(kinder);

        float diferenca = cliente3.getSaldo() - pedido.calcularValorTotal();
        if (diferenca < 0){
            cliente3.setSaldo(0);
        }
        boolean resultado = processarPagamento(cliente3, pedido);

        assertTrue(resultado);
        assertEquals(diferenca, cliente3.getSaldo());
    }

    @Test
    void testPedidoInvalido() {
        Cliente cliente2 = BancoDeDados.getCliente("012321312");
        Vendedor vendedor1 = BancoDeDados.getVendedor(12131233);

        Produto iphone = BancoDeDados.getProduto(121239);
        Produto kinder = BancoDeDados.getProduto(123955);

        Pedido pedido = new Pedido( cliente2, vendedor1 );

        pedido.adicionarProduto(iphone);
        pedido.adicionarProduto(kinder);

        float diferenca = cliente2.getSaldo() - pedido.calcularValorTotal();
        if (diferenca < 0){
            cliente2.setSaldo(0);
        }
        boolean resultado = processarPagamento(cliente2, pedido);

        assertTrue(resultado);
        assertEquals(diferenca, cliente2.getSaldo());
    }

    @AfterAll
    static void after(){
        BancoDeDados.clearBD();
    }
}