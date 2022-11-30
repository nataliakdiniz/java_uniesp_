public class Venda {
    private Integer codigo;
    private Produto produto;
    private Vendedor vendedor;
    private Double desconto = 0.00;
    private Double valor;
    private Integer quantidadeItens;


    /**
     * Leva em consideração a quantidadeItens, o valorVenda do produto e o desconto
     */
    public void calcularValor() {
        this.valor = this.quantidadeItens * this.produto.getValorVenda() - this.quantidadeItens * this.desconto;
    }


    /**
     * Leva em considera a comissao do vendedor e o valor da venda.
     * Entretanto se o produto estiver em promocao o valor da comissão deve ser dividido por dois.
     * @return Double
     */
    public Double calcularComissao(){
        double comissao = this.valor * (this.vendedor.getComissao() / 100);

        if (this.produto.getPromocao()){
            return comissao / 2;
        }

        return comissao;
    }

    /**
     * Recebe como parâmetro a porcentagem de desconto. O desconto é sobre o valorVenda do produto.
     * O valor de um produto após o desconto não pode ficar abaixo do valorCusto do produto.
     * @param desconto
     */
    public void efetuarDesconto(Double desconto) {
        double descontoValor = this.produto.getValorVenda() * (desconto / 100);
        double novoValor = this.produto.getValorVenda() - descontoValor;

        if (novoValor < this.produto.getValorCusto()){
            System.out.println("Atenção: Valor do produto com desconto de " + desconto +"% é menor que o valor de custo do produto; usando valor de custo como valor de venda: R$" + this.produto.getValorCusto());
            novoValor = this.produto.getValorCusto();
        }

        this.desconto = this.produto.getValorVenda() - novoValor;
    }


    /**
     * Imprime:
     * • O vendedor (codigo,nome e a comissao pela venda)
     * • Quantidade de itens vendidos
     * • O código e descrição do produto
     * • O valor de venda do produto
     * • Se o produto está em promoção ou não
     * • O valor do desconto sobre o produto
     * • O valor total da venda
     */
    public void imprimir(){
        System.out.println("+--------- Resumo da venda "+ this.codigo +" ---------+\n");
        System.out.println("--- vendedor ---");
        System.out.println("Código: " + this.vendedor.getCodigo());
        System.out.println("Nome: " + this.vendedor.getNome());
        System.out.println("Comissão pela venda: R$" + this.calcularComissao());

        System.out.println("--- produto ---");
        System.out.println("Código: " + this.produto.getCodigo());
        System.out.println("Descrição: " + this.produto.getDescricao());
        System.out.println("Valor de venda: R$" + this.produto.getValorVenda());
        System.out.println("Produto em promoção: " + (this.produto.getPromocao() ? "SIM" : "NÃO"));
        System.out.println("Valor do desconto sobre o produto: R$" + this.desconto);

        System.out.println("--- venda ---");
        System.out.println("Quantidade de itens vendidos:" + this.quantidadeItens);
        System.out.println("Valor total: R$" + this.valor + "\n\n");
    }

    public Produto getProduto() {
        return this.produto;
    }

    public Vendedor getVendedor() {
        return this.vendedor;
    }

    public Double getDesconto() {
        return this.desconto;
    }

    public Double getValor() {
        return this.valor;
    }

    public Integer getQuantidadeItens() {
        return this.quantidadeItens;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setQuantidadeItens(Integer quantidadeItens) {
        this.quantidadeItens = quantidadeItens;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
}
