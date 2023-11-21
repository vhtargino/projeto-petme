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

    // Create
    public void adiciona(Apadrinhamento apadrinhamento) {
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
}
