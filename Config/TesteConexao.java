package Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/carteira_Animal?useSSL=false&serverTimezone=UTC";

    String user = "root";
    String password = "admin";

    try {
        Connection conn = DriverManager.getConnection(url, user, password);
        if (conn != null) {
            System.out.println("Conexão bem-sucedida!");
            conn.close();
            System.out.println("Conexão fechada com sucesso!");
        }
    } catch (SQLException e) {
        System.out.println("Erro ao conectar: " + e.getMessage());
    }

    }
}
