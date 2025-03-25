
package model;
import java.util.Date;

public class Historico {
    private int id;
    private int animalId;
    private Date data;
    private String descricao;
    private String veterinario;

    public Historico(int id, int animalId, Date data, String descricao, String veterinario) {
        this.id = id;
        this.animalId = animalId;
        this.data = data;
        this.descricao = descricao;
        this.veterinario = veterinario;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getAnimalId() { return animalId; }
    public void setAnimalId(int animalId) { this.animalId = animalId; }

    public Date getData() { return data; }
    public void setData(Date data) { this.data = data; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getVeterinario() { return veterinario; }
    public void setVeterinario(String veterinario) { this.veterinario = veterinario; }
}
