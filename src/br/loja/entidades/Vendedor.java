package br.loja.entidades;

public class Vendedor {
    private int id;
    private String name;
    private float salary;
    private int age;

    public Vendedor(int id, String name, float salary, int age) {
        if (salary < 663){
            throw new IllegalArgumentException("");
        }
        if (age < 14){
            throw new IllegalArgumentException("");
        }
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}