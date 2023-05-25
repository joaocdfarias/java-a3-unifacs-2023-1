package entidades;

public abstract class Pessoa {
    private String nome;
    private String cpf;

    public Pessoa(){

    }
    public Pessoa(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;

    }



    /**
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }



    /**
     * @return String return the cpf
     */
    public String getCpf() {
        return cpf;
    }



}

