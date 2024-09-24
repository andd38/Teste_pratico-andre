import Entities.Funcionario;
import Entities.Gerente;
import Entities.Secretario;
import Entities.Vendedor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();
        List<Vendedor> vendedores = new ArrayList<>();

        // Adicionando os funcionários
        funcionarios.add(new Secretario("Jorge Carvalho", "01/01/2018"));
        funcionarios.add(new Secretario("Maria Souza", "01/12/2015"));
        funcionarios.add(new Vendedor("Ana Silva", "01/12/2021", new double[]{5200, 4000, 4200, 5850, 7000}));
        funcionarios.add(new Vendedor("João Mendes", "01/12/2021", new double[]{3400, 7700, 5000, 5900, 6500}));
        funcionarios.add(new Gerente("Juliana Alves", "01/07/2017"));
        funcionarios.add(new Gerente("Bento Albino", "01/03/2014"));
        vendedores.add(new Vendedor("Ana Silva", "01/12/2021", new double[]{5200, 4000, 4200, 5850, 7000}));
        vendedores.add(new Vendedor("João Mendes", "01/12/2021", new double[]{3400, 7700, 5000, 5900, 6500}));

        double totalPago = calcularTotalPago(funcionarios,12,2021);
        double totalSemBeneficio=  calcularTotalPagoSemBeneficio(funcionarios,12,2021);
        double totalSomenteFuncComBeneficio = calcularTotalParaFuncionarioSomenteComBeneficio(funcionarios,12,2021);
        Funcionario maisBemPagoDoMes = calcularTotalMaximoDoMes(funcionarios,12,2021);
        Funcionario maiorBeneficiado = funcionarioComMaiorBeneficio(funcionarios,12,2021);
        Vendedor maiorVendedor = ColaboradorQueMaisVendeu(vendedores,4,2021);


        System.out.println("Total pago em 12/2021: "+ maiorVendedor);


        System.out.println("Total pago em 12/2021: "+ String.format("%.2f",totalSemBeneficio));
        System.out.println("Total pago em 12/2021: "+ String.format("%.2f",totalSomenteFuncComBeneficio));
        System.out.println("Total pago em 12/2021: "+ String.format("%.2f",totalPago));
        System.out.println("Total pago em 12/2021: "+ maisBemPagoDoMes);
        System.out.println("Total pago em 12/2021: "+ maiorBeneficiado);





    }

    public static double calcularTotalPago(List<Funcionario> funcionarioslist,int mes,int ano){
        double totalPago =0;
        for(Funcionario funcionario: funcionarioslist){
            totalPago += funcionario.calcularSalario(mes,ano);
        }
        return  totalPago;
    }
    public static double calcularTotalPagoSemBeneficio(List<Funcionario> funcionarioslist,int mes,int ano){
        double totalPago =0;
        for(Funcionario funcionario: funcionarioslist){
            totalPago += funcionario.calcularSalarioSemBeneficio(mes,ano);
        }
        return  totalPago;
    }

    public static double calcularTotalParaFuncionarioSomenteComBeneficio(List<Funcionario> funcionarioList,int mes,int ano){
        double totalPago = 0;
        for (Funcionario funcionario : funcionarioList){
           if(funcionario instanceof Vendedor) {
                totalPago +=((Vendedor) funcionario).calcularTotalParaFuncionarioSomenteComBeneficio(mes, ano);
            } else if( funcionario instanceof Secretario){
                totalPago +=((Secretario)funcionario).calcularTotalParaFuncionarioSomenteComBeneficio(mes,ano);
            }
        }
        return totalPago;
    }
    public static Funcionario calcularTotalMaximoDoMes(List<Funcionario> funcionarios ,int mes,int ano){
        double total =0;
        Funcionario colaborador = null;
        for (Funcionario funcionario: funcionarios){
            double valorRecebido = funcionario.calcularSalario(mes, ano);
            if(valorRecebido>total){
                total=valorRecebido;
                colaborador=funcionario;
            }
        }
        return colaborador;
    }
    public static Funcionario funcionarioComMaiorBeneficio(List<Funcionario>funcionarioList ,int mes, int ano){
        double totalBeneficio= 0;
        Funcionario colaborador = null;
        for (Funcionario funcionario: funcionarioList){
            double valorBeficiado = funcionario.calcularTotalParaFuncionarioSomenteComBeneficio(mes,ano);
            if(valorBeficiado> totalBeneficio){
                totalBeneficio = valorBeficiado;
                colaborador=funcionario;
            }
        }
        return colaborador;


    }
    public static Vendedor ColaboradorQueMaisVendeu(List<Vendedor> vendedores, int mes,int ano){
        Vendedor vendedor = null;
        double maiorVenda =0;
        for (Vendedor vendedor1: vendedores){
            double vendas = vendedor1.getVendasNoMes(mes,ano);
            if(vendas> maiorVenda){
                maiorVenda = vendas;
                vendedor = vendedor1;
            }
        }
        return vendedor;
    }



    }



