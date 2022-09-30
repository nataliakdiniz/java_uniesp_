/* 2. Faça um programa que leia 10 números inteiros e exiba na tela a mensagem ‘Par’
se ele for um número par, ou ‘Ímpar’ se ele for um número ímpar. (Comando if). */

import java.util.Scanner;

public class ParImpar {
    public static void main(String[] args) {
        int number;
        System.out.println("Digite um valor inteiro: ");
        Scanner leitor = new Scanner(System.in);
        number = leitor.nextInt();

        if((number % 2) == 0){
            System.out.println("Número par!");
        } else {
            System.out.println("Número impar!");
        }

        leitor.close();
    }
}
