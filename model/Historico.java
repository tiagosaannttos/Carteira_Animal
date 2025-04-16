package model;

// Classe que representa o Histórico de um Animal
public class Historico {

    private int id;
    private String descricao;
    private String data;
    private int idAnimal; // chave estrangeira (relacionamento com Animal)

    // Construtor vazio
    public Historico() {
    }

    // Construtor com todos os atributos
    public Historico(int id, String descricao, String data, int idAnimal) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.idAnimal = idAnimal;
    }

    // Getters e Setters (acesso e modificação dos atributos)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }
}
