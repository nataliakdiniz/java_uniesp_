public class VendaPOS{
    public static void main(String[] args) {
        System.out.println("============= VENDA 1 =============");

        // Criação do objeto produto
        Produto produtoSemPromocao = new Produto( 1, "Chocolate Milka", 16.00, 8.00, false);

        // Criação do objeto vendedor
        Vendedor vendedor_1 = new Vendedor(1, "Lorem Ipsum", "Rua 1");
        vendedor_1.setComissao(5.00);

        // Criação do objeto venda
        Venda venda_1 = new Venda();
        venda_1.setProduto(produtoSemPromocao);
        venda_1.setVendedor(vendedor_1);
        venda_1.setQuantidadeItens(2);

        // Calculando venda
        venda_1.calcularValor();
        venda_1.calcularComissao();
        venda_1.imprimir();


        System.out.println("\n\n============= VENDA 2 =============");

        // Criação do objeto produto 2
        Produto produtoComPromocao = new Produto(2, "Cesto de chocolate Milka", 100.00, 80.00, true);

        // Criação do objeto vendedor 2
        Vendedor vendedor_2 = new Vendedor(2, "Amet Dolor", "Rua 2");
        vendedor_2.setComissao(10.00);

        // Criação do objeto venda 2
        Venda venda_2 = new Venda();
        venda_2.setProduto(produtoComPromocao);
        venda_2.setVendedor(vendedor_2);
        venda_2.efetuarDesconto(10.00);
        venda_2.setQuantidadeItens(3);

        // Calculando venda 2
        venda_2.calcularValor();
        venda_2.calcularComissao();
        venda_2.imprimir();


        System.out.println("\n\n============= VENDA 3 =============");

        // Criação do objeto venda 3
        Venda venda_3 = new Venda();
        venda_3.setProduto(produtoComPromocao);
        venda_3.setVendedor(vendedor_2);
        venda_3.efetuarDesconto(30.00);
        venda_3.setQuantidadeItens(2);

        // Calculando venda 3
        venda_3.calcularValor();
        venda_3.calcularComissao();
        venda_3.imprimir();
    }
}