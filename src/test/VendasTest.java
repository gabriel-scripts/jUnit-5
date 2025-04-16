package test;

import br.loja.entidades.Cliente;
import br.loja.entidades.Pedido;
import br.loja.entidades.Produto;
import br.loja.externo.BancoDeDados;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VendasTest {
    @BeforeAll
    static void antes() {
        // Cria um cliente e adiciona ao BancoDeDados
        Cliente c = new Cliente("Gabriel", "123456789", 21);
        c.changeInadimplencia();
        BancoDeDados.addCliente(c);

        Produto iphone = new Produto(8000, 1, "Iphone 16 pro max", 121239);
        Produto kinder = new Produto(16, 1, "Kinder ovo", 1239);

        BancoDeDados.addProduto(iphone);
        BancoDeDados.addProduto(kinder);
    }

    @Test
    void venda() {
        // Obtém o cliente e cria um pedido
        Cliente cliente = BancoDeDados.getCliente(String.valueOf(123456789));
        Pedido pedido = new Pedido(cliente);

        // Recupera e adiciona o iPhone
        Produto iphone = BancoDeDados.getProduto(121239);
        pedido.adicionarProduto(iphone);

        // Inicializa o valor total com o preço do iPhone
        float valorTotaldoPedido = iphone.getPrice();
        // Acrescenta 7 unidades do Kinder ovo
        for (int i = 0; i < 7; i++) {
            Produto kinder = BancoDeDados.getProduto(1239);
            pedido.adicionarProduto(kinder);
            valorTotaldoPedido += kinder.getPrice();
        }

        // Verifica se o valor total calculado pelo pedido está correto
        assertEquals(valorTotaldoPedido, pedido.calcularValorTotal());
    }

    @AfterAll
    static void after(){
        BancoDeDados.clearBD();
    }
}
