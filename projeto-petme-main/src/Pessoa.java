import java.util.ArrayList;

public class Pessoa {
    // Atributos
    private int idPessoa;
    private String nomePessoa;
    private String cidade;
    private String estado;
    private String email;
    private String whatsapp;

    // Construtores
    public Pessoa() {
    }

    public Pessoa(String nomePessoa, String cidade, String estado, String email, String whatsapp) {
        this.nomePessoa = nomePessoa;
        this.cidade = cidade;
        this.estado = estado;
        this.email = email;
        this.whatsapp = whatsapp;

    }

    // Getters e setters
    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public static void listarPessoas() {
        PessoaDAO pd2 = new PessoaDAO();

        ArrayList<Pessoa> pessoas = pd2.listar();
        for (Pessoa pessoa : pessoas) {
            System.out.println("ID: " + pessoa.getIdPessoa() +
                    ", Nome: " + pessoa.getNomePessoa() +
                    ", Cidade: " + pessoa.getCidade() +
                    ", Estado: " + pessoa.getEstado() +
                    ", E-mail: " + pessoa.getEmail() +
                    ", Whatsapp: " + pessoa.getWhatsapp());
        }
    }
}
