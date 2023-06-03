package com.unifacs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.unifacs.entidades.Aluno;
import com.unifacs.entidades.Professor;

public class Programa {

    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Professor> professores = new ArrayList<>();
    public static ArrayList<Aluno> alunos = new ArrayList<>();

    // Classe principal do programa, ela vai ser responsável por definir os objetos
    // das classes Professor e Aluno
    // também ficará responsável por chamar os outros métodos e funções criados no
    // programa.
    public static void main(String[] args) {
        Professor professor = new Professor("Joao", "123", "ti", 24, 4000, "123", "CC");
        Professor professor2 = new Professor("Carlos", "321", "humanas", 44, 8000, "321", "Geografia");
        Professor professor3 = new Professor("Hanspeter", "456", "exatas", 34, 10000, "456", "Matemática");
        professores.add(professor);
        professores.add(professor2);
        professores.add(professor3);

        Aluno aluno = new Aluno("João", "123456", "Noturno", "73812721100", "CC");
        Aluno aluno2 = new Aluno("Junior", "654321", "Diurno", "987654321342", "Geografia");
        Aluno aluno3 = new Aluno("Gabriel", "987654", "Noturno", "7893012543", "Matemática");
        Aluno aluno4 = new Aluno("Vinícius", "567890", "Diurno", "123456789532", "CC");
        alunos.add(aluno);
        alunos.add(aluno2);
        alunos.add(aluno3);
        alunos.add(aluno4);

        String opcaoSelecionada;

        System.out.println("\u001B[34mBem-vindo(a) ao Sistema de Controle Acadêmico da UNIFACS\u001B[0m");

        // Do...While feito para exibir as opções do Menu no terminal. O menu será
        // exibido até o usuário digitar "sair" no terminal
        do {
            System.out.println("MENU");
            System.out.println("--------------------------------");
            System.out.println("Digite uma das seguintes opções:");
            System.out.println("- Professor");
            System.out.println("- Aluno");
            System.out.println("- Sair");
            System.out.println("--------------------------------");
            System.out.print("Digite aqui: ");
            opcaoSelecionada = scanner.nextLine();
            System.out.println("--------------------------------");

            // Switch...Case criado para selecionar as opções que existem no menu, sao elas:
            // Professor, Aluno e Sair.

            // Foi colocado também o método toLowerCase() na variável opcaoSelecionada que é
            // uma instância do Scanner
            // esse método vai ser responsável por tirar a letras maiúsculas do que for
            // digitado pelo usuário
            // dessa forma ficará garantido que se o usuário digitar "PROFESSOR",
            // "Professor", "pRofessor". Ou qualquer
            // outro jeito, ele transformará para "professor" e não terá o erro "Opção
            // inválida!".
            switch (opcaoSelecionada.toLowerCase()) {
                // Caso o usuário digite "professor" a função menu() será executada passando o
                // parâmetro professor que é do tipo String
                // esse parâmetro será utilizado somente para fazer o print no terminal com a
                // opção selecionada.
                case "professor":
                    menu("professor");
                    break;

                // O mesmo ocorrerá caso o usuário digite "aluno", o parâmetro será utilizado
                // somente para exibir no terminal.
                case "aluno":
                    menu("aluno");
                    break;

                // Caso "sair" seja digitado o texto "Saindo..." será exibido no terminal e logo
                // após ocorrerá o break que irá sair do
                // switch...case e cairá no while e como "sair" foi digitado, ele vai encerrar o
                // loop do while e encerrará a execução
                // do programa
                case "sair":
                    System.out.println("Saindo...");
                    break;

                // Se o usuário inserir qualquer outro texto sem ser "Sair", "Professor" ou
                // "Aluno". O terminal irá exibir o texto
                // "Opção inválida!" e voltará para o usuário digitar outro texto válido no menu
                default:
                    System.out.println("--------------------------------");
                    System.out.println("Opção inválida!");
                    System.out.println("--------------------------------");
                    break;
            }

            // Mesmo caso do método toLowerCase() anterior, é utilizado para garantir que o
            // usuário não tenha o erro "Opção inválida!"
            // caso seja digitado "sair" de qualquer outra forma.
        } while (!opcaoSelecionada.toLowerCase().equals("sair"));

        scanner.close();
    }

