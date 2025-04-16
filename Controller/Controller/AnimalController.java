package Controller;

import model.Animal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Config.TesteConexao;

public class AnimalController {

    // Método para cadastrar um novo animal
    public void cadastrarAnimal(Animal animal) {
        String sql = "INSERT INTO animal (nome, especie, raca, idade, tutor_id, cor, sexo, peso) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = TesteConexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {  // Usando RETURN_GENERATED_KEYS

            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getEspecie());
            stmt.setString(3, animal.getRaca());
            stmt.setInt(4, animal.getIdade());
            stmt.setInt(5, animal.getTutor_id());
            stmt.setString(6, animal.getCor());  // Novo campo
            stmt.setString(7, animal.getSexo()); // Novo campo
            stmt.setDouble(8, animal.getPeso()); // Novo campo

            int affectedRows = stmt.executeUpdate();  // Executa a inserção

            if (affectedRows > 0) {
                // Se a inserção foi bem-sucedida, obtém o ID gerado
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        animal.setId(rs.getInt(1));  // Define o ID gerado automaticamente
                        System.out.println("Animal cadastrado com sucesso! ID: " + animal.getId());
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar animal: " + e.getMessage());
        }
    }

    // Método para listar todos os animais cadastrados
    public void listarAnimais() {
        String sql = "SELECT * FROM animal";

        try (Connection conn = TesteConexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Espécie: " + rs.getString("especie"));
                System.out.println("Raça: " + rs.getString("raca"));
                System.out.println("Idade: " + rs.getInt("idade"));
                System.out.println("ID do Tutor: " + rs.getInt("tutor_id"));
                System.out.println("Cor: " + rs.getString("cor"));  // Exibe a cor
                System.out.println("Sexo: " + rs.getString("sexo"));  // Exibe o sexo
                System.out.println("Peso: " + rs.getDouble("peso"));  // Exibe o peso
                //System.out.println("Data de Cadastro: " + rs.getString("data_cadastro"));
                System.out.println("----------------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar animais: " + e.getMessage());
        }
    }

    // Método para excluir um animal pelo ID
    public void excluirAnimal(int id) {
        String sql = "DELETE FROM animal WHERE id = ?";

        try (Connection conn = TesteConexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Animal excluído com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao excluir animal: " + e.getMessage());
        }
    }
}
