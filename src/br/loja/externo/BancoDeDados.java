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
    static List<Vendedor> vendedores = new ArrayList<>();
    static List<Pedido> pedidos = new ArrayList<>();

    public static void addProduto(Produto produto){
        produtos.add(produto);
    }

    public void addPedido(Pedido pedido){
        pedidos.add(pedido);
    }

    public static void addCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public static void addVendedor(Vendedor vendedor){
        vendedores.add(vendedor);
    }

    public static Cliente getCliente(String cpf) {
        for(Cliente c: clientes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        throw new NullPointerException("Cliente não existe na banco de dados");
    }

    public static String getClienteName(String cpf) {
        for(Cliente c: clientes) {
            if (c.getCpf().equals(cpf)) {
                return c.getName();
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

    public static Vendedor getVendedor(int id){
        for(Vendedor v: vendedores){
            if (v.getId() == id){
                return v;
            }
        }
        throw new NullPointerException("Vendedor não existe na banco de dados");
    };

    public static String getVendedorName(int id){
        for(Vendedor v: vendedores){
            if (v.getId() == id){
                return v.getName();
            }
        }
        throw new NullPointerException("Vendedor não existe na banco de dados");
    };

    public static void clearBD(){
        produtos.clear();
        clientes.clear();
    };
}