    // Função responsável por exibir o menu com as opções de "Cadastrar", "Editar",
    // "Buscar", "Listar" e "Apagar", ou seja, um CRUD. Essa função recebe o
    // parâmetro
    // tipo para ser exibido no cabeçalho do menu.
    public static void menu(String tipo) {
        String opcao;

        // Do...while responsável por exibir o menu interno para as operações CRUD
        // do cadastro de alunos e professores
        do {
            System.out.println("--------------------------------");
            System.out.println("Opção selecionada: " + tipo);
            System.out.println("--------------------------------");
            System.out.println("Digite uma das seguintes opções:");
            System.out.println("- Cadastrar");
            System.out.println("- Editar");
            System.out.println("- Buscar");
            System.out.println("- Listar");
            System.out.println("- Ordenar");
            System.out.println("- Apagar");
            System.out.println("- Voltar");
            System.out.print("Digite aqui: ");
            opcao = scanner.nextLine();
            System.out.println("--------------------------------");

            // O método toLowerCase() também foi utilizado aqui para caso o usuário
            // digite os comandos de outra forma o programa não exiba a mensagem
            // "Opção inválida!"

            // Este switch...case vai funcionar da mesma forma que o anterior, porém,
            // ele possui um if...else dentro dele para verificar se o tipo é professor
            // ou não. Se for professor ele executará as funções responsáveis pelo
            // CRUD de professores, senão, as funções de CRUD de aluno serão executadas.
            switch (opcao.toLowerCase()) {
                case "cadastrar":
                    if (tipo.equals("professor")) {
                        criarProfessor();
                    } else {
                        criarAluno();
                    }
                    break;
                case "listar":
                    if (tipo.equals("professor")) {
                        listarProfessores();
                    } else {
                        listarAlunos();
                    }
                    break;
                case "apagar":
                    if (tipo.equals("professor")) {
                        apagarProfessor();
                    } else {
                        apagarAluno();
                    }
                    break;
                case "buscar":
                    if (tipo.equals("professor")) {
                        buscarProfessor();
                    } else {
                        buscarAluno();
                    }
                    break;
                case "ordenar":
                    ordernar(tipo);
                    break;
                case "editar":
                    if (tipo.equals("professor")) {
                        editarProfessor();
                    } else {
                        editarAluno();
                    }
                    break;
                case "voltar":
                    break;
                default:
                    System.out.println("--------------------------------");
                    System.out.println("Opção inválida!");
                    System.out.println("--------------------------------");
                    break;
            }
        } while (!opcao.toLowerCase().equals("voltar"));

    }

    // Essa função é responsável criar um novo professor na array de professores
    // ele pedirá ao usuário para inserir os dados necesários para criar
    // um professor. Esses dados inseridos são salvos em variáveis para depois
    // serem inseridas na instância da classe professor.
    public static void criarProfessor() {
        System.out.println("Insira os dados do professor");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("RA: ");
        String ra = scanner.nextLine();

        System.out.print("Departamento: ");
        String departamento = scanner.nextLine();

        System.out.print("Horas Trabalhadas: ");
        int horasTrabalhadas = scanner.nextInt();

        System.out.print("Salário: ");
        double salario = scanner.nextDouble();

        // Se um nextLine é utilizado depois de um next com tipo primitivo
        // ele pula a última linha a ser lida pelo scanner
        scanner.nextLine();

        System.out.print("Curso: ");
        String curso = scanner.nextLine();
        System.out.println("Aperte Enter para continuar");
        scanner.nextLine();

        System.out.println("--------------------------------");

        Professor professor = new Professor(nome, cpf, departamento, horasTrabalhadas, salario, ra, curso);

        // Após inserir o dados do professor na instância da classe Professor, os dados
        // serão inseridos na array de professores com o método add do ArrayList.
        professores.add(professor);

        // A função listarProfessores é chamada para mostrar a tabela com os professores
        // e o professor novo criado
        listarProfessores();
    }

