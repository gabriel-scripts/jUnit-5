package br.loja.entidades;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private Vendedor vendedor;
    HashSet<Produto> produtos;

    public void adicionarProduto(Produto iphone) {
    }

    enum Status{
        NEGADO,
        ACEITO,
        PENDENTE
    }

    public Pedido(int id, Cliente cliente, List<Produto> produto) {
        this.id = id;
        this.cliente = cliente;
        this.produtos = new HashSet<Produto>();
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public HashSet<Produto> getProduto() {
        return produtos;
    }

    public void addProduto(Produto produto){
        this.produtos.add(produto);
    }

    public boolean remove(Produto produto){
        return this.produtos.remove(produto);
    }

    public float calcularValorTotal() {
        float total = 0;
        for (Produto price: produtos){
            total = price.getPrice() + total;

        }
        return total;
    }
}
