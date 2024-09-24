package Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public abstract class Funcionario {

    protected String name;
    protected LocalDate dtContratacao;

    public Funcionario(String name, String dtContratacao) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.name = name;
        this.dtContratacao = LocalDate.parse(dtContratacao,fmt);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDtContratacao() {
        return dtContratacao;
    }

    public void setDtContratacao(LocalDate dtContratacao) {
        this.dtContratacao = dtContratacao;
    }

    public abstract double calcularSalario(int mes, int ano);

    public abstract double calcularSalarioSemBeneficio(int mes,int ano);
    public abstract double calcularTotalParaFuncionarioSomenteComBeneficio( int mes, int ano);


}
