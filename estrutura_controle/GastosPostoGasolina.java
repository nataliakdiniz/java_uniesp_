/* 4. Um motorista parou no posto de gasolina, comprou dois refrigerantes e abasteceu o
seu carro com gasolina. Leia a quantidade de litros de gasolina foram necessários
para abastecer o veículo e informe o valor total da conta desse cliente, sabendo-se
que cada refrigerante custou R$3,00 e o litro de gasolina está custando R$2,50.
(Estrutura Sequencial). */

import java.util.Scanner;

public class GastosPostoGasolina {
    public static void main(String[] args) {
        double valorUnidadeRefrigente = 3,  quantidadeRefrigerante = 2, valorTotalRefrigerante, valorLitrosGasolina = 2.50,
                quantidadeLitros, valorGasolina, totalCompra;
        System.out.println("Digite quantos litros você precisou para abastecer o veículo: ");
        Scanner leitor = new Scanner(System.in);
        quantidadeLitros = leitor.nextInt();
        valorGasolina = valorLitrosGasolina * quantidadeLitros;
        System.out.println("Você gastou isto de gasolina: " + valorGasolina);
        valorTotalRefrigerante = valorUnidadeRefrigente * quantidadeRefrigerante;
        System.out.println("Você gastou isto de refrigente: " + valorTotalRefrigerante);
        totalCompra = valorGasolina + valorTotalRefrigerante;
        System.out.println("Sua compra total foi de: " +totalCompra);
    }
}
