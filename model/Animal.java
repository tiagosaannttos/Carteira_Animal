package model;

// Classe que representa o Animal
public class Animal {

    private int id;
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private int tutor_id; // chave estrangeira (relacionamento com Tutor)
    private String cor;   // Novo campo
    private String sexo;  // Novo campo
    private double peso;  // Novo campo

    // Construtor vazio (importante para quando for usar setters depois)
    public Animal() {
    }

    // Construtor com todos os atributos
    public Animal(int id, String nome, String especie, String raca, int idade, int tutor_id, String cor, String sexo, double peso) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.tutor_id = tutor_id;
        this.cor = cor;
        this.sexo = sexo;
        this.peso = peso;
    }

    // Getters e Setters (acesso e modificação dos atributos)
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

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
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

    public int getTutor_id() {
        return tutor_id;
    }

    public void setTutor_id(int tutor_id) {
        this.tutor_id = tutor_id;
    }

    // Getters e Setters para os novos campos
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
