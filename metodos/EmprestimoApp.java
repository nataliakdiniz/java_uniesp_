// Uma grande empresa te contratou para desenvolver um programa de empréstimos.
//Para atender a demanda dessa empresa você deve incialmente desenvolver uma
//classe Java chamada Empréstimo que tenham os seguintes atributos:
// nomeUsuario, idade, valorEmprestimo, percentualJurosMes, mesesParaPagar.
// A classe empréstimo deverá ter os seguintes métodos:
// Imprimir
//o Este método não retorna valor e deverá exibir na tela todos os atributos da
//classe empréstimo.
// calcularEmprestimo
// O valor do empréstimo é calculado seguindo a seguintes regras: caso a idade
//seja maior ou igual a 18 e menor do que 23, use a fórmula: valorEmprestimo
//+= (valorEmprestimo / mesesParaPagar) / * percentualJurosMes, quando for
//superior a 23 e menor ou igual a 33, use a fórmula (valorEmprestimo * 10)/100

import java.util.Scanner;

public class EmprestimoApp {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite o nome do usuário:");
        String nomeUsuario = leitor.nextLine();

        System.out.println("Digite a idade:");
        int idade = leitor.nextInt();

        System.out.println("Digite o valor do empréstimo:");
        float valorEmprestimo = leitor.nextFloat();

        System.out.println("Digite o percentual de juros no mês:");
        float percentualJurosMes = leitor.nextFloat();

        System.out.println("Digite os meses para pagar:");
        int mesesParaPagar = leitor.nextInt();

        Emprestimo emprestimo = new Emprestimo(
                nomeUsuario,
                idade,
                valorEmprestimo,
                percentualJurosMes,
                mesesParaPagar
        );

        emprestimo.calcularEmprestimo();
        emprestimo.imprimir();
    }

    public static class Emprestimo {
        private final String nomeUsuario;
        private final int idade;
        private float valorEmprestimo;
        private final float percentualJurosMes;
        private final int mesesParaPagar;

        public Emprestimo(String nomeUsuario,
                          int idade,
                          float valorEmprestimo,
                          float percentualJurosMes,
                          int mesesParaPagar
        ){
            this.nomeUsuario = nomeUsuario;
            this.idade = idade;
            this.valorEmprestimo = valorEmprestimo;
            this.percentualJurosMes = percentualJurosMes;
            this.mesesParaPagar = mesesParaPagar;
        }

        public void calcularEmprestimo(){
            if (this.idade >= 18 && this.idade < 23){
                this.valorEmprestimo += (valorEmprestimo / mesesParaPagar) * percentualJurosMes;
            } else if (this.idade > 23 && this.idade <= 33){
                this.valorEmprestimo = (valorEmprestimo * 10)/100;
            } else {
                System.out.println("Você não atende aos requisitos!");
            }
        }

        public void imprimir(){
            System.out.println("nomeUsuario: " + this.nomeUsuario);
            System.out.println("idade: " + this.idade);
            System.out.println("valorEmprestimo: " + this.valorEmprestimo);
            System.out.println("percentualJurosMes: " + this.percentualJurosMes);
            System.out.println("mesesParaPagar: " + this.mesesParaPagar);
        }
    }
}
