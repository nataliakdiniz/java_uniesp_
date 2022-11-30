public class Vendedor {
    private Integer codigo;
    private String nome;
    private Double comissao;
    private String endereco;

    Vendedor() {}

    Vendedor(Integer codigo, String nome, String endereco) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public Double getComissao() {
        return this.comissao;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return
            "Código: " + codigo + '\n' +
            "Nome: " + nome + '\n' +
            "Comissão: " + comissao + '%' + '\n' +
            "Endereço: " + endereco + '\n' +
            "----------------------------";
    }
}