    // A função criarAluno seguirá os mesmos passos da função criarProfessor, porém
    // vai inserir dados diferentes na instância da classe Aluno.
    public static void criarAluno() {
        System.out.println("Insira os dados do aluno");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Período: ");
        String periodo = scanner.nextLine();

        System.out.print("RA: ");
        String ra = scanner.nextLine();

        System.out.print("Curso: ");
        String curso = scanner.nextLine();
        System.out.println("Aperte Enter para continuar");
        scanner.nextLine();

        System.out.println("--------------------------------");

        Aluno aluno = new Aluno(nome, cpf, periodo, ra, curso);
        alunos.add(aluno);

        // A função listarAlunos é chamada para mostrar a tabela com os alunos
        // e o aluno novo criado
        listarAlunos();
    }

    // A função listarProfessores exibe uma lista de forma tabular
    // de todos os professores que estão "cadastrados" na Array de professores
    public static void listarProfessores() {
        System.out.println("| Nome | Curso | RA |");

        // A ArrayList possui um método chamado isEmpty() que retorna um boolean
        // ele verifica se a array está vazia ou não. Caso esteja vazia irá
        // exibir o texto "Nenhum cadastro encontrado." e fará um return para
        // encerrar a execução dessa função.
        if (professores.isEmpty()) {
            System.out.println("Nenhum cadastro encontrado.");
            System.out.println("Aperte 'Enter' para voltar ao menu anterior.");
            scanner.nextLine();
            return;
        }

        // Esse forEach faz uma iteração na array de professores
        // e exibirá todos no padrão colocado no printf.
        for (Professor professor : professores) {
            String nome, curso, ra;

            nome = professor.getNome();
            curso = professor.getCurso();
            ra = professor.getRa();

            System.out.printf("| %s | %s | %s |", nome, curso, ra);
            System.out.println();
        }
            scanner.nextLine();
    }

    // Vai seguir o mesmo padrão de listarProfessores(), porém
    // com os atributos da classe Aluno
    public static void listarAlunos() {
        System.out.println("| Nome | Curso | RA |");

        if (alunos.isEmpty()) {
            System.out.println("Nenhum cadastro encontrado.");
            System.out.println("Aperte 'Enter' para voltar ao menu anterior.");
            scanner.nextLine();
            return;
        }

        for (Aluno aluno : alunos) {
            String nome, curso, ra;

            nome = aluno.getNome();
            curso = aluno.getCurso();
            ra = aluno.getRa();

            System.out.printf("| %s | %s | %s |", nome, curso, ra);
            System.out.println();
        }
            scanner.nextLine();
    }

