package branco.model;


public class ProdutoDefeito extends  Produto{
    private Integer produto_defeito_id;
    private String produto_defeito_data_in;
    private String produto_defeito_data_out;
    private Boolean produto_defeito_conserto;

    public Integer getProduto_defeito_id() {
        return produto_defeito_id;
    }

    public ProdutoDefeito setProduto_defeito_id(Integer produto_defeito_id) {
        this.produto_defeito_id = produto_defeito_id;
        return this;
    }

    public String getProduto_defeito_data_in() {
        return produto_defeito_data_in;
    }

    public ProdutoDefeito setProduto_defeito_data_in(String produto_defeito_data_in) {
        this.produto_defeito_data_in = produto_defeito_data_in;
        return this;
    }

    public String getProduto_defeito_data_out() {
        return produto_defeito_data_out;
    }

    public ProdutoDefeito setProduto_defeito_data_out(String produto_defeito_data_out) {
        this.produto_defeito_data_out = produto_defeito_data_out;
        return this;
    }

    public Boolean getProduto_defeito_conserto() {
        return produto_defeito_conserto;
    }

    public ProdutoDefeito setProduto_defeito_conserto(Boolean produto_defeito_conserto) {
        this.produto_defeito_conserto = produto_defeito_conserto;
        return this;
    }
}
