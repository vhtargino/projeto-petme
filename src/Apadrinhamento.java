public class Apadrinhamento {
    // Atributos
    private int idApadrinhamento;
    private double quantiaMensal;
    private Animal animal;
    private Pessoa pessoa;
    private int idPessoaPadrinho;
    private int idAnimalApadrinhado;

    // Construtores
    public Apadrinhamento() {
    }

    // Getters e setters
    public int getIdApadrinhamento() {
        return idApadrinhamento;
    }

    public void setIdApadrinhamento(int idApadrinhamento) {
        this.idApadrinhamento = idApadrinhamento;
    }

    public double getQuantiaMensal() {
        return quantiaMensal;
    }

    public void setQuantiaMensal(double quantiaMensal) {
        this.quantiaMensal = quantiaMensal;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
        // Se o animal for definido, você pode extrair o ID e definir o idAnimalApadrinhado
        if (animal != null) {
            this.idAnimalApadrinhado = animal.getIdAnimal();
        }
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        // Se a pessoa for definida, você pode extrair o ID e definir o idPessoaPadrinho
        if (pessoa != null) {
            this.idPessoaPadrinho = pessoa.getIdPessoa();
        }
    }

    public int getIdPessoaPadrinho() {
        return idPessoaPadrinho;
    }

    public void setIdPessoaPadrinho(int idPessoaPadrinho) {
        this.idPessoaPadrinho = idPessoaPadrinho;
    }

    public int getIdAnimalApadrinhado() {
        return idAnimalApadrinhado;
    }

    public void setIdAnimalApadrinhado(int idAnimalApadrinhado) {
        this.idAnimalApadrinhado = idAnimalApadrinhado;
    }
}
