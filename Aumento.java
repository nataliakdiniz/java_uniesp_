/* Faça um programa que receba o valor dos créditos galácticos de um Star trooper e
o percentual de aumento, calcule e mostre os créditos galácticos com o novo
aumento.*/

import java.util.Scanner;

public class Aumento {
    public static void main(String[] args) {

        int salario, percentual, aumento, novoSalario;

        System.out.println("Digite seu salario atual: ");

        Scanner leitor = new Scanner(System.in);

        salario = leitor.nextInt();

        System.out.println("\nDigite o percentual de aumento : ");

        percentual = leitor.nextInt();

        novoSalario =  salario + (salario * percentual/100 );

        aumento = novoSalario - salario;

        System.out.println("\nSeu novo salário é de : " + novoSalario);
        System.out.println("\nSeu aumento foi de : "+ aumento);

        leitor.close();

    }
}