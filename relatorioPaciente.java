// Leia uma relação de pacientes de uma clínica, cada um com o nome, o
//sexo, o peso, a idade e a altura. Para sinalizar o fim da lista será fornecido
//“fim” no nome do último paciente.
//Exiba um relatório contendo:
//• a quantidade de pacientes.
//• a média de idade dos homens.
//• a quantidade de mulheres com altura entre 1,60 e 1,70 e peso acima
//de 70kg.
//• a quantidade de pessoas com idade entre 18 e 25.
//• o nome do paciente mais velho.
//• o nome da mulher mais baixa.

import java.util.Scanner;

public class relatorioPaciente {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int totalPacientes = 0,
            somaIdadeHomens = 0,
            totalHomens = 0,
            totalMulheres = 0,
            pacientesEntre18E25Anos = 0,
            idadePacienteMaisVelho = 0;

        float alturaMulherMaisBaixa = Integer.MAX_VALUE;

        String nomePacienteMaisVelho = "", nomeMulherMaisBaixa = "";

        boolean continuarFlag = true;


        while(continuarFlag) {
            System.out.println("Digite o nome do paciente ou \"fim\" para finalizar o programa: ");
            String nome = leitor.next();

            if (nome.equalsIgnoreCase("fim")) {
                continuarFlag = false;
            } else {
                System.out.println("Digite o sexo do paciente (H ou M): ");
                String sexo = leitor.next();

                System.out.println("Digite o peso do paciente (Kg): ");
                float peso = leitor.nextFloat();

                System.out.println("Digite a idade do paciente: ");
                int idade = leitor.nextInt();

                System.out.println("Digite a altura do paciente (m): ");
                float altura = leitor.nextFloat();

                if (sexo.equalsIgnoreCase("H")) {
                    somaIdadeHomens += idade;
                    totalHomens++;
                }

                if (sexo.equalsIgnoreCase("M")) {
                    if (altura >= 1.60f && altura <= 1.70f && peso >= 70f) {
                        totalMulheres++;
                    }

                    if (altura <= alturaMulherMaisBaixa) {
                        alturaMulherMaisBaixa = altura;
                        nomeMulherMaisBaixa = nome;
                    }
                }

                if (idade >= 18 && idade <= 25) {
                    pacientesEntre18E25Anos++;
                }

                if(idade > idadePacienteMaisVelho) {
                    idadePacienteMaisVelho = idade;
                    nomePacienteMaisVelho = nome;
                }

                totalPacientes++;
            }
        }

        System.out.println("Total de pacientes: " + totalPacientes);

        if (somaIdadeHomens > 0){
            System.out.println("Média de idade dos homens: " + (float) (somaIdadeHomens / totalHomens));
        } else {
            System.out.println("Média de idade dos homens: N/A");
        }

        System.out.println("Total de mulheres com altura entre 1,6 e 1,7 e peso acima de 70Kg: " + totalMulheres);
        System.out.println("Total de pacientes com idade entre 18 e 25 anos: " + pacientesEntre18E25Anos);
        System.out.println("Nome do paciente mais velho: " + nomePacienteMaisVelho);
        System.out.println("Mulher mais baixa: " + nomeMulherMaisBaixa);
    }
}

