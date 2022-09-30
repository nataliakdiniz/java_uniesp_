//Faça um programa que receba duas notas de seis alunos, calcule e mostre (comando for):
// • A média aritmética das duas notas de cada aluno; • O total de alunos aprovados;
// • O total de alunos de exame; • Total de alunos reprovados; • A média da classe.

import java.util.Scanner;
public class NotaAlunos {
    public static void main(String[] args) {
        double i, primeiraNota, segundaNota, media, reprovado, aprovado, exame, mediaTurma;
        reprovado = 0;
        aprovado = 0;
        exame = 0;
        mediaTurma = 0;
        Scanner leitor = new Scanner(System.in);
        int repeticoes = 3;

        for(i = 1 ; i <= repeticoes ; i++){
            System.out.println("Digite a primeira nota: ");
            primeiraNota = leitor.nextInt();
            System.out.println("Digite a segunda nota: ");
            segundaNota = leitor.nextInt();

            media = ((primeiraNota + segundaNota) / 2);
            if (media < 3){
                System.out.println("Reprovado! Sua média é: " + media);
                reprovado = (reprovado + 1);
            } else if (media > 7){
                System.out.println("Aprovado! Sua média é: " + media);
                aprovado = (aprovado + 1);
            } else {
                System.out.println("Exame! Sua média é: " + media);
                exame = (exame + 1);
            }
            mediaTurma = media +mediaTurma;
        }

        System.out.println("Aprovados : " + aprovado);
        System.out.println("Exame : " + exame);
        System.out.println("Reprovados : " + reprovado);
        System.out.println("Media da turma : " + mediaTurma / repeticoes);
    }
}



