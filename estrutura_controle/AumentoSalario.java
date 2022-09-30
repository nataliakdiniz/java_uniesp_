/* Uma empresa decidiu dar 20% de aumento aos funcionários cujos salários são
inferiores a 500 reais. Escreva um programa que leia o salário de vários
funcionários se mostre o valor do salário reajustado ou uma mensagem caso o
funcionário não tenha direito ao aumento. O programa será encerrado quando se
digitar “fim” para o nome do funcionário. (Comando while) */

import java.util.Scanner;

public class AumentoSalario {
    public static void main(String[] args) {
        int number = 1;
        float salario, novoSalario;
        String nome;

        while (number == 1){
            Scanner leitor = new Scanner(System.in);
            System.out.println("Digite seu salário atual : ");
            salario = leitor.nextInt();

            if(salario <= 500){
                novoSalario = (float) (salario * 1.20);

                System.out.println("Novo salario = "+ novoSalario);
            }
            else{
                System.out.println("Voce não tem direito a um aumento!");
            }
            System.out.println("Digite fim para finalizar o programa: ");
            nome = leitor.next();
            if (nome.equals("fim")) {
                leitor.close();
                number = 0;
            }

        }

    }
}