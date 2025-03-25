package View;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    // Definir constantes para URL, usuário e senha
    private static final String URL = "jdbc:mysql://localhost:3306/carteira_Animal?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";
    
    // Método para conectar ao banco de dados
    public Connection conectaBD() {
        try {
            // Carregar o Driver do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Estabelecer a conexão e retorná-la
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException e) {
            System.err.println("Erro ao carregar o driver JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erro ao conectar com o banco de dados: " + e.getMessage());
        }
        return null;
    }

    // Método main para testar a conexão
    public static void main(String[] args) {
        Conexao conexao = new Conexao();

        // Tentar a conexão com o banco de dados usando try-with-resources
        try (Connection conn = conexao.conectaBD()) {
            if (conn != null) {
                System.out.println("Conexão bem-sucedida!");
            } else {
                System.out.println("Falha ao conectar com o banco de dados.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao tentar obter a conexão: " + e.getMessage());
        }
    }
}
