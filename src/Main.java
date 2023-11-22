import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in); // Para strings
        Scanner sc2 = new Scanner(System.in); // Para números

        boolean flagMenu1 = false;

        do {
            System.out.println("");
            System.out.println("=========================");
            System.out.println("Escolha uma das opções:");
            System.out.println("1. Padrinho");
            System.out.println("2. Pet");
            System.out.println("3. Apadrinhamento");
            System.out.println("4. Sair");
            System.out.println("=========================");
            System.out.println("");

            System.out.print("Sua escolha: ");
            String escolhaMenu1 = sc1.nextLine();

            switch(escolhaMenu1) {
                case "1":
                    boolean flagMenu2 = false;
                    do {
                        System.out.println("");
                        System.out.println("=========================");
                        System.out.println("O que deseja fazer?");
                        System.out.println("1. Cadastrar padrinho");
                        System.out.println("2. Listar padrinhos");
                        System.out.println("3. Pesquisar padrinho");
                        System.out.println("4. Atualizar cadastro de padrinho");
                        System.out.println("5. Excluir cadastro de padrinho");
                        System.out.println("6. Voltar");
                        System.out.println("=========================");
                        System.out.println("");

                        System.out.print("Sua escolha: ");
                        String escolhaMenu2 = sc1.nextLine();

                        switch (escolhaMenu2) {
                            case "1":
                                System.out.println("");
                                System.out.println("=========================");
                                System.out.println("CADASTRAR PADRINHO");
                                System.out.println("=========================");
                                System.out.println("");

                                Pessoa p1 = new Pessoa();

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

                                flagMenu2 = false;
                                break;
                            case "2":
                                System.out.println("");
                                System.out.println("=========================");
                                System.out.println("LISTAR PADRINHOS");
                                System.out.println("=========================");
                                System.out.println("");

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

                                flagMenu2 = false;
                                break;
                            case "3":
                                System.out.println("");
                                System.out.println("=========================");
                                System.out.println("PESQUISAR PADRINHO");
                                System.out.println("=========================");
                                System.out.println("");

                                System.out.print("Digite o ID do padrinho: ");
                                int idBuscaPessoa = sc2.nextInt();

                                PessoaDAO pd3 = new PessoaDAO();
                                Pessoa pessoaEncontrada = pd3.buscarPorId(idBuscaPessoa);

                                if (pessoaEncontrada != null) {
                                    System.out.println("Padrinho encontrado: \n" +
                                            "Nome: " + pessoaEncontrada.getNomePessoa() +
                                            ", Cidade: " + pessoaEncontrada.getCidade() +
                                            ", Estado: " + pessoaEncontrada.getEstado() +
                                            ", E-mail: " + pessoaEncontrada.getEmail() +
                                            ", Whatsapp: " + pessoaEncontrada.getWhatsapp());
                                } else {
                                    System.out.println("Padrinho não encontrada.");
                                }

                                flagMenu2 = false;
                                break;
                            case "4":
                                System.out.println("");
                                System.out.println("=========================");
                                System.out.println("ATUALIZAR CADASTRO DE PADRINHO");
                                System.out.println("=========================");
                                System.out.println("");

                                System.out.print("Digite o ID do padrinho a ser atualizdo: ");
                                int idAtualizaPessoa = sc2.nextInt();

                                PessoaDAO pd4 = new PessoaDAO();

                                Pessoa pessoaAtt = pd4.buscarPorId(idAtualizaPessoa);
                                if (pessoaAtt != null) {
                                    System.out.print("Digite o novo nome: ");
                                    pessoaAtt.setNomePessoa(sc1.nextLine());
                                    pd4.atualiza(pessoaAtt);
                                }

                                flagMenu2 = false;
                                break;
                            case "5":
                                System.out.println("");
                                System.out.println("=========================");
                                System.out.println("EXCLUIR CADASTRO DE PADRINHO");
                                System.out.println("=========================");
                                System.out.println("");

                                System.out.print("Digite o ID do padrinho a ser excluído: ");
                                int idExcluirPessoa = sc2.nextInt();

                                PessoaDAO pd5 = new PessoaDAO();

                                pd5.exclui(idExcluirPessoa);

                                flagMenu2 = false;
                                break;
                            case "6":
                                System.out.println("Voltando para o menu anterior");
                                flagMenu2 = true;
                                break;
                            default:
                                System.out.println("Escolha dentre as opções do menu");
                        }
                    } while (flagMenu2 == false);

                    flagMenu1 = false;
                    break;
                case "2":
                    boolean flagMenu3 = false;

                    do {
                        System.out.println("");
                        System.out.println("=========================");
                        System.out.println("O que deseja fazer?");
                        System.out.println("1. Cadastrar pet");
                        System.out.println("2. Listar pet");
                        System.out.println("3. Pesquisar pet");
                        System.out.println("4. Atualizar cadastro de pet");
                        System.out.println("5. Excluir cadastro de pet");
                        System.out.println("6. Voltar");
                        System.out.println("=========================");
                        System.out.println("");

                        System.out.print("Sua escolha: ");
                        String escolhaMenu3 = sc1.nextLine();

                        switch (escolhaMenu3) {
                            case "1":
                                System.out.println("");
                                System.out.println("=========================");
                                System.out.println("CADASTRAR PET");
                                System.out.println("=========================");
                                System.out.println("");

                                Animal a1 = new Animal();

                                System.out.print("Digite o ID do pet: ");
                                a1.setIdAnimal(sc2.nextInt());
                                System.out.print("Digite o nome do pet: ");
                                a1.setNomeAnimal(sc1.nextLine());
                                System.out.print("Digite a espécie do pet: ");
                                a1.setEspecie(sc1.nextLine());
                                System.out.print("Digite a coloração do pet: ");
                                a1.setColoracao(sc1.nextLine());

                                AnimalDAO ad1 = new AnimalDAO();
                                ad1.adiciona(a1);

                                flagMenu3 = false;
                                break;
                            case "2":
                                System.out.println("");
                                System.out.println("=========================");
                                System.out.println("LISTAR PETS");
                                System.out.println("=========================");
                                System.out.println("");

                                AnimalDAO ad2 = new AnimalDAO();

                                ArrayList<Animal> animais = ad2.listar();
                                for (Animal animal : animais) {
                                    System.out.println("ID: " + animal.getIdAnimal() +
                                            ", Nome: " + animal.getNomeAnimal() +
                                            ", Espécie: " + animal.getEspecie() +
                                            ", Coloração: " + animal.getColoracao());
                                }

                                flagMenu3 = false;
                                break;
                            case "3":
                                System.out.println("");
                                System.out.println("=========================");
                                System.out.println("PESQUISAR PET");
                                System.out.println("=========================");
                                System.out.println("");

                                System.out.print("Digite o ID do pet: ");
                                int idBuscaAnimal = sc2.nextInt();

                                AnimalDAO ad3 = new AnimalDAO();
                                Animal animalEncontrado = ad3.buscarPorId(idBuscaAnimal);

                                if (animalEncontrado != null) {
                                    System.out.println("Pet encontrado: \n" +
                                            "Nome: " + animalEncontrado.getNomeAnimal() +
                                            ", Espécie: " + animalEncontrado.getEspecie() +
                                            ", Coloração: " + animalEncontrado.getColoracao());
                                } else {
                                    System.out.println("Pet não encontrado.");
                                }

                                flagMenu3 = false;
                                break;
                            case "4":
                                System.out.println("");
                                System.out.println("=========================");
                                System.out.println("ATUALIZAR CADASTRO DE PET");
                                System.out.println("=========================");
                                System.out.println("");

                                System.out.print("Digite o ID do pet a ser atualizdo: ");
                                int idAtualizaAnimal = sc2.nextInt();

                                AnimalDAO ad4 = new AnimalDAO();

                                Animal animalAtt = ad4.buscarPorId(idAtualizaAnimal);
                                if (animalAtt != null) {
                                    System.out.print("Digite o novo nome: ");
                                    animalAtt.setNomeAnimal(sc1.nextLine());
                                    ad4.atualiza(animalAtt);
                                }

                                flagMenu3 = false;
                                break;
                            case "5":
                                System.out.println("");
                                System.out.println("=========================");
                                System.out.println("EXCLUIR CADASTRO DE PET");
                                System.out.println("=========================");
                                System.out.println("");

                                System.out.print("Digite o ID do pet a ser excluído: ");
                                int idExcluirPet = sc2.nextInt();

                                AnimalDAO ad5 = new AnimalDAO();

                                ad5.exclui(idExcluirPet);

                                flagMenu3 = false;
                                break;
                            case "6":
                                System.out.println("Voltando para o menu anterior");
                                flagMenu3 = true;
                                break;
                            default:
                                System.out.println("Escolha dentre as opções do menu");
                        }
                    } while (flagMenu3 == false);

                    flagMenu1 = false;
                    break;
                case "3":
                    boolean flagMenu4 = false;

                    do {
                        System.out.println("");
                        System.out.println("=========================");
                        System.out.println("O que deseja fazer?");
                        System.out.println("1. Cadastrar apadrinhamento");
                        System.out.println("2. Listar apadrinhamentos");
                        System.out.println("3. Pesquisar apadrinhamento");
                        System.out.println("4. Atualizar cadastro de apadrinhamento");
                        System.out.println("5. Excluir cadastro de apadrinhamento");
                        System.out.println("6. Voltar");
                        System.out.println("=========================");
                        System.out.println("");

                        System.out.print("Sua escolha: ");
                        String escolhaMenu4 = sc1.nextLine();

                        switch (escolhaMenu4) {
                            case "1":
                                System.out.println("");
                                System.out.println("=========================");
                                System.out.println("CADASTRAR APADRINHAMENTO");
                                System.out.println("=========================");
                                System.out.println("");

                                Apadrinhamento ap = new Apadrinhamento();

                                System.out.print("Digite o ID do apadrinhamento: ");
                                ap.setIdApadrinhamento(sc2.nextInt());
                                System.out.print("Digite a quantia mensal: ");
                                ap.setQuantiaMensal(sc2.nextDouble());

                                PessoaDAO pd = new PessoaDAO();
                                ArrayList<Pessoa> pessoas = pd.listar();

                                boolean flagId = false;
                                int contador = 0;
                                do {
                                    System.out.print("Digite o ID do padrinho: ");
                                    int idPadrinho = sc2.nextInt();

                                    for (Pessoa p : pessoas) {
                                        if (p.getIdPessoa() == idPadrinho) {
                                            ap.setPessoa(p);
                                            flagId = true;
                                            break;
                                        } else {
                                            contador++;
                                        }

                                        if (contador == pessoas.size()) {
                                            System.out.println("ID não encontrado. Tente novamente.");
                                            flagId = false;
                                        }
                                    }
                                } while (flagId == false);

                                AnimalDAO ad = new AnimalDAO();
                                ArrayList<Animal> animais = ad.listar();

                                flagId = false;
                                contador = 0;
                                do {
                                    System.out.print("Digite o ID do pet: ");
                                    int idPet = sc2.nextInt();

                                    for (Animal a : animais) {
                                        if (a.getIdAnimal() == idPet) {
                                            ap.setAnimal(a);
                                            flagId = true;
                                            break;
                                        } else {
                                            contador++;
                                        }

                                        if (contador == pessoas.size()) {
                                            System.out.println("ID não encontrado. Tente novamente.");
                                            flagId = false;
                                        }
                                    }
                                } while (flagId == false);

                                ApadrinhamentoDAO apd = new ApadrinhamentoDAO();
                                apd.adiciona(ap);

                                flagMenu4 = false;
                                break;
                            case "2":
                                System.out.println("");
                                System.out.println("=========================");
                                System.out.println("LISTAR APADRINHAMENTOS");
                                System.out.println("=========================");
                                System.out.println("");

                                ApadrinhamentoDAO apd2 = new ApadrinhamentoDAO();

                                ArrayList<Apadrinhamento> apadrinhamentos = apd2.listar();
                                for (Apadrinhamento apadrinhamento : apadrinhamentos) {
                                    System.out.println("ID: " + apadrinhamento.getIdApadrinhamento() +
                                            ", Quantia mensal: " + apadrinhamento.getQuantiaMensal() +
                                            ", ID do padrinho: " + apadrinhamento.getIdPessoaPadrinho() +
                                            ", ID do pet: " + apadrinhamento.getIdAnimalApadrinhado());
                                }

                                flagMenu4 = false;
                                break;
                            case "3":
                                System.out.println("");
                                System.out.println("=========================");
                                System.out.println("PESQUISAR APADRINHAMENTO");
                                System.out.println("=========================");
                                System.out.println("");

                                System.out.print("Digite o ID do apadrinhamento: ");
                                int idBuscaApadrinhamento = sc2.nextInt();

                                ApadrinhamentoDAO apd1 = new ApadrinhamentoDAO();
                                Apadrinhamento apadrinhamentoEncontrado = apd1.buscarPorId(idBuscaApadrinhamento);

                                if (apadrinhamentoEncontrado != null) {
                                    System.out.println("ID: " + apadrinhamentoEncontrado.getIdApadrinhamento() +
                                            ", Quantia mensal: " + apadrinhamentoEncontrado.getQuantiaMensal() +
                                            ", ID do padrinho: " + apadrinhamentoEncontrado.getIdPessoaPadrinho() +
                                            ", ID do pet: " + apadrinhamentoEncontrado.getIdAnimalApadrinhado());
                                } else {
                                    System.out.println("Apadrinhamento não encontrado.");
                                }

                                flagMenu4 = false;
                                break;
                            case "4":
                                System.out.println("");
                                System.out.println("=========================");
                                System.out.println("ATUALIZAR CADASTRO DE APADRINHAMENTO");
                                System.out.println("=========================");
                                System.out.println("");

                                System.out.print("Digite o ID do apadrinhamento a ser atualizdo: ");
                                int idAtualizaApadrinhamento = sc2.nextInt();

                                ApadrinhamentoDAO apd3 = new ApadrinhamentoDAO();

                                Apadrinhamento apadrinhamentoAtt = apd3.buscarPorId(idAtualizaApadrinhamento);
                                if (apadrinhamentoAtt != null) {
                                    System.out.print("Digite a nova quantia: ");
                                    apadrinhamentoAtt.setQuantiaMensal(sc1.nextDouble());
                                    apd3.atualiza(apadrinhamentoAtt);
                                }

                                flagMenu4 = false;
                                break;
                            case "5":
                                System.out.println("");
                                System.out.println("=========================");
                                System.out.println("EXCLUIR CADASTRO DE APADRINHAMENTO");
                                System.out.println("=========================");
                                System.out.println("");

                                System.out.print("Digite o ID do apadrinhamento a ser excluído: ");
                                int idExcluirApadrinhamento = sc2.nextInt();

                                ApadrinhamentoDAO apd4 = new ApadrinhamentoDAO();

                                apd4.exclui(idExcluirApadrinhamento);

                                flagMenu4 = false;
                                break;
                            case "6":
                                System.out.println("Voltando para o menu anterior");
                                flagMenu4 = true;
                                break;
                            default:
                                System.out.println("Escolha dentre as opções do menu");
                        }
                    } while (flagMenu4 == false);

                    flagMenu1 = false;
                    break;
                case "4":
                    System.out.println("Até a próxima!");
                    flagMenu1 = true;
                    break;
                default:
                    System.out.println("Escolha dentre as opções do menu");
            }
        } while(flagMenu1 == false);
    }
}