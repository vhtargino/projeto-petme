import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in); // Para strings
        Scanner sc2 = new Scanner(System.in); // Para números
        int opcao;
        int opcao2;
        Pessoa p1 = new Pessoa();
        double quantiaMes;
        boolean pessoaJaExiste;

        /*
        Animal a1 = new Animal(9, "Cuca", "cão", "caramelo");
        Animal a2 = new Animal(10, "Xuxu", "gato", "tricolor" );
        Animal a3 = new Animal(11, "Chico", "cão", "preto");
        Animal a4 = new Animal(12, "Mingau", "gato", "laranjinha");

        AnimalDAO a1d = new AnimalDAO();
        AnimalDAO a2d = new AnimalDAO();
        AnimalDAO a3d = new AnimalDAO();
        AnimalDAO a4d = new AnimalDAO(); */

       /* a1d.adiciona(a1);
        a2d.adiciona(a2);                                  //Este bloco de código está comentado porque
        a3d.adiciona(a3);                                  //cada vez que eu testo ele cria novamente no banco,
        a4d.adiciona(a4);*/                                //novos objetos, mas para teste pode descomentar e testar
        ArrayList<Animal> animais = new ArrayList<>();
       /* animais.add(a1);
       animais.add(a2);
       animais.add(a3);
      animais.add(a4); */

        System.out.println("Somos a ONG Petme, promovemos o apadrinhamento de animais, se você deseja " +
                "ser apadrinhar algum bichinho segue o menu:");
        do{
            System.out.println("");
            System.out.println("=========================");
            System.out.println("Escolha uma das opções:");
            System.out.println("1. Lista de animais para apadrinhamento");
            System.out.println("2. Cadastro de padrinho");
            System.out.println("3. Apadrinhar um animal");
            System.out.println("0. Sair.");
            System.out.println("=========================");
            System.out.println("");
            System.out.println("Opção desejada:");
            opcao = sc2.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("Lista de animais disponíveis:");
                    for (Animal animal : animais){
                        System.out.println(animal.toString());
                    }
                    break;

                case 2:
                    System.out.println("");
                    System.out.println("=========================");
                    System.out.println("CADASTRAR PADRINHO");
                    System.out.println("=========================");
                    System.out.println("");
                    System.out.print("Digite o ID do padrinho: ");
                    p1.setIdPessoa(sc2.nextInt());
                    System.out.print("Digite o nome do padrinho: ");
                    p1.setNomePessoa(sc1.nextLine());
                    System.out.print("Digite a cidade do padrinho: ");
                    p1.setCidade(sc1.nextLine());
                    System.out.print("Digite o estado do padrinho: ");
                    p1.setEstado(sc1.nextLine());
                    System.out.print("Digite o e-mail do padrinho: ");
                    p1.setEmail(sc1.nextLine());
                    System.out.print("Digite o Whatsapp do padrinho: ");
                    p1.setWhatsapp(sc1.nextLine());

                    PessoaDAO pd1 = new PessoaDAO();
                    pd1.adiciona(p1);
                    break;

                case 3:
                    System.out.println("Escolha um animal disponível pelo seu número identificador:");
                    AnimalDAO animalDAO = new AnimalDAO();
                    ArrayList<Animal> animaisDisponiveis = animalDAO.listar();
                    for (Animal animal : animaisDisponiveis) {
                        System.out.println(animal.toString());
                    }
                    opcao2 = sc2.nextInt();
                    Animal animalEscolhido = animalDAO.buscarPorId(opcao2);

                    PessoaDAO pessoaDAO = new PessoaDAO();

                    System.out.println("Digite o ID da Pessoa para apadrinhamento:");
                    int idPessoaSelecionada = sc2.nextInt();
                    Pessoa pessoaSelecionada = pessoaDAO.buscarPorId(idPessoaSelecionada);

                    if (animalEscolhido != null && pessoaSelecionada != null) {
                        Apadrinhamento apadrinhamento = new Apadrinhamento();
                        apadrinhamento.setIdApadrinhamento(1);
                        System.out.println("Digite um valor que você deseja enviar ao animal: ");
                        double valor = sc2.nextDouble();
                        apadrinhamento.setQuantiaMensal(valor);
                        apadrinhamento.setAnimal(animalEscolhido);
                        apadrinhamento.setPessoa(pessoaSelecionada);
                        ApadrinhamentoDAO apadrinhamentoDAO = new ApadrinhamentoDAO();
                        apadrinhamentoDAO.adiciona(apadrinhamento);
                    } else {
                        System.out.println("Erro: Animal ou pessoa selecionada é nula.");
                    }
                    break;

                case 0:
                    System.out.println("Obrigada por ajudar a salvar a vida de um animalzinho," +
                            "até a próxima");
                    break;

                default:
                    System.out.println("Escolha uma opção válida.");
                    break;

            }

        }while (opcao != 0);


    }
}
