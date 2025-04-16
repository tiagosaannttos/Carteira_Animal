package Controller;
import model.Historico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Config.TesteConexao;

// Classe responsável pelo CRUD do Histórico dos Animais
public class HistoricoController {

    // Método para cadastrar um novo histórico
    public void cadastrarHistorico(Historico historico) {
        String sql = "INSERT INTO historico (id_animal, descricao, data) VALUES (?, ?, ?)";

        try (Connection conn = TesteConexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, historico.getIdAnimal());
            stmt.setString(2, historico.getDescricao());
            stmt.setString(3, historico.getData());

            stmt.executeUpdate();
            System.out.println("Histórico cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar histórico: " + e.getMessage());
        }
    }

   // Método para listar todos os históricos cadastrados
    public void listarHistorico() {
    String sql = "SELECT * FROM historico";

    try (Connection conn = TesteConexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Descrição: " + rs.getString("descricao"));
            System.out.println("Data da Consulta: " + rs.getDate("data_consulta"));
            System.out.println("ID do Animal: " + rs.getInt("animal_id"));
            System.out.println("----------------------------------");
        }

    } catch (SQLException e) {
        System.out.println("Erro ao listar históricos: " + e.getMessage());
    }
}


    // Método para excluir histórico pelo ID
    public void excluirHistorico(int id) {
        String sql = "DELETE FROM historico WHERE id = ?";

        try (Connection conn = TesteConexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Histórico excluído com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao excluir histórico: " + e.getMessage());
        }
    }

    // Removed duplicate method definition
}
