/*A prefeitura de João Pessoa abriu uma linha de crédito para os funcionários
        municipais. O valor máximo da prestação não poderá ultrapassar 30% do salário
        bruto. Fazer um algoritmo que permita entrar com o salário bruto e o valor da
        prestação e informar se o empréstimo pode ou não ser concedido. (comando if)*/

import java.util.Scanner;

public class EmprestimoConsignado {
    public static void main(String[] args) {
        double salarioBruto, valorPrestacao;
        System.out.println("Digite o valor do seu salário bruto: ");
        Scanner leitor = new Scanner(System.in);
        salarioBruto = leitor.nextInt();
        System.out.println("Digite o valor da prestação: ");
        valorPrestacao = leitor.nextInt();
        if (valorPrestacao <= salarioBruto * 0.30){
            System.out.println("Seu emprestimo foi aprovado!");
        } else {
            System.out.println("Infelizmente não foi desta vez.");
        }
    }
}
