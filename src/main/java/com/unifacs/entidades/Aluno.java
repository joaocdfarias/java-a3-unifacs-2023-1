package com.unifacs.entidades;

public class Aluno extends Pessoa {
    private String curso;
    private String ra;
    private String periodo;

    public Aluno() {
        super();
    }

    public Aluno(String nome, String cpf, String periodo, String ra, String curso) {
        super(nome, cpf);
        this.periodo = periodo;
        this.ra = ra;
        this.curso = curso;
    }

    // Metodo que que retorna uma String mostrando 3 atributos do aluno
    public String toString() {
        return "Nome: " + super.getNome() + " - RA:" + ra + " - Curso: " + curso;
    }

    /**
     * @return String return the curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * @return String return the ra
     */
    public String getRa() {
        return ra;
    }

    /**
     * @return String return the periodo
     */
    public String getPeriodo() {
        return periodo;
    }

    /**
     * @param periodo the periodo to set
     */
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

}
