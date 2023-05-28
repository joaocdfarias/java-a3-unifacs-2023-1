package com.unifacs;

import java.util.ArrayList;
import java.util.Scanner;

import com.unifacs.entidades.Aluno;
import com.unifacs.entidades.Professor;

public class Programa {

    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Professor> professores = new ArrayList<>();
    public static ArrayList<Aluno> alunos = new ArrayList<>();

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

        System.out.println("Bem-vindo(a) ao Sistema de Controle Acadêmico da UNIFACS");

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

            switch (opcaoSelecionada.toLowerCase()) {
                case "professor":
                    menu("professor");
                    break;

                case "aluno":
                    menu("aluno");
                    break;

                case "sair":
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("--------------------------------");
                    System.out.println("Opção inválida!");
                    System.out.println("--------------------------------");
                    break;
            }

        } while (!opcaoSelecionada.toLowerCase().equals("sair"));

        scanner.close();
    }

    public static void menu(String tipo) {
        String opcao;

        do {
            System.out.println("--------------------------------");
            System.out.println("Opção selecionada: " + tipo);
            System.out.println("--------------------------------");
            System.out.println("Digite uma das seguintes opções:");
            System.out.println("- Cadastrar");
            System.out.println("- Editar");
            System.out.println("- Buscar");
            System.out.println("- Listar");
            System.out.println("- Apagar");
            System.out.println("- Voltar");
            System.out.print("Digite aqui: ");
            opcao = scanner.next();
            System.out.println("--------------------------------");

            switch (opcao.toLowerCase()) {
                case "cadastrar":
                    if (tipo == "professor") {
                        criarProfessor();
                    } else {
                        criarAluno();
                    }
                    break;
                case "listar":
                    if (tipo == "professor") {
                        listarProfessores();
                    } else {
                        listarAlunos();
                    }
                    break;
                case "apagar":
                    if (tipo == "professor") {
                        apagarProfessor();
                    } else {
                        apagarAluno();
                    }
                    break;
                case "buscar":
                    if (tipo == "professor") {
                        buscarProfessor();
                    } else {
                        buscarAluno();
                    }
                    break;
                case "editar":
                    if (tipo == "professor") {
                        editarProfessor();
                    } else {
                        editarAluno();
                    }
                    break;
                case "voltar":
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (!opcao.toLowerCase().equals("voltar"));

    }

    public static void criarProfessor() {
        scanner.useDelimiter("\n");

        System.out.println("Insira os dados do professor");

        System.out.print("Nome: ");
        String nome = scanner.next();

        System.out.print("CPF: ");
        String cpf = scanner.next();

        System.out.print("RA: ");
        String ra = scanner.next();

        System.out.print("Departamento: ");
        String departamento = scanner.next();

        System.out.print("Horas Trabalhadas: ");
        int horasTrabalhadas = scanner.nextInt();

        System.out.print("Salário: ");
        double salario = scanner.nextDouble();

        System.out.print("Curso: ");
        String curso = scanner.next();

        System.out.println("--------------------------------");

        Professor professor = new Professor(nome, cpf, departamento, horasTrabalhadas, salario, ra, curso);
        professores.add(professor);
    }

    public static void criarAluno() {
        scanner.useDelimiter("\n");

        System.out.println("Insira os dados do aluno");

        System.out.print("Nome: ");
        String nome = scanner.next();

        System.out.print("CPF: ");
        String cpf = scanner.next();

        System.out.print("Período: ");
        String periodo = scanner.next();

        System.out.print("RA: ");
        String ra = scanner.next();

        System.out.print("Curso: ");
        String curso = scanner.next();

        System.out.println("--------------------------------");

        Aluno aluno = new Aluno(nome, cpf, periodo, ra, curso);
        alunos.add(aluno);

    }

    public static void listarProfessores() {
        System.out.println("| Nome | Curso | RA |");

        if (professores.isEmpty()) {
            System.out.println("Nenhum cadastro encontrado.");
            return;
        }

        for (Professor professor : professores) {
            String nome, curso, ra;

            nome = professor.getNome();
            curso = professor.getCurso();
            ra = professor.getRa();

            System.out.printf("| %s | %s | %s |", nome, curso, ra);
            System.out.println();
        }
    }

    public static void listarAlunos() {
        System.out.println("| Nome | Curso | RA |");

        if (alunos.isEmpty()) {
            System.out.println("Nenhum cadastro encontrado.");
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
    }

    public static void apagarProfessor() {

        if (professores.isEmpty()) {
            System.out.println("Nenhum cadastro encontrado.");
            return;
        }

        System.out.print("Digite o RA do professor que deseja apagar: ");
        String ra = scanner.next();
        professores.removeIf(professor -> (professor.getRa().equals(ra)));
        System.out.printf("O professor com RA %s foi apagado!", ra);
        System.out.println(" ");
        System.out.println("--------------------------------");
        listarProfessores();
    }

    public static void apagarAluno() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum cadastro encontrado.");
            return;
        }

        System.out.print("Digite o RA do aluno que deseja apagar: ");
        String ra = scanner.next();
        alunos.removeIf(aluno -> (aluno.getRa().equals(ra)));
        System.out.printf("O aluno com RA %s foi apagado!", ra);
        System.out.println(" ");
        System.out.println("--------------------------------");
        listarAlunos();
    }

    public static void buscarProfessor() {
        if (professores.isEmpty()) {
            System.out.println("Nenhum cadastro encontrado.");
            return;
        }

        System.out.print("Digite o RA do professor que deseja buscar: ");
        String raInput = scanner.next();

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
                System.out.println("| Nome | RA | Curso | Horas Trabalhadas | Salário |");
                System.out.printf("| %s | %s | %s | %d | %.2f |", nome, ra, curso, horasTrabalhadas, salario);
                System.out.println();
            } else {
                System.out.println("Professor não encontrado.");
            }
        }
    }

    public static void buscarAluno() {
        if (professores.isEmpty()) {
            System.out.println("Nenhum cadastro encontrado.");
            return;
        }

        System.out.print("Digite o RA do aluno que deseja buscar: ");
        String raInput = scanner.next();

        for (Aluno aluno : alunos) {
            String nome, curso, ra, periodo, cpf;

            nome = aluno.getNome();
            curso = aluno.getCurso();
            ra = aluno.getRa();
            periodo = aluno.getPeriodo();
            cpf = aluno.getCpf();

            if (aluno.getRa().equals(raInput)) {
                System.out.println("| Nome | RA | Curso | Período | CPF |");
                System.out.printf("| %s | %s | %s | %s | %s |", nome, ra, curso, periodo, cpf);
                System.out.println();
            } else {
                System.out.println("Aluno não encontrado.");
            }
        }
    }

    public static void editarProfessor() {
        if (professores.isEmpty()) {
            System.out.println("Nenhum cadastro encontrado.");
            return;
        }

        System.out.print("Digite o RA do professor que deseja editar: ");
        String raInput = scanner.next();

        for (Professor professor : professores) {
            String nome, curso, ra;
            int horasTrabalhadas;
            double salario;
            String editarPropriedade;

            if (professor.getRa().equals(raInput)) {
                System.out.println("Digite uma das seguintes propriedades que deseja editar: ");
                System.out.println("- Curso");
                System.out.println("- Departamento");
                System.out.println("- Salário");
                System.out.print("Digite aqui: ");
                editarPropriedade = scanner.next();
                System.out.println("--------------------------------");

                switch (editarPropriedade.toLowerCase()) {
                    case "curso":
                        System.out.println("Novo curso: ");
                        String novoCurso = scanner.next();
                        professor.setCurso(novoCurso);
                        break;
                    case "departamento":
                        System.out.println("Novo departamento: ");
                        String novoDepartamento = scanner.next();
                        professor.setDepartamento(novoDepartamento);
                        break;
                    case "salario":
                        System.out.println("Novo salário: ");
                        double novoSalario = scanner.nextDouble();
                        professor.setSalario(novoSalario);
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }

                nome = professor.getNome();
                curso = professor.getCurso();
                salario = professor.getSalario();
                ra = professor.getRa();
                horasTrabalhadas = professor.getHorasTrab();

                System.out.println("| Nome | RA | Curso | Horas Trabalhadas | Salário |");
                System.out.printf("| %s | %s | %s | %d | %.2f |", nome, ra, curso, horasTrabalhadas, salario);
                System.out.println();
            } else {
                System.out.println("Professor não encontrado.");
            }
        }
    }

    public static void editarAluno() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum cadastro encontrado.");
            return;
        }

        System.out.print("Digite o RA do aluno que deseja editar: ");
        String raInput = scanner.next();

        for (Aluno aluno : alunos) {
            String nome, curso, ra, periodo, cpf;
            String editarPropriedade;

            if (aluno.getRa().equals(raInput)) {
                System.out.println("Digite uma das seguintes propriedades que deseja editar: ");
                System.out.println("- Curso");
                System.out.println("- Período");
                System.out.print("Digite aqui: ");
                editarPropriedade = scanner.next();
                System.out.println("--------------------------------");

                switch (editarPropriedade.toLowerCase()) {
                    case "curso":
                        System.out.println("Novo curso: ");
                        String novoCurso = scanner.next();
                        aluno.setCurso(novoCurso);
                        break;
                    case "periodo":
                        System.out.println("Novo período: ");
                        String novoPeriodo = scanner.next();
                        aluno.setPeriodo(novoPeriodo);
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }

                nome = aluno.getNome();
                curso = aluno.getCurso();
                ra = aluno.getRa();
                periodo = aluno.getPeriodo();
                cpf = aluno.getCpf();

                System.out.println("| Nome | RA | Curso | Período | CPF |");
                System.out.printf("| %s | %s | %s | %s | %s |", nome, ra, curso, periodo, cpf);
                System.out.println();
            } else {
                System.out.println("Professor não encontrado.");
            }
        }
    }
}
