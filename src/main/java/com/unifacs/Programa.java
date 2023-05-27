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
                    criarProfessor();
                    break;
                case "ler":
                    lerProfessor();
                    break;
                case "apagar":
                    apagarProfessor();
                    break;
                case "buscar":
                    buscarProfessor();
                    break;
                case "editar":
                    editarProfessor();
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

    public static void editarProfessor() {
        if (professores.isEmpty()) {
            System.out.println("Nenhum cadastro encontrado.");
            return;
        }

        System.out.print("Digite o RA do professor que deseja editar: ");
        String raInput = scanner.next();

        for (Professor professor : professores) {

            String ra, curso;
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

                ra = professor.getNome();
                curso = professor.getCurso();
                salario = professor.getSalario();

                System.out.println("| Nome | Curso | Salário |");
                System.out.printf("| %s | %s | R$ %.2f |", ra, curso, salario);
                System.out.println();
            } else {
                System.out.println("Professor não encontrado.");
            }
        }
    }
}
