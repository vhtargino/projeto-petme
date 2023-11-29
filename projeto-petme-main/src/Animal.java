import java.util.ArrayList;

public abstract class Animal {
    // Atributos
    private int idAnimal;
    private String nomeAnimal;
    private String coloracao;

    // Construtores
    public Animal() {
    }

    public Animal(String nomeAnimal, String coloracao) {
        this.nomeAnimal = nomeAnimal;
        this.coloracao = coloracao;
    }

    // Getters e setters

    public abstract String getEspecie();

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public String getColoracao() {
        return coloracao;
    }

    public void setColoracao(String coloracao) {
        this.coloracao = coloracao;
    }

    public static void listarAnimais() {
        AnimalDAO ad2 = new AnimalDAO();

        ArrayList<Animal> animais = ad2.listar();
        for (Animal animal : animais) {
            System.out.println("ID: " + animal.getIdAnimal() +
                    ", Nome: " + animal.getNomeAnimal() +
                    ", Espécie: " + animal.getEspecie() +
                    ", Coloração: " + animal.getColoracao());
        }
    }
}
