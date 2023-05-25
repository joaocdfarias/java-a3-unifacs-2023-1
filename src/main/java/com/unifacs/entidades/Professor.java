package com.unifacs.entidades;

public class Professor extends Pessoa {

    private String departamento;
    private Integer horasTrab;
    private Float salario;
    private String ra;
    private String curso;


    public Professor() {
        super();
    }

    public Professor(String nome, String cpf, String departamento, Integer horasTrab, Float salario, String ra, String curso) {
        super(nome, cpf);
        this.ra = ra;
        this.departamento = departamento;
        this.horasTrab = horasTrab;
        this.salario = salario;
        this.curso = curso;

    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
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

    public Integer getHorasTrab() {
        return horasTrab;
    }

    public void setHorasTrab(Integer horasTrab) {
        this.horasTrab = horasTrab;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public String toString() {
        return "Nome:" + super.getNome() + " Departamento: " + departamento + " Curso: " + curso + "Salario R$:" + salario;
    }

    public String darAumento(Float aumento) {
        return "O novo salario é :" + getSalario() + aumento;

    }

}
