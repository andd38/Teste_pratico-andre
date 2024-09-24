package Entities;

import java.time.LocalDate;

public class Secretario extends Funcionario{

    private static final double SALARIO_BASE=7000.0;
    private static final double BENEFICIO_ANUAL=1000.00;
    private static final double PERCENTUAL_BENEFICIO=0.20;

    public Secretario(String name, String dtContratacao) {
        super(name, dtContratacao);
    }

    @Override
    public double calcularSalario(int mes, int ano) {
        int anosDeServico = LocalDate.now().getYear()- dtContratacao.getYear();
        double beneficio=(anosDeServico*BENEFICIO_ANUAL)+(SALARIO_BASE*PERCENTUAL_BENEFICIO);
        return SALARIO_BASE+beneficio;
    }

    @Override
    public double calcularSalarioSemBeneficio(int mes, int ano) {
        int anosDeServico = LocalDate.now().getYear()- dtContratacao.getYear();
       return SALARIO_BASE+anosDeServico;
    }

    @Override
    public double calcularTotalParaFuncionarioSomenteComBeneficio(int mes, int ano) {
        double anosServico = LocalDate.now().getYear() - dtContratacao.getYear();
        double salarioBeneficio = SALARIO_BASE +(BENEFICIO_ANUAL*anosServico);
        return salarioBeneficio*PERCENTUAL_BENEFICIO;
    }




    @Override
    public String toString() {
        return "Secretario{" +
                "name='" + name + '\'' +
                ", dtContratacao=" + dtContratacao +
                '}';
    }
}
