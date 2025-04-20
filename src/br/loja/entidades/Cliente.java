package br.loja.entidades;

public class Cliente {
    private String name;
    private String cpf;
    private int age;
    private boolean inadimplente;
    private float saldo;

    public Cliente(String name, String cpf, int age) {
        if (name.isBlank()){
            throw new IllegalArgumentException("[error] Valor nulo.");
        }
        this.name = name;
        this.cpf = cpf;
        this.age = age;
        this.inadimplente = false;
        this.saldo = 0.0F;
    }
    public float getSaldo(){return  saldo;};
    public void setSaldo(float saldo) { this.saldo = saldo; }
   
    public String getName() {
        return name;
    }
    
    public String getCpf() {
        return cpf;
    }

    public int getAge() { return age; }

    public boolean isInadimplente() {
        return inadimplente;
    }

    public void changeInadimplencia() {
        this.inadimplente = !this.inadimplente;
    }

    public void validateAge(int age){
        if (this.age > 130 || this.age < 0){
            throw new IllegalArgumentException("Idade inválida.");
        }
    }

    @Override
    public String toString() {
        return STR."cliente{name='\{name}', cpf='\{cpf}', age=\{age}, inadimplente=\{inadimplente}}";
    }
}