package br.loja.externo;

import br.loja.entidades.Cliente;
import br.loja.entidades.Pedido;
import br.loja.entidades.Produto;
import br.loja.entidades.Vendedor;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
    static List<Produto> produtos = new ArrayList<>();
    static List<Cliente> clientes = new ArrayList<>();

    List<Pedido> pedidos;
    List<Vendedor> vendedors;

    public static void addProduto(Produto produto){
        produtos.add(produto);
    }
    public void addPedido(Pedido pedido){
        pedidos.add(pedido);
    }
    public static void addCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public void addVendedor(Vendedor vendedor){
        vendedors.add(vendedor);
    }

    public static Cliente getCliente(String cpf) {
        for(Cliente c: clientes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        throw new NullPointerException("Cliente não existe na banco de dados");
    }

    public static Produto getProduto(int id){
        for(Produto p: produtos){
            if (p.getId() == id){
                return p;
            }
        }
        throw new NullPointerException("Cliente não existe na banco de dados");
    };
    public static void clearBD(){
        produtos.clear();
        clientes.clear();
    };
}
