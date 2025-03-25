package Controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Historico;
import View.Conexao;

public class HistoricoController {
    private final Connection conn;

    public HistoricoController() {
        this.conn = new Conexao().conectaBD();
    }

    // Método para adicionar um novo histórico
    public void adicionarHistorico(Historico historico) throws SQLException {
        String sql = "INSERT INTO Historico (animal_id, data, descricao, veterinario) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, historico.getAnimalId());
            stmt.setDate(2, new java.sql.Date(historico.getData().getTime()));
            stmt.setString(3, historico.getDescricao());
            stmt.setString(4, historico.getVeterinario());

            stmt.executeUpdate();
            System.out.println("Histórico cadastrado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar histórico: " + e.getMessage());
            throw e;
        }
    }

    // Método para atualizar um histórico
    public void atualizarHistorico(Historico historico) throws SQLException {
        String sql = "UPDATE Historico SET data = ?, descricao = ?, veterinario = ? WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(historico.getData().getTime()));
            stmt.setString(2, historico.getDescricao());
            stmt.setString(3, historico.getVeterinario());
            stmt.setInt(4, historico.getId()); // Definindo o ID para identificar qual histórico atualizar

            stmt.executeUpdate();
            System.out.println("Histórico atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar histórico: " + e.getMessage());
            throw e;
        }
    }

    // Método para excluir um histórico
    public void excluirHistorico(int id) throws SQLException {
        String sql = "DELETE FROM Historico WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Histórico excluído com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao excluir histórico: " + e.getMessage());
            throw e;
        }
    }
}
