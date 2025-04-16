package Controller;

import model.Tutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Config.TesteConexao;

// Classe responsável pelo CRUD dos Tutores no banco de dados
public class TutorController {

    // Método para cadastrar um novo tutor
public void cadastrarTutor(Tutor tutor) {
    String sql = "INSERT INTO tutor (nome, telefone, endereco, email, cpf) VALUES (?, ?, ?, ?, ?)";

    try (Connection conn = TesteConexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, tutor.getNome());
        stmt.setString(2, tutor.getTelefone());
        stmt.setString(3, tutor.getEndereco());
        stmt.setString(4, tutor.getEmail());
        stmt.setString(5, tutor.getCpf());

        stmt.executeUpdate();
        System.out.println("Tutor cadastrado com sucesso!");

    } catch (SQLException e) {
        System.out.println("Erro ao cadastrar tutor: " + e.getMessage());
    }
}


    // Método para listar todos os tutores cadastrados
    public void listarTutores() {
        String sql = "SELECT * FROM tutor";

        try (Connection conn = TesteConexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Telefone: " + rs.getString("telefone"));
                System.out.println("Endereço: " + rs.getString("endereco"));
                System.out.println("Email: " + rs.getString("email"));  // Exibindo email
                System.out.println("CPF: " + rs.getString("cpf"));        // Exibindo CPF
                System.out.println("----------------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar tutores: " + e.getMessage());
        }
    }

    // Método para excluir tutor pelo ID
    public void excluirTutor(int id) {
        String sql = "DELETE FROM tutor WHERE id = ?";

        try (Connection conn = TesteConexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Tutor excluído com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao excluir tutor: " + e.getMessage());
        }
    }
}