    // Função responsável por apagar professor da array de professores
    // vai ser solicitado que digite o RA do professor que deseja
    // apagar e caso dê certo, irá exigir o texto
    // "O professor com o RA x foi apagado!"
    public static void apagarProfessor() {
        int tamanhoAntes = 0, tamanhoDepois = 0;

        if (professores.isEmpty()) {
            System.out.println("Nenhum cadastro encontrado.");
            System.out.println("Aperte 'Enter' para voltar ao menu anterior.");
            scanner.nextLine();
            return;
        }

        // Esse do...while é responsável por reexibir o texto para
        // inserir o RA do professor caso ele não seja encontrado
        do {
            System.out.print("Digite o RA do professor que deseja apagar: ");
            String ra = scanner.nextLine();

            System.out.printf("\u001B[31mDeseja mesmo apagar o professor com o RA %s? (sim/não) \u001B[0m", ra);
            String confirmarExclusao = scanner.nextLine();

            if (confirmarExclusao.toLowerCase().equals("sim")) {
                // Variável tamanho antes para verificar o tamanho da array de professores
                // antes de remover o professor
                tamanhoAntes = professores.size();

                // Expressão lambda responsável por percorrer a array de professores
                // e remover o professor da array caso a condição seja satisfeita
                // a condição neste caso é encontrar um professor na array de professores
                // com o mesmo RA passado pelo usuário no terminal
                professores.removeIf(professor -> (professor.getRa().equals(ra)));
                tamanhoDepois = professores.size();

                // Se o tamanhoAntes for maior que o tamanhoDepois exibirá o texto
                // "O professor com RA x foi apagado!", isso garante que o texto
                // não seja exibido se não encontrar nenhum professor.
                if (tamanhoDepois < tamanhoAntes) {
                    System.out.printf("O professor com RA %s foi apagado!", ra);
                    System.out.println(" ");
                    System.out.println("--------------------------------");
                    System.out.println("Aperte 'Enter' para voltar ao menu anterior.");
                    scanner.nextLine();
                    listarProfessores();
                } else {
                    System.out.printf("Professor com RA %s não encontrado!", ra);
                    System.out.println(" ");
                    System.out.println("--------------------------------");
                    System.out.println("Aperte 'Enter' para voltar ao menu anterior.");
                    scanner.nextLine();
                }
            } else {
                System.out.printf("Professor com RA %s não foi apagado!", ra);
                System.out.println(" ");
                System.out.println("Aperte 'Enter' para voltar ao menu anterior.");
                scanner.nextLine();
                return;
            }
        } while (!(tamanhoDepois < tamanhoAntes));

    }

    // Mesmo caso que a função anterior, porém irá apagar alunos
    // da array de alunos
    public static void apagarAluno() {
        int tamanhoAntes = 0, tamanhoDepois = 0;

        if (alunos.isEmpty()) {
            System.out.println("Nenhum cadastro encontrado.");
            System.out.println("Aperte 'Enter' para voltar ao menu anterior.");
            scanner.nextLine();
            return;
        }

        do {
            System.out.print("Digite o RA do aluno que deseja apagar: ");
            String ra = scanner.nextLine();

            System.out.printf("\u001B[31mDeseja mesmo apagar o aluno com o RA %s? (sim/não) \u001B[0m", ra);
            String confirmarExclusao = scanner.nextLine();

            if (confirmarExclusao.toLowerCase().equals("sim")) {
                tamanhoAntes = alunos.size();
                alunos.removeIf(aluno -> (aluno.getRa().equals(ra)));
                tamanhoDepois = alunos.size();

                if (tamanhoDepois < tamanhoAntes) {
                    System.out.printf("O aluno com RA %s foi apagado!", ra);
                    System.out.println(" ");
                    System.out.println("--------------------------------");
                    listarAlunos();
                } else {
                    System.out.printf("Aluno com RA %s não encontrado!", ra);
                    System.out.println(" ");
                    System.out.println("--------------------------------");
                }
            } else {
                System.out.printf("Aluno com RA %s não foi apagado!", ra);
                System.out.println(" ");
                System.out.println("Aperte 'Enter' para voltar ao menu anterior.");
                scanner.nextLine();
                return;
            }
        } while (!(tamanhoDepois < tamanhoAntes));

    }

