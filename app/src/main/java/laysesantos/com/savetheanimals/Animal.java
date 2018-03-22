package laysesantos.com.savetheanimals;

/**
 * Created by layss on 22/03/2018.
 */

public class Animal {

    private int id;
    private String nome;
    private String raca;
    private int idade;
    private float peso;

    public Animal() {
    }

    public Animal(int id, String nome, String raca, int idade, float peso) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.peso = peso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        return id == animal.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
