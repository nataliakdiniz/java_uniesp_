//1 - 0 Projeto deve ter opções do Menu que permitam registro das vendas.
//ex:
//Digite 1 para cadastrar um vendedor.
//Digite 2 pra registrar uma venda.
//Digite 3 para exibir o resumo de uma venda.
//Digite 100 para encerrar o programa
//2 - Os valores devem ser recuperados do console, solicitados ao usuários.
//Ex: Informe nome do Vendedor
//Ex: Informe o valor da venda.
//Deve possuir uma opção de encerrar o programa.
//Se o sistema parar, será realizado desconto de 50% da nota.

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class VendaPOS {
    List<Vendedor> vendedores = new ArrayList<>();
    List<Produto> produtos = new ArrayList<>();
    List<Venda> vendas = new ArrayList<>();

    private void exibirMenu() {
        System.out.println("\n");
        System.out.println("+-------------------------------------------+");
        System.out.println("|        Menu de Opções                     |");
        System.out.println("+-------------------------------------------+");
        System.out.println("| 1 - Cadastrar Vendedor                    |");
        System.out.println("| 2 - Listar Vendedores                     |");
        System.out.println("| 3 - Cadastrar Produto                     |");
        System.out.println("| 4 - Listar Produtos                       |");
        System.out.println("| 5 - Cadastrar Venda                       |");
        System.out.println("| 6 - Listar Vendas                         |");
        System.out.println("| 99 - Preencher Listas                     |");
        System.out.println("| 100 - Sair                                |");
        System.out.println("+-------------------------------------------+");
    }

    private void printMenuTitle(String title) {
        System.out.println("\n\n\n\n+--------- " + title + " ---------+");
    }

    private void cadastrarVendedor() {
        try {
            printMenuTitle("Cadastrar Vendedor");

            Scanner leitor = new Scanner(System.in);
            Vendedor vendedor = new Vendedor();

            vendedor.setCodigo(vendedores.size() + 1);

            System.out.print("Nome do vendedor: ");
            vendedor.setNome(leitor.nextLine());

            System.out.print("Endereço do vendedor: ");
            vendedor.setEndereco(leitor.nextLine());

            System.out.print("Comissão do vendedor: ");
            vendedor.setComissao(leitor.nextDouble());

            vendedores.add(vendedor);
        } catch (Exception e) {
            System.out.println("Algo deu errado, tente novamente!");
        }
    }

    private void listarVendedores() {
        printMenuTitle("Listar Vendedores");

        if (vendedores.size() == 0) {
            System.out.println("Não há vendedores para listar");
            return;
        }

        vendedores.stream().forEach(vendedor -> System.out.println(vendedor.toString()));

        System.out.println("\nQuantidade de vendedores cadastrados: " + vendedores.size());
    }

    private void cadastrarProduto() {
        try {
            printMenuTitle("Cadastrar Produto");

            Scanner leitor = new Scanner(System.in);
            Produto produto = new Produto();

            produto.setCodigo(produtos.size() + 1);

            System.out.print("Descrição: ");
            produto.setDescricao(leitor.nextLine());

            System.out.print("Valor VENDA: R$ ");
            produto.setValorVenda(leitor.nextDouble());

            System.out.print("Valor Custo: R$ ");
            produto.setValorCusto(leitor.nextDouble());

            // Previnindo o usuário de digitar qualquer coisa além de 1 e 2
            // Caso aconteça, o programa perguntará novamente a opção desejada!
            int produtoEmPromocaoAnswer = 0;
            while (produtoEmPromocaoAnswer != 1 && produtoEmPromocaoAnswer != 2) {
                System.out.print("Produto em promoção ? (1-SIM / 2-NÃO): ");

                if (leitor.hasNextInt()) {
                    produtoEmPromocaoAnswer = leitor.nextInt();

                    if (produtoEmPromocaoAnswer != 1 && produtoEmPromocaoAnswer != 2) {
                        System.out.println("Opção inválida, tente novamente!\n");
                    }

                    produto.setPromocao(Objects.equals(produtoEmPromocaoAnswer, 1));
                } else {
                    produtoEmPromocaoAnswer = 0;
                    // Isso é necessário para limpar o buffer do scanner
                    leitor.next();
                    System.out.println("Opção inválida, tente novamente!\n");
                }
            }


            produtos.add(produto);
        } catch (Exception e) {
            System.out.println("Algo deu errado, tente novamente!");
        }
    }

    private void listarProdutos() {
        printMenuTitle("Listar Produtos");

        if (produtos.size() == 0) {
            System.out.println("Não há produtos para listar");
            return;
        }

        produtos.stream().forEach(produto -> System.out.println(produto.toString()));

        System.out.println("\nQuantidade de produtos cadastrados: " + produtos.size());
    }

    private void cadastrarVenda() {
        try {
            printMenuTitle("Cadastrar Venda");

            if (vendedores.size() == 0) {
                System.out.println("Não há vendedores cadastrados, por favor, cadastrar um antes de realizar uma venda");
                return;
            }

            if (produtos.size() == 0) {
                System.out.println("Não há produtos cadastrados, por favor, cadastrar um antes de realizar uma venda");
                return;
            }

            Scanner leitor = new Scanner(System.in);
            Venda venda = new Venda();
            venda.setCodigo(vendas.size() + 1);

            // PRODUTO
            while (true) {
                System.out.print("Informe o código do produto: ");
                Integer codigoProduto = leitor.nextInt();

                if (codigoProduto == 0) {
                    return;
                }

                Produto produto = produtos.stream().filter(p -> codigoProduto.equals(p.getCodigo()))
                    .findAny()
                    .orElse(null);

                if (produto == null) {
                    System.out.print("Produto com código " + codigoProduto + " não encontrado, tente novamente! \n");
                    System.out.print("Digite 0 para voltar ao menu anterior! \n");
                } else {
                    venda.setProduto(produto);
                    break;
                }
            }

            // VENDEDOR
            while (true) {
                System.out.print("Informe o código do vendedor: ");
                Integer codigoFuncionario = leitor.nextInt();

                if (codigoFuncionario == 0) {
                    return;
                }

                Vendedor vendedor = vendedores.stream().filter(p -> codigoFuncionario.equals(p.getCodigo()))
                    .findAny()
                    .orElse(null);

                if (vendedor == null) {
                    System.out.print("Produto com código " + codigoFuncionario + " não encontrado, tente novamente! \n");
                    System.out.print("Digite 0 para voltar ao menu anterior! \n");
                } else {
                    venda.setVendedor(vendedor);
                    break;
                }
            }


            System.out.print("Informe a quantidade de itens vendidos: ");
            Integer quantidade = leitor.nextInt();
            venda.setQuantidadeItens(quantidade);


            System.out.print("Deseja efetuar desconto de quantos % ?");
            Double desconto = leitor.nextDouble();
            venda.setDesconto(desconto);

            venda.calcularValor();
            venda.calcularComissao();
            venda.imprimir();
        } catch (Exception e) {
            System.out.println("Algo deu errado, tente novamente!");
        }
    }

    private void listarVendas() {
        printMenuTitle("Listar Vendas");

        if (vendas.size() == 0) {
            System.out.println("Não há vendas para listar");
            return;
        }

        vendas.stream().forEach(Venda::imprimir);

        System.out.println("\nQuantidade de vendas cadastradas: " + vendas.size());
    }

    // Essa função aqui contém tudo que tinha na primeira etapa deste projeto
    // Realizando alguns cadastros de funcionário/produto e venda.
    private void populateLists() {
        printMenuTitle("Populando listas de vendedores/produtos/vendas");

        // VENDA 1

        // Criação do objeto produto
        Produto produtoSemPromocao = new Produto(1, "Chocolate Milka", 16.00, 8.00, false);
        produtos.add(produtoSemPromocao);

        // Criação do objeto vendedor
        Vendedor vendedor_1 = new Vendedor(1, "Lorem Ipsum", "Rua 1");
        vendedor_1.setComissao(5.00);
        vendedores.add(vendedor_1);

        // Criação do objeto venda
        Venda venda_1 = new Venda();
        venda_1.setCodigo(vendas.size() + 1);
        venda_1.setProduto(produtoSemPromocao);
        venda_1.setVendedor(vendedor_1);
        venda_1.setQuantidadeItens(2);

        // Calculando venda
        venda_1.calcularValor();
        venda_1.calcularComissao();
        vendas.add(venda_1);


        // VENDA 2

        // Criação do objeto produto 2
        Produto produtoComPromocao = new Produto(2, "Cesto de chocolate Milka", 100.00, 80.00, true);
        produtos.add(produtoComPromocao);

        // Criação do objeto vendedor 2
        Vendedor vendedor_2 = new Vendedor(2, "Amet Dolor", "Rua 2");
        vendedor_2.setComissao(10.00);
        vendedores.add(vendedor_2);

        // Criação do objeto venda 2
        Venda venda_2 = new Venda();
        venda_2.setCodigo(vendas.size() + 1);
        venda_2.setProduto(produtoComPromocao);
        venda_2.setVendedor(vendedor_2);
        venda_2.efetuarDesconto(10.00);
        venda_2.setQuantidadeItens(3);

        // Calculando venda 2
        venda_2.calcularValor();
        venda_2.calcularComissao();
        vendas.add(venda_2);


        // VENDA 3

        // Criação do objeto venda 3
        Venda venda_3 = new Venda();
        venda_3.setCodigo(vendas.size() + 1);
        venda_3.setProduto(produtoComPromocao);
        venda_3.setVendedor(vendedor_2);
        venda_3.efetuarDesconto(30.00);
        venda_3.setQuantidadeItens(2);


        // Calculando venda 3
        venda_3.calcularValor();
        venda_3.calcularComissao();
        vendas.add(venda_3);
    }


    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        VendaPOS vendaPOS = new VendaPOS();
        short opcao = 0;

        // Este loop vai acontecer enquanto o usuário não digitar 100
        // Que foi a condição estabelecida para finalizar a aplicação
        do {
            vendaPOS.exibirMenu();

            System.out.print("Opção escolhida: ");

            // Previnindo o usuário de digitar qualquer coisa além de um número inteiro
            // Caso aconteça, o programa perguntará novamente a opção desejada!
            if (leitor.hasNextShort()) {
                opcao = leitor.nextShort();
            } else {
                opcao = 0;
                // Isso é necessário para limpar o buffer do scanner
                leitor.next();
            }

            switch (opcao) {
                case 1 -> vendaPOS.cadastrarVendedor();
                case 2 -> vendaPOS.listarVendedores();
                case 3 -> vendaPOS.cadastrarProduto();
                case 4 -> vendaPOS.listarProdutos();
                case 5 -> vendaPOS.cadastrarVenda();
                case 6 -> vendaPOS.listarVendas();
                case 99 -> vendaPOS.populateLists(); // Opção para agilizar o processo de teste
                case 100 -> System.out.println("finalizando aplicação...");
                default -> System.out.println("Opção não existe, tente novamente!");
            }
        } while (opcao != 100);
    }
}
