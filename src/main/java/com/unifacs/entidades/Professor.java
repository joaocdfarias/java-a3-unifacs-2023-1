package com.unifacs.entidades;

//Implementação da interface Comparable para obter o metodo compareTo
public class Professor extends Pessoa implements Comparable<Professor> {

    private String departamento;
    private int horasTrab;
    private double salario;
    private String ra;
    private String curso;

    public Professor() {
        super();
    }

    public Professor(String nome, String cpf, String departamento, int horasTrab, double salario, String ra,
            String curso) {
        super(nome, cpf);
        this.ra = ra;
        this.departamento = departamento;
        this.horasTrab = horasTrab;
        this.salario = salario;
        this.curso = curso;

    }

    //Metodo que compara o nome de dois objetos para ordenar a lista de profesores por nome
    @Override
    public int compareTo(Professor outroProfessor) {
        return super.getNome().compareTo(outroProfessor.getNome());

    }

    public String getRa() {
        return ra;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getHorasTrab() {
        return horasTrab;
    }

    public void setHorasTrab(Integer horasTrab) {
        this.horasTrab = horasTrab;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    // Metodo que retorna uma String sobre os 3 atributos
    public String toString() {
        return "Nome:" + super.getNome() + " Departamento: " + departamento + " Curso: " + curso + " Salario R$: "
                + String.format("%.2f", salario);
    }

}
