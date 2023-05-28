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
        Professor professor = new Professor("Joao", "123", "ti", 24, 24000, "123", "CC");
        professores.add(professor);

        Aluno aluno = new Aluno("Carlos", "123456", "Noturno", "123456789", "CC");
        alunos.add(aluno);

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
            System.out.println("- Ler");
            System.out.println("- Apagar");
            System.out.println("- Voltar");
            System.out.print("Digite aqui: ");
            opcao = scanner.next();

            switch (opcao.toLowerCase()) {
                case "cadastrar":
                    if (tipo == "professor") {
                        criarProfessor();
                    } else {
                        criarAluno();
                    }
                    break;
                case "ler":
                    if (tipo == "professor") {
                        lerProfessor();
                    } else {
                        lerAluno();
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

    public static void lerProfessor() {
        System.out.println("| Nome | Curso | Salário |");

        if (professores.isEmpty()) {
            System.out.println("Nenhum cadastro encontrado.");
            return;
        }

        for (Professor professor : professores) {
            String nome, curso;
            double salario;

            nome = professor.getNome();
            curso = professor.getCurso();
            salario = professor.getSalario();

            System.out.printf("| %s | %s | R$ %.2f |", nome, curso, salario);
            System.out.println();
        }
    }

    public static void lerAluno() {
        System.out.println("| Nome | Curso | Período |");

        if (alunos.isEmpty()) {
            System.out.println("Nenhum cadastro encontrado.");
            return;
        }

        for (Aluno aluno : alunos) {
            String nome, curso, periodo;

            nome = aluno.getNome();
            curso = aluno.getCurso();
            periodo = aluno.getPeriodo();

            System.out.printf("| %s | %s | %s |", nome, curso, periodo);
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
        System.out.println("--------------------------------");
    }

    public static void apagarAluno() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum cadastro encontrado.");
            return;
        }

        System.out.print("Digite o RA do aluno que deseja apagar: ");
        String ra = scanner.next();
        professores.removeIf(aluno -> (aluno.getRa().equals(ra)));
        System.out.printf("O aluno com RA %s foi apagado!", ra);
        System.out.println("--------------------------------");
    }

    public static void buscarProfessor() {
        if (professores.isEmpty()) {
            System.out.println("Nenhum cadastro encontrado.");
            return;
        }

        System.out.print("Digite o RA do professor que deseja buscar: ");
        String raInput = scanner.next();

        for (Professor professor : professores) {
            String ra, curso;
            double salario;

            ra = professor.getNome();
            curso = professor.getCurso();
            salario = professor.getSalario();

            if (professor.getRa().equals(raInput)) {
                System.out.println("| Nome | Curso | Salário |");
                System.out.printf("| %s | %s | R$ %.2f |", ra, curso, salario);
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
            String nome, curso, ra;

            nome = aluno.getNome();
            curso = aluno.getCurso();
            ra = aluno.getRa();

            if (aluno.getRa().equals(raInput)) {
                System.out.println("| Nome | Curso | RA |");
                System.out.printf("| %s | %s | R$ %.2f |", nome, curso, ra);
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
