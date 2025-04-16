package br.loja.entidades;

public class Produto {
    private int id;
    private String name;
    private float price;
    private int quantidade;

    public Produto(float price, int quantidade, String name, int id) {
        if (name.isBlank()){
            throw new IllegalArgumentException("[error] Valor nulo.");
        }
        if (price <= 0.05f){
            throw new IllegalArgumentException("[error] Valor inválido para a compra");
        }
        this.price = price;
        this.quantidade = quantidade;
        this.name = name;
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "produto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantidade=" + quantidade +
                '}';
    }
}
