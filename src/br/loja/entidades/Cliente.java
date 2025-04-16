package br.loja.entidades;

public class Cliente {
    private String name;
    private String cpf;
    private int age;
    private boolean inadimplente;
    private int saldo;

    public Cliente(String name, String cpf, int age) {
        this.name = name;
        this.cpf = cpf;
        this.age = age;
        this.inadimplente = false;
    }
    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public int getAge() {
        return age;
    }

    public boolean isInadimplente() {
        return inadimplente;
    }

    public void changeInadimplencia() {
        this.inadimplente = !this.inadimplente;
    }

    public void validateAge(){
        if (age > 130 || age < 0){
            throw new IllegalArgumentException("Idade inválida.");
        }
    }

    @Override
    public String toString() {
        return STR."cliente{name='\{name}', cpf='\{cpf}', age=\{age}, inadimplente=\{inadimplente}}";
    }
}