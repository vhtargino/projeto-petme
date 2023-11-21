import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnimalDAO {
    private Connection connection;

    public AnimalDAO() {
        this.connection = new Conexao().GeraConexao();
    }

//    private boolean animalJaExiste(int idAnimal) {
//        String sql = "SELECT COUNT(*) FROM animais WHERE id_animal = ?";
//        try {
//            PreparedStatement stmt = connection.prepareStatement(sql);
//            stmt.setInt(1, idAnimal);
//            ResultSet resultSet = stmt.executeQuery();
//            int count = resultSet.getInt(1);
//            stmt.close();
//            return count > 0;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    // Create
    public void adiciona(Animal animal) {
//        if (animalJaExiste(animal.getIdAnimal())) {
//            System.out.println("Animal com ID " + animal.getIdAnimal() + " já existe na tabela.");
//            return;
//        }

        String sql = "INSERT INTO animais(id_animal, nome_animal, especie, coloracao) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, animal.getIdAnimal());
            stmt.setString(2, animal.getNomeAnimal());
            stmt.setString(3, animal.getEspecie());
            stmt.setString(4, animal.getColoracao());
            stmt.execute();
            stmt.close();
            System.out.println("Pet cadastrado com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Read
    public ArrayList<Animal> listar() {
        ArrayList<Animal> animais = new ArrayList<>();
        String sql = "SELECT id_animal, nome_animal, especie, coloracao FROM animais";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Animal animal = new Animal();
                animal.setIdAnimal(resultSet.getInt("id_animal"));
                animal.setNomeAnimal(resultSet.getString("nome_animal"));
                animal.setEspecie(resultSet.getString("especie"));
                animal.setColoracao(resultSet.getString("coloracao"));
                animais.add(animal);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return animais;
    }

    // Read por ID
    public Animal buscarPorId(int idAnimal) {
        String sql = "SELECT id_animal, nome_animal, especie, coloracao FROM animais WHERE id_animal = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idAnimal);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                Animal animal = new Animal();
                animal.setIdAnimal(resultSet.getInt("id_animal"));
                animal.setNomeAnimal(resultSet.getString("nome_animal"));
                animal.setEspecie(resultSet.getString("especie"));
                animal.setColoracao(resultSet.getString("coloracao"));
                stmt.close();
                return animal;
            } else {
                stmt.close();
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Update
    public void atualiza(Animal animal) {
        String sql = "UPDATE animais SET nome_animal = ?, especie = ?, coloracao = ? WHERE id_animal = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, animal.getNomeAnimal());
            stmt.setString(2, animal.getEspecie());
            stmt.setString(3, animal.getColoracao());
            stmt.setInt(4, animal.getIdAnimal());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Pet atualizado com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Delete
    public void exclui(int idAnimal) {
        String sql = "DELETE FROM animais WHERE id_animal = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idAnimal);
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Pet excluído com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
