package br.loja.entidades;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private Vendedor vendedor;
    private List<Produto> produtos;

    public Pedido(int id, Cliente cliente, List<Produto> produtosIniciais, Vendedor vendedor) {
        this.id = id;
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
        if (produtosIniciais != null) {
            this.produtos.addAll(produtosIniciais);
        }
        this.vendedor = vendedor;
    }

    public Pedido(Cliente cliente, Vendedor vendedor) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public boolean removerProduto(Produto produto) {
        return this.produtos.remove(produto);
    }

    public float calcularValorTotal() {
        float total = 0;
        for (Produto p : produtos) {
            total += p.getPrice();
        }
        return total;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", vendedor=" + vendedor +
                ", produtos=" + produtos +
                '}';
    }
}
