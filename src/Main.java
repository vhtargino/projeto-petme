import java.util.ArrayList;
import static Coletar.Coletar.*;

public class Main {

    public static void main(String[] args) {

        boolean flagMenu1 = false;

        while (!flagMenu1) {
            System.out.println("""
                                \n=========================
                                Escolha uma das opções:
                                1. Padrinho
                                2. Pet
                                3. Apadrinhamento
                                4. Sair
                                =========================
                                """);
            int escolhaMenu1 = coletarInt
                    ("Sua escolha: ", 1, 4);

            switch(escolhaMenu1) {
                case 1 -> {
                    boolean flagMenu2 = false;
                    do {
                        System.out.println("""
                                \n=========================
                                O que deseja fazer?
                                1. Cadastrar padrinho
                                2. Listar padrinhos
                                3. Pesquisar padrinho
                                4. Atualizar cadastro de padrinho
                                5. Excluir cadastro de padrinho
                                6. Voltar
                                =========================
                                """);

                        int escolhaMenu2 = coletarInt
                                ("Sua escolha: ", 1, 6);

                        switch (escolhaMenu2) {
                            case 1 -> {
                                System.out.println("""
                                        \n=========================
                                        CADASTRAR PADRINHO
                                        =========================                            
                                        """);

                                Pessoa p1 = new Pessoa(
                                        coletarString("Digite o nome do padrinho: "),
                                        coletarString("Digite a cidade do padrinho: "),
                                        coletarString("Digite o estado do padrinho: ", 2),
                                        coletarString("Digite o e-mail do padrinho: "),
                                        coletarString("Digite o Whatsapp do padrinho: ")
                                );

                                PessoaDAO pd1 = new PessoaDAO();
                                pd1.adiciona(p1);
                            }
                            case 2 -> {
                                System.out.println("""
                                        \n=========================
                                        LISTAR PADRINHOS
                                        =========================                            
                                        """);

                                Pessoa.listarPessoas();

                            }
                            case 3 -> {
                                System.out.println("""
                                        \n=========================
                                        PESQUISAR PADRINHO
                                        =========================                              
                                        """);

                                int idBuscaPessoa = coletarInt
                                        ("Digite o ID do padrinho: ");

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

                            }
                            case 4 -> {
                                System.out.println("""
                                        \n=========================
                                        ATUALIZAR CADASTRO DE PADRINHO
                                        =========================                             
                                        """);

                                int idAtualizaPessoa = coletarInt
                                        ("Digite o ID do padrinho a ser atualizdo: ");

                                PessoaDAO pd4 = new PessoaDAO();

                                Pessoa pessoaAtt = pd4.buscarPorId(idAtualizaPessoa);
                                if (pessoaAtt != null) {
                                    pessoaAtt.setNomePessoa
                                            (coletarString("Digite o novo nome: "));
                                    pd4.atualiza(pessoaAtt);
                                }

                            }
                            case 5 -> {
                                System.out.println("""
                                        \n=========================
                                        EXCLUIR CADASTRO DE PADRINHO
                                        =========================                             
                                        """);

                                int idExcluirPessoa = coletarInt
                                        ("Digite o ID do padrinho a ser excluído: ");

                                PessoaDAO pd5 = new PessoaDAO();

                                pd5.exclui(idExcluirPessoa);

                            }
                            case 6 -> {
                                System.out.println("Voltando para o menu anterior.");
                                flagMenu2 = true;
                            }
                        }
                    } while (!flagMenu2);

                }
                case 2 -> {
                    boolean flagMenu3 = false;

                    do {
                        System.out.println("""
                                            \n=========================
                                            O que deseja fazer?
                                            1. Cadastrar pet
                                            2. Listar pet
                                            3. Pesquisar pet
                                            4. Atualizar cadastro de pet
                                            5. Excluir cadastro de pet
                                            6. Voltar
                                            =========================
                                            """);

                        int escolhaMenu3 = coletarInt
                                ("Sua escolha: ", 1, 6);

                        switch (escolhaMenu3) {
                            case 1 -> {
                                System.out.println("""
                                        \n=========================
                                        CADASTRAR PET
                                        =========================                                          
                                        """);

                                int especie = coletarInt
                                        ("""
                                                1. Cachorro
                                                2. Gato

                                                Sua resposta: """,1, 2);

                                Animal a1;

                                if (especie == 1) {
                                    a1 = new Cachorro();
                                } else {
                                    a1 = new Gato();
                                }

                                a1.setNomeAnimal(coletarString("Digite o nome: "));
                                a1.setColoracao(coletarString("Digite a coloração: "));

                                AnimalDAO ad1 = new AnimalDAO();
                                ad1.adiciona(a1);
                            }
                            case 2 -> {
                                System.out.println("""
                                        \n=========================
                                        LISTAR PETS
                                        =========================                                                  
                                        """);


                                Animal.listarAnimais();

                            }
                            case 3 -> {
                                System.out.println("""
                                        \n=========================
                                        PESQUISAR PET
                                        =========================                                                  
                                        """);

                                int idBuscaAnimal = coletarInt
                                        ("Digite o ID do pet: ");

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

                            }
                            case 4 -> {
                                System.out.println("""
                                        \n=========================
                                        ATUALIZAR CADASTRO DE PET
                                        =========================                                                 
                                        """);

                                int idAtualizaAnimal = coletarInt
                                        ("Digite o ID do pet a ser atualizado: ");

                                AnimalDAO ad4 = new AnimalDAO();

                                Animal animalAtt = ad4.buscarPorId(idAtualizaAnimal);
                                if (animalAtt != null) {
                                    animalAtt.setNomeAnimal(coletarString
                                            ("Digite o novo nome: "));
                                    ad4.atualiza(animalAtt);
                                }

                            }
                            case 5 -> {
                                System.out.println("""
                                        \n=========================
                                        EXCLUIR CADASTRO DE PET
                                        =========================                                                   
                                        """);

                                int idExcluirPet = coletarInt
                                        ("Digite o ID do pet a ser excluído: ");

                                AnimalDAO ad5 = new AnimalDAO();

                                ad5.exclui(idExcluirPet);

                            }
                            case 6 -> {
                                System.out.println("Voltando para o menu anterior.");
                                flagMenu3 = true;
                            }
                        }
                    } while (!flagMenu3);

                }
                case 3 -> {
                    boolean flagMenu4 = false;

                    do {
                        System.out.println("""
                                            \n=========================
                                            O que deseja fazer?
                                            1. Cadastrar apadrinhamento
                                            2. Listar apadrinhamentos
                                            3. Pesquisar apadrinhamento
                                            4. Atualizar cadastro de apadrinhamento
                                            5. Excluir cadastro de apadrinhamento
                                            6. Voltar
                                            =========================
                                            """);

                        int escolhaMenu4 = coletarInt
                                ("Sua escolha: ", 1, 6);

                        switch (escolhaMenu4) {
                            case 1 -> {
                                System.out.println("""
                                        \n=========================
                                        CADASTRAR APADRINHAMENTO
                                        =========================                                        
                                        """);

                                Apadrinhamento ap = new Apadrinhamento();

                                ap.setQuantiaMensal(coletarDouble
                                        ("Digite a quantia mensal: "));

                                PessoaDAO pd = new PessoaDAO();
                                ArrayList<Pessoa> pessoas = pd.listar();
                                Pessoa.listarPessoas();

                                boolean flagId = false;
                                int contador = 0;
                                do {
                                    int idPadrinho = coletarInt
                                            ("Digite o ID do padrinho: ");

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
                                        }
                                    }
                                } while (!flagId);

                                AnimalDAO ad = new AnimalDAO();
                                ArrayList<Animal> animais = ad.listar();

                                Animal.listarAnimais();

                                flagId = false;
                                contador = 0;
                                do {
                                    int idPet = coletarInt
                                            ("Digite o ID do pet: ");

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
                                        }
                                    }
                                } while (!flagId);

                                ApadrinhamentoDAO apd = new ApadrinhamentoDAO();
                                apd.adiciona(ap);

                            }
                            case 2 -> {
                                System.out.println("""
                                        \n=========================
                                        LISTAR APADRINHAMENTOS
                                        =========================                                           
                                        """);

                                ApadrinhamentoDAO apd2 = new ApadrinhamentoDAO();

                                ArrayList<Apadrinhamento> apadrinhamentos = apd2.listar();
                                for (Apadrinhamento apadrinhamento : apadrinhamentos) {
                                    System.out.println("ID: " + apadrinhamento.getIdApadrinhamento() +
                                            ", Quantia mensal: " + apadrinhamento.getQuantiaMensal() +
                                            ", ID do padrinho: " + apadrinhamento.getIdPessoaPadrinho() +
                                            ", ID do pet: " + apadrinhamento.getIdAnimalApadrinhado());
                                }

                            }
                            case 3 -> {
                                System.out.println("""
                                        \n=========================
                                        PESQUISAR APADRINHAMENTO
                                        =========================                                          
                                        """);

                                int idBuscaApadrinhamento = coletarInt
                                        ("Digite o ID do apadrinhamento: ");

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

                            }
                            case 4 -> {
                                System.out.println("""
                                        \n=========================
                                        ATUALIZAR CADASTRO DE APADRINHAMENTO
                                        =========================                                  
                                        """);

                                int idAtualizaApadrinhamento = coletarInt
                                        ("Digite o ID do apadrinhamento a ser atualizado: ");

                                ApadrinhamentoDAO apd3 = new ApadrinhamentoDAO();

                                Apadrinhamento apadrinhamentoAtt = apd3.buscarPorId(idAtualizaApadrinhamento);
                                if (apadrinhamentoAtt != null) {
                                    apadrinhamentoAtt.setQuantiaMensal(coletarDouble
                                            ("Digite a nova quantia: "));
                                    apd3.atualiza(apadrinhamentoAtt);
                                }

                            }
                            case 5 -> {
                                System.out.println("""
                                        \n=========================
                                        EXCLUIR CADASTRO DE APADRINHAMENTO
                                        =========================                                          
                                        """);

                                int idExcluirApadrinhamento = coletarInt
                                        ("Digite o ID do apadrinhamento a ser excluído: ");

                                ApadrinhamentoDAO apd4 = new ApadrinhamentoDAO();

                                apd4.exclui(idExcluirApadrinhamento);

                            }
                            case 6 -> {
                                System.out.println("Voltando para o menu anterior.");
                                flagMenu4 = true;
                            }
                        }
                    } while (!flagMenu4);

                }
                case 4 -> {
                    System.out.println("Até a próxima!");
                    flagMenu1 = true;
                }
            }
        }

        fecharScanner();
    }
}