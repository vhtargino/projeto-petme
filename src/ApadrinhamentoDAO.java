import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ApadrinhamentoDAO {
    private Connection connection;

    public ApadrinhamentoDAO() {
        this.connection = new Conexao().GeraConexao();
    }

//    private boolean apadrinhamentoJaExiste(int idApadrinhamento) {
//        String sql = "SELECT COUNT(*) FROM apadrinhamento WHERE id_apadrinhamento = ?";
//        try {
//            PreparedStatement stmt = connection.prepareStatement(sql);
//            stmt.setInt(1, idApadrinhamento);
//            ResultSet resultSet = stmt.executeQuery();
//            int count = resultSet.getInt(1);
//            stmt.close();
//            return count > 0;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    // Create
    public void adiciona(Apadrinhamento apadrinhamento) {
//        if (apadrinhamentoJaExiste(apadrinhamento.getIdApadrinhamento())) { System.out.println("Apadrinhamento com ID " + apadrinhamento.getIdApadrinhamento() + " já existe na tabela.");
//            return;
//        }

        String sql = "INSERT INTO apadrinhamento(id_apadrinhamento, quantia_mensal, id_pessoa, id_animal) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, apadrinhamento.getIdApadrinhamento());
            stmt.setDouble(2, apadrinhamento.getQuantiaMensal());
            stmt.setInt(3, apadrinhamento.pegarIdInstanciaPessoa());
            stmt.setInt(4, apadrinhamento.pegarIdInstanciaAnimal());
            stmt.execute();
            stmt.close();
            System.out.println("Apadrinhamento cadastrado com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Read
    public ArrayList<Apadrinhamento> listar() {
        ArrayList<Apadrinhamento> apadrinhamentos = new ArrayList<>();
        String sql = "SELECT id_apadrinhamento, quantia_mensal, id_pessoa, id_animal FROM apadrinhamento";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Apadrinhamento apadrinhamento = new Apadrinhamento();
                apadrinhamento.setIdApadrinhamento(resultSet.getInt("id_apadrinhamento"));
                apadrinhamento.setQuantiaMensal(resultSet.getDouble("quantia_mensal"));
                apadrinhamento.setIdPessoaPadrinho(resultSet.getInt("id_pessoa"));
                apadrinhamento.setIdAnimalApadrinhado(resultSet.getInt("id_animal"));
                apadrinhamentos.add(apadrinhamento);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return apadrinhamentos;
    }

    // Read por ID
    public Apadrinhamento buscarPorId(int idApadrinhamento) {
        String sql = "SELECT quantia_mensal, id_pessoa, id_animal FROM apadrinhamento WHERE id_apadrinhamento = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idApadrinhamento);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                Apadrinhamento apadrinhamento = new Apadrinhamento();
                apadrinhamento.setIdApadrinhamento(resultSet.getInt("id_apadrinhamento"));
                apadrinhamento.setQuantiaMensal(resultSet.getDouble("quantia_mensal"));
                apadrinhamento.setIdPessoaPadrinho(resultSet.getInt("id_pessoa"));
                apadrinhamento.setIdAnimalApadrinhado(resultSet.getInt("id_animal"));
                stmt.close();
                return apadrinhamento;
            } else {
                stmt.close();
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Update
    public void atualiza(Apadrinhamento apadrinhamento) {
        String sql = "UPDATE apadrinhamento SET quantia_mensal = ?, id_pessoa = ?, id_animal = ? WHERE id_apadrinhamento = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDouble(1, apadrinhamento.getQuantiaMensal());
            stmt.setInt(2, apadrinhamento.getIdPessoaPadrinho());
            stmt.setInt(3, apadrinhamento.getIdAnimalApadrinhado());
            stmt.setInt(4, apadrinhamento.getIdApadrinhamento());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Apadrinhamento atualizado com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Delete
    public void exclui(int idApadrinhamento) {
        String sql = "DELETE FROM apadrinhamento WHERE id_apadrinhamento = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idApadrinhamento);
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Apadrinhamento excluído com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
