package com.unifacs.entidades;

import java.util.ArrayList;

public class Aluno extends Pessoa {
    private String curso;
    private String ra;
    private String periodo;
    private float media;
    private ArrayList<Float> notas = new ArrayList<>();

    public Aluno(){
        super();
    }
    
    public Aluno(String nome, String cpf, String periodo, String ra, String curso){
        super(nome, cpf);
        this.periodo = periodo;
        this.ra = ra;
        this.curso = curso;
    }

    //Metodo que informa as notas do aluno
    public String acessarNotas(){
        StringBuilder x = new StringBuilder();
        for(int i =0;i<notas.size(); i++){
            x.append(String.format("%.2f", notas.get(i))+ " ");
        }
        return x.toString();

    }
    //Metodo que remove as notas do aluno
    public void removerNota(int nota){
        notas.remove(nota);
    }
    
    //Metodo que adiciona as notas do aluno
    public void adicionarNota(float nota){
        notas.add(nota);
    }
    
    //Metodo que adiciona uma nota no lugar de outra nota do aluno
    public void adicionarNota(int notaLugar, float nota){
        notas.add(notaLugar-1, nota);
    }

    //Metodo que calcula a media do aluno
    public float calcularMedia(){
        media = 0f;

        for(float x : notas){
            media+=x;
        }
        media = media/notas.size();
        return media;
    }
    
    //Metodo que que retorna uma String mostrando 3 atributos do aluno
    public String toString(){
        return "Nome: "+super.getNome()+ " - RA:"+ ra + " - Curso: "+curso;
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

    /**
     * @return ArrayList<Float> return the notas
     */
    public ArrayList<Float> getNotas() {
        return notas;
    }
    
}
