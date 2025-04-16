package br.loja.entidades;

import java.util.HashSet;
import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private Vendedor vendedor; // A ser utilizado se necessário
    private HashSet<Produto> produtos;

    // Construtor principal que inicializa todos os atributos necessários
    public Pedido(int id, Cliente cliente, List<Produto> produtosIniciais) {
        this.id = id;
        this.cliente = cliente;
        this.produtos = new HashSet<>();
        if (produtosIniciais != null) {
            this.produtos.addAll(produtosIniciais);
        }
    }

    // Construtor alternativo: neste caso, é importante inicializar a coleção e o id pode ser definido depois
    public Pedido(Cliente cliente) {
        // Dependendo do contexto, você pode gerar um id automaticamente ou definir um padrão
        this.cliente = cliente;
        this.produtos = new HashSet<>();
    }

    // Método unificado para adicionar um produto
    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public HashSet<Produto> getProdutos() {
        return produtos;
    }

    public boolean removerProduto(Produto produto){
        return this.produtos.remove(produto);
    }

    public float calcularValorTotal() {
        float total = 0;
        for (Produto p : produtos){
            total += p.getPrice();
        }
        return total;
    }
}
