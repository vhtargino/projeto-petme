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
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
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

    // Métodos
    public int pegarIdInstanciaPessoa() {
        idPessoaPadrinho = pessoa.getIdPessoa();
        return idPessoaPadrinho;
    }

    public int pegarIdInstanciaAnimal() {
        idAnimalApadrinhado = animal.getIdAnimal();
        return idAnimalApadrinhado;
    }
}
