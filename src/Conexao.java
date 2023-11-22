import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection GeraConexao() {

        Connection conexao = null;

        try {
            String url = "jdbc:mysql://localhost/petme";
            String usuario = "root";
            String senha = "Rafaela123";
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão realizada com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao tentar conectar: " + e.getMessage());
            conexao = null;
        }
        return conexao;
    }
}
    // Método para verificar se a cidade já existe no banco de dados
    /*private boolean pessoaJaExiste(int idPessoa) {
        String sql = "SELECT COUNT(*) FROM pessoas WHERE id_pessoa = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idPessoa);
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            stmt.close();
            return count > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    }
} */