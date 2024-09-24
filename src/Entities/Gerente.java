package Entities;

import java.time.LocalDate;


public class Gerente extends Funcionario{
    private static final double SALARIO_BASE =20000.0;
    private static final double BENEFICIO_ANUAL =3000.0;


    public Gerente(String name, String dtContratacao) {
        super(name, dtContratacao);
    }

    @Override
    public double calcularSalario(int mes, int ano) {
        int anosDeServico = LocalDate.now().getYear()- dtContratacao.getYear();
        return SALARIO_BASE+(anosDeServico*BENEFICIO_ANUAL);
    }

    @Override
    public double calcularSalarioSemBeneficio(int mes, int ano) {
        int anosDeServico = LocalDate.now().getYear()- dtContratacao.getYear();
        return SALARIO_BASE+ anosDeServico;
    }

    @Override
    public double calcularTotalParaFuncionarioSomenteComBeneficio(int mes, int ano) {
        return 0;
    }



    @Override
    public String toString() {
        return "Gerente{" +
                "name='" + name + '\'' +
                ", dtContratacao=" + dtContratacao +
                '}';
    }
}
