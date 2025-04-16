package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Classe responsável por realizar a conexão com o banco de dados
public class TesteConexao {

    // Configurações da conexão
    private static final String URL = "jdbc:mysql://localhost:3306/carteira_animal"; 
    private static final String USUARIO = "root"; 
    private static final String SENHA = "admin"; 

    // Método que realiza a conexão com o banco de dados
    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException erro) {
            System.out.println("Erro ao conectar no banco: " + erro.getMessage());
            return null;
        }
    }
}
