package branco.model;

public class ProdutoEstoque extends  Produto{
    private Integer produto_estoque_id;
    private String produto_estoque_dataentrada;
    private Boolean produto_estoque_estoque;


    public Integer getProduto_estoque_id() {
        return produto_estoque_id;
    }

    public ProdutoEstoque setProduto_estoque_id(Integer produto_estoque_id) {
        this.produto_estoque_id = produto_estoque_id;
        return this;
    }

    public String getProduto_estoque_dataentrada() {
        return produto_estoque_dataentrada;
    }

    public ProdutoEstoque setProduto_estoque_dataentrada(String produto_estoque_dataentrada) {
        this.produto_estoque_dataentrada = produto_estoque_dataentrada;
        return this;
    }

    public Boolean getProduto_estoque_estoque() {
        return produto_estoque_estoque;
    }

    public ProdutoEstoque setProduto_estoque_estoque(Boolean produto_estoque_estoque) {
        this.produto_estoque_estoque = produto_estoque_estoque;
        return this;
    }
}
