import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PessoaDAO {
    private Connection connection;

    public PessoaDAO() {
        this.connection = new Conexao().GeraConexao();
    }

    // Create
    public void adiciona(Pessoa pessoa) {

        String sql = "INSERT INTO pessoas(nome_pessoa, cidade, estado, email, whatsapp) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, pessoa.getNomePessoa());
            stmt.setString(2, pessoa.getCidade());
            stmt.setString(3, pessoa.getEstado());
            stmt.setString(4, pessoa.getEmail());
            stmt.setString(5, pessoa.getWhatsapp());
            stmt.execute();
            stmt.close();
            System.out.println("Usuário cadastrado com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Read
    public ArrayList<Pessoa> listar() {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        String sql = "SELECT * FROM pessoas";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Pessoa pessoa = new Pessoa(
                        resultSet.getString("nome_pessoa"),
                        resultSet.getString("cidade"),
                        resultSet.getString("estado"),
                        resultSet.getString("email"),
                        resultSet.getString("whatsapp")
                        );
                pessoa.setIdPessoa(resultSet.getInt("id_pessoa"));

                pessoas.add(pessoa);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pessoas;
    }

    // Read por ID
    public Pessoa buscarPorId(int idPessoa) {
        String sql = "SELECT * FROM pessoas WHERE id_pessoa = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idPessoa);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                Pessoa pessoa = new Pessoa(
                        resultSet.getString("nome_pessoa"),
                        resultSet.getString("cidade"),
                        resultSet.getString("estado"),
                        resultSet.getString("email"),
                        resultSet.getString("whatsapp")
                );
                pessoa.setIdPessoa(resultSet.getInt("id_pessoa"));

                stmt.close();
                return pessoa;
            } else {
                stmt.close();
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Update
    public void atualiza(Pessoa pessoa) {
        String sql = "UPDATE pessoas SET nome_pessoa = ?, cidade = ?, estado = ?, email = ?, whatsapp = ? WHERE id_pessoa = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, pessoa.getNomePessoa());
            stmt.setString(2, pessoa.getCidade());
            stmt.setString(3, pessoa.getEstado());
            stmt.setString(4, pessoa.getEmail());
            stmt.setString(5, pessoa.getWhatsapp());
            stmt.setInt(6, pessoa.getIdPessoa());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Usuário atualizado com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Delete
    public void exclui(int idPessoa) {
        String sql = "DELETE FROM pessoas WHERE id_pessoa = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idPessoa);
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Usuário excluído com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
