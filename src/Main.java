import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Pessoa p1 = new Pessoa(3, "Mônica", "São Paulo", "SP", "monica@turmadamonica.com.br", "01193845720");

        PessoaDAO p1Dao = new PessoaDAO();
        p1Dao.adiciona(p1);

        ArrayList<Pessoa> pessoas = p1Dao.listar ();
        for (Pessoa p : pessoas) {
            System.out.println("ID: " + p.getIdPessoa() +
                    ", Nome: " + p.getNomePessoa() +
                    ", Cidade: " + p.getCidade() +
                    ", Estado: " + p.getEstado() +
                    ", E-mail: " + p.getEmail() +
                    ", Whatsapp: " + p.getWhatsapp());
        }

        Animal a1 = new Animal(3, "Monicão", "Cachorro", "Marrom");

        AnimalDAO a1Dao = new AnimalDAO();
        a1Dao.adiciona(a1);

        ArrayList<Animal> animais = a1Dao.listar ();
        for (Animal a : animais) {
            System.out.println("ID: " + a.getIdAnimal() +
                    ", Nome: " + a.getNomeAnimal() +
                    ", Espécie: " + a.getEspecie() +
                    ", Coloração: " + a.getColoracao());
        }

        Apadrinhamento apad1 = new Apadrinhamento();
        apad1.setIdApadrinhamento(3);
        apad1.setQuantiaMensal(500);
        apad1.setPessoa(p1);
        apad1.setAnimal(a1);

        ApadrinhamentoDAO apad1Dao = new ApadrinhamentoDAO();
        apad1Dao.adiciona(apad1);

        ArrayList<Apadrinhamento> apadrinhamentos = apad1Dao.listar ();
        for (Apadrinhamento apad : apadrinhamentos) {
            System.out.println("ID: " + apad.getIdApadrinhamento() +
                    ", Quantia Mensal: " + apad.getQuantiaMensal() +
                    ", ID Padrinho: " + apad.getIdPessoaPadrinho() +
                    ", ID Pet: " + apad.getIdAnimalApadrinhado());
        }
    }
}