    // Função buscarProfessor primeiro irá verificar se a array
    // de professores não está vazia, se não estiver, vai seguir
    // para o restante da função.
    public static void buscarProfessor() {
        boolean encontrado = false;

        if (professores.isEmpty()) {
            System.out.println("Nenhum cadastro encontrado.");
            System.out.println("Aperte 'Enter' para voltar ao menu anterior.");
            scanner.nextLine();
            return;
        }

        // O programa vai pedir para inserir o RA do professor que deseja
        // buscar, caso não encontre irá retornar o texto "Professro não encontrado"
        System.out.print("Digite o RA do professor que deseja buscar: ");
        String raInput = scanner.nextLine();

        for (Professor professor : professores) {
            String ra, curso, nome;
            double salario;
            int horasTrabalhadas;

            nome = professor.getNome();
            curso = professor.getCurso();
            salario = professor.getSalario();
            ra = professor.getRa();
            horasTrabalhadas = professor.getHorasTrab();

            if (professor.getRa().equals(raInput)) {
                encontrado = true;
                // Caso encontre o professor, vai exibir seus 5 atributos em formato tabular
                System.out.println("| Nome | RA | Curso | Horas Trabalhadas | Salário |");
                System.out.printf("| %s | %s | %s | %d | %.2f |", nome, ra, curso, horasTrabalhadas, salario);
                System.out.println(" ");
                System.out.println("Aperte 'Enter' para voltar ao menu anterior.");
                scanner.nextLine();
            }
        }

        if (!encontrado) {
            System.out.println("Professor não encontrado.");
            System.out.println("Aperte 'Enter' para voltar ao menu anterior.");
            scanner.nextLine();
        }
    }

    // O mesmo que a função buscarProfessor, porém, irá mostrar os
    // 5 atributos da classe aluno.
    public static void buscarAluno() {
        boolean encontrado = false;

        if (professores.isEmpty()) {
            System.out.println("Nenhum cadastro encontrado.");
            return;
        }

        System.out.print("Digite o RA do aluno que deseja buscar: ");
        String raInput = scanner.nextLine();

        for (Aluno aluno : alunos) {
            String nome, curso, ra, periodo, cpf;

            nome = aluno.getNome();
            curso = aluno.getCurso();
            ra = aluno.getRa();
            periodo = aluno.getPeriodo();
            cpf = aluno.getCpf();

            if (aluno.getRa().equals(raInput)) {
                encontrado = true;
                System.out.println("| Nome | RA | Curso | Período | CPF |");
                System.out.printf("| %s | %s | %s | %s | %s |", nome, ra, curso, periodo, cpf);
                System.out.println();
                System.out.println("Aperte 'Enter' para voltar ao menu anterior.");
                scanner.nextLine();
            }
        }

        if (!encontrado) {
            System.out.println("Aluno não encontrado.");
            System.out.println("Aperte 'Enter' para voltar ao menu anterior.");
            scanner.nextLine();

        }
    }

    // Função que irá editar um professor, buscando-o por RA
    public static void editarProfessor() {
        boolean encontrado = false;

        if (professores.isEmpty()) {
            System.out.println("Nenhum cadastro encontrado.");
            return;
        }

        System.out.print("Digite o RA do professor que deseja editar: ");
        String raInput = scanner.nextLine();

        for (Professor professor : professores) {
            String nome, curso, ra;
            int horasTrabalhadas;
            double salario;
            String editarPropriedade;

            // Se encontrar um professor ele entrará nessa verificação
            // que pedirá para digitar qual propriedade/atributos
            // do professor que o usuário deseja editar
            if (professor.getRa().equals(raInput)) {
                encontrado = true;

                System.out.println("Digite uma das seguintes propriedades que deseja editar: ");
                System.out.println("- Curso");
                System.out.println("- Departamento");
                System.out.println("- Salário");
                System.out.print("Digite aqui: ");
                editarPropriedade = scanner.nextLine();
                System.out.println("--------------------------------");

                // Esse switch case ficará responsável por verificar qual comando
                // foi inserido no terminal, para assim, fazer a edição da propriedade
                // escolhida.
                switch (editarPropriedade.toLowerCase()) {
                    case "curso":
                        System.out.println("Novo curso: ");
                        String novoCurso = scanner.nextLine();
                        professor.setCurso(novoCurso);
                        break;
                    case "departamento":
                        System.out.println("Novo departamento: ");
                        String novoDepartamento = scanner.nextLine();
                        professor.setDepartamento(novoDepartamento);
                        break;
                    case "salario":
                        System.out.println("Novo salário: ");
                        double novoSalario = scanner.nextDouble();
                        professor.setSalario(novoSalario);
                        break;
                    default:
                        // Caso o usuário insira alguma opção inválida, este texto
                        // será exibido no terminal
                        System.out.println("Opção inválida!");
                        System.out.println("Aperte 'Enter' para voltar ao menu anterior.");
                        scanner.nextLine();
                        break;
                }

                nome = professor.getNome();
                curso = professor.getCurso();
                salario = professor.getSalario();
                ra = professor.getRa();
                horasTrabalhadas = professor.getHorasTrab();

                // Após editar o professor a lista de professores será exibida com os novos
                // dados inseridos anteriormente
                System.out.println("| Nome | RA | Curso | Horas Trabalhadas | Salário |");
                System.out.printf("| %s | %s | %s | %d | %.2f |", nome, ra, curso, horasTrabalhadas, salario);
                System.out.println(" ");
                System.out.println("Aperte 'Enter' para voltar ao menu anterior.");
                scanner.nextLine();
            }
        }

        if (!encontrado) {
            System.out.println("Professor não encontrado.");
            System.out.println("Aperte 'Enter' para voltar ao menu anterior.");
            scanner.nextLine();
        }
    }

