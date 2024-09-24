package Entities;

import java.time.LocalDate;
import java.util.Arrays;

public class Vendedor extends Funcionario{
    private static final double SALARIO_BASE=12000.0;
    private static final double BENEFICIO_ANUAL=1800.0;
    private static final double PERCENTUAL_POR_VALOR_VENDIDO=0.30;

    private double [] vendas;
    public Vendedor(String name, String dtContratacao, double[] vendas) {
        super(name, dtContratacao);
        this.vendas=vendas;
    }

    @Override
    public double calcularSalario(int mes, int ano) {
        int anosDeServico = LocalDate.now().getYear()- dtContratacao.getYear();
        double beneficio=  anosDeServico*BENEFICIO_ANUAL;
        double totalvendas =0;
        if(mes>0 && vendas.length>=mes){
            totalvendas=vendas[mes-1];
        }
        return SALARIO_BASE+ beneficio+ (totalvendas*PERCENTUAL_POR_VALOR_VENDIDO);
    }

    @Override
    public double calcularSalarioSemBeneficio(int mes, int ano) {
        int anosDeServico = LocalDate.now().getYear()- dtContratacao.getYear();
       return SALARIO_BASE+ anosDeServico;
    }

    @Override
    public double calcularTotalParaFuncionarioSomenteComBeneficio(int mes, int ano) {
       double anosDeservico =  LocalDate.now().getYear() - dtContratacao.getYear();
       return anosDeservico*BENEFICIO_ANUAL;
    }
    public double getVendasNoMes(int mes, int ano) {
        if (mes >= 1 && mes <= vendas.length) {
            return vendas[mes - 1];
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "vendas=" + Arrays.toString(vendas) +
                ", name='" + name + '\'' +
                ", dtContratacao=" + dtContratacao +
                '}';
    }
}
