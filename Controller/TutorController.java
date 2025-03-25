package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Tutor;
import View.Conexao;

public class TutorController {
    private final Connection conn;

    public TutorController() {
        this.conn = new Conexao().conectaBD();
    }

    // Método para cadastrar um novo tutor
    public void cadastrarTutor(Tutor tutor) throws SQLException {
        String sql = "INSERT INTO Tutor (nome, endereco, telefone, email) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tutor.getNome());
            stmt.setString(2, tutor.getEndereco());
            stmt.setString(3, tutor.getTelefone());
            stmt.setString(4, tutor.getEmail());

            stmt.executeUpdate();
            System.out.println("Tutor cadastrado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar tutor: " + e.getMessage());
            throw e;
        }
    }

    // Método para listar todos os tutores
    public List<Tutor> listarTutores() throws SQLException {
        List<Tutor> tutores = new ArrayList<>();
        String sql = "SELECT * FROM Tutor";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Tutor tutor = new Tutor(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("endereco"),
                    rs.getString("telefone"),
                    rs.getString("email")
                );
                tutores.add(tutor);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar tutores: " + e.getMessage());
            throw e;
        }
        return tutores;
    }

    // Método para atualizar um tutor
    public void atualizarTutor(Tutor tutor) throws SQLException {
        String sql = "UPDATE Tutor SET nome = ?, endereco = ?, telefone = ?, email = ? WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tutor.getNome());
            stmt.setString(2, tutor.getEndereco());
            stmt.setString(3, tutor.getTelefone());
            stmt.setString(4, tutor.getEmail());
            stmt.setInt(5, tutor.getId());

            stmt.executeUpdate();
            System.out.println("Tutor atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar tutor: " + e.getMessage());
            throw e;
        }
    }

    // Método para excluir um tutor
    public void excluirTutor(int id) throws SQLException {
        String sql = "DELETE FROM Tutor WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Tutor excluído com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao excluir tutor: " + e.getMessage());
            throw e;
        }
    }
}
