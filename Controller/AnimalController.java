package Controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import View.Conexao;
import model.Animal;


public class AnimalController {
    private final Connection conn;

    // Construtor para receber a conexão
    public AnimalController() {
        this.conn = new Conexao().conectaBD();
    }

    // Método para cadastrar um novo animal
    public void cadastrarAnimal(Animal animal) throws SQLException {
        String sql = criarSqlInsercao();

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            preencherPreparedStatement(stmt, animal);
            executarInsercao(stmt);
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar animal: " + e.getMessage());
            throw e;  // Re-lançando a exceção após log
        }
    }

    // Criar a SQL de inserção
    private String criarSqlInsercao() {
        return "INSERT INTO Animal (nome, especie, raca, idade, cor, sexo, peso, tutor_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    }

    // Preencher o PreparedStatement com os dados do animal
    private void preencherPreparedStatement(PreparedStatement stmt, Animal animal) throws SQLException {
        stmt.setString(1, animal.getNome());
        stmt.setString(2, animal.getEspecie());
        stmt.setString(3, animal.getRaca());
        stmt.setInt(4, animal.getIdade());
        stmt.setString(5, animal.getCor());
        stmt.setString(6, animal.getSexo());
        stmt.setDouble(7, animal.getPeso());
        stmt.setInt(8, animal.getTutorId());
    }

    // Executar a inserção no banco de dados
    private void executarInsercao(PreparedStatement stmt) throws SQLException {
        stmt.executeUpdate();
        System.out.println("Animal cadastrado com sucesso!");
    }

    // Método para atualizar um animal
    public void atualizarAnimal(Animal animal) throws SQLException {
        String sql = "UPDATE Animal SET nome = ?, especie = ?, raca = ?, idade = ?, cor = ?, sexo = ?, peso = ?, tutor_id = ? WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getEspecie());
            stmt.setString(3, animal.getRaca());
            stmt.setInt(4, animal.getIdade());
            stmt.setString(5, animal.getCor());
            stmt.setString(6, animal.getSexo());
            stmt.setDouble(7, animal.getPeso());
            stmt.setInt(8, animal.getTutorId());
            stmt.setInt(9, animal.getId());  // Definindo o ID para identificar qual animal atualizar

            stmt.executeUpdate();
            System.out.println("Animal atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar animal: " + e.getMessage());
            throw e;
        }
    }

    // Método para excluir um animal
    public void excluirAnimal(int id) throws SQLException {
        String sql = "DELETE FROM Animal WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Animal excluído com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao excluir animal: " + e.getMessage());
            throw e;
        }
    }

    // Fechar conexão de forma mais robusta
    public void fecharConexao() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Conexão fechada com sucesso!");
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}