    // Fará o mesmo que a função editarProfessor, porém com atributos
    // da classe aluno
    public static void editarAluno() {
        boolean encontrado = false;

        if (alunos.isEmpty()) {
            System.out.println("Nenhum cadastro encontrado.");
            System.out.println("Aperte 'Enter' para voltar ao menu anterior.");
            scanner.nextLine();
            return;
        }

        System.out.print("Digite o RA do aluno que deseja editar: ");
        String raInput = scanner.nextLine();

        for (Aluno aluno : alunos) {
            String nome, curso, ra, periodo, cpf;
            String editarPropriedade;

            if (aluno.getRa().equals(raInput)) {
                encontrado = true;

                System.out.println("Digite uma das seguintes propriedades que deseja editar: ");
                System.out.println("- Curso");
                System.out.println("- Período");
                System.out.print("Digite aqui: ");
                editarPropriedade = scanner.nextLine();
                System.out.println("--------------------------------");

                switch (editarPropriedade.toLowerCase()) {
                    case "curso":
                        System.out.println("Novo curso: ");
                        String novoCurso = scanner.nextLine();
                        aluno.setCurso(novoCurso);
                        break;
                    case "periodo":
                        System.out.println("Novo período: ");
                        String novoPeriodo = scanner.nextLine();
                        aluno.setPeriodo(novoPeriodo);
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        System.out.println("Aperte 'Enter' para voltar ao menu anterior.");
                        scanner.nextLine();
                        break;
                }

                nome = aluno.getNome();
                curso = aluno.getCurso();
                ra = aluno.getRa();
                periodo = aluno.getPeriodo();
                cpf = aluno.getCpf();

                System.out.println("| Nome | RA | Curso | Período | CPF |");
                System.out.printf("| %s | %s | %s | %s | %s |", nome, ra, curso, periodo, cpf);
                System.out.println(" ");
                System.out.println("Aperte 'Enter' para voltar ao menu anterior.");
                scanner.nextLine();
            }
        }

        if (!encontrado) {
            System.out.println("Aluno não encontrado.");
            System.out.println("Aperte 'Enter' para voltar ao menu anterior.");
            scanner.nextLine();
        }
    }

    public static void ordernar(String tipo) {
        if(tipo.equals("professor")) {
            // Ordenar a lista de professores por nome
            Collections.sort(professores);
            System.out.println("Lista de professores ordenada!");
            listarProfessores();
            
        }else {
            // Ordenar a lista de alunos por nome
            Collections.sort(alunos);
            System.out.println("Lista de alunos ordenada!");
            listarAlunos();
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
