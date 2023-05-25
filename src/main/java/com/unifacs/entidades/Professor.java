package entidades;

public class Professor extends Pessoa {

    private String Departamento;
    private Integer Horas_trab;
    private Float Salario;
    private Double RA;


    public Professor() {
        super();
    }

    public Professor(String nome, String cpf, String Departamento, Integer Horas_trab, Float Salario, Double RA) {
        super(nome, cpf);
        this.RA = RA;
        this.Departamento = Departamento;
        this.Horas_trab = Horas_trab;
        this.Salario = Salario;

    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String departamento) {
        Departamento = departamento;
    }

    public Integer getHoras_trab() {
        return Horas_trab;
    }

    public void setHoras_trab(Integer horas_trab) {
        Horas_trab = horas_trab;
    }

    public Float getSalario() {
        return Salario;
    }

    public void setSalario(Float salario) {
        Salario = salario;
    }

    public String toString() {
        return super.getNome() + "Departamento: " + Departamento + "Salario: R$" + Salario;
    }
}
