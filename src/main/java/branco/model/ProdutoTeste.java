package branco.model;


/**
 * @// TODO: 26/11/17 verificar o atributo produto_teste_teste_id, pois ele é um FK no banco de dados
 */
public class ProdutoTeste extends Produto{
    private Integer produto_teste_id;
    private Integer produto_teste_tipo_id; // atributo do tipo de teste que está sendo realizado
    private String produto_teste_obs;
    private String produto_teste_data_inicio;
    private String produto_teste_data_final;
    private Boolean produto_teste_check;


    public Integer getProduto_teste_id() {
        return produto_teste_id;
    }

    public ProdutoTeste setProduto_teste_id(Integer produto_teste_id) {
        this.produto_teste_id = produto_teste_id;
        return this;
    }

    public Integer getProduto_teste_tipo_id() {
        return produto_teste_tipo_id;
    }

    public ProdutoTeste setProduto_teste_tipo_id(Integer produto_teste_tipo_id) {
        this.produto_teste_tipo_id = produto_teste_tipo_id;
        return this;
    }

    public String getProduto_teste_obs() {
        return produto_teste_obs;
    }

    public ProdutoTeste setProduto_teste_obs(String produto_teste_obs) {
        this.produto_teste_obs = produto_teste_obs;
        return this;
    }

    public String getProduto_teste_data_inicio() {
        return produto_teste_data_inicio;
    }

    public ProdutoTeste setProduto_teste_data_inicio(String produto_teste_data_inicio) {
        this.produto_teste_data_inicio = produto_teste_data_inicio;
        return this;
    }

    public String getProduto_teste_data_final() {
        return produto_teste_data_final;
    }

    public ProdutoTeste setProduto_teste_data_final(String produto_teste_data_final) {
        this.produto_teste_data_final = produto_teste_data_final;
        return this;
    }

    public Boolean getProduto_teste_check() {
        return produto_teste_check;
    }

    public ProdutoTeste setProduto_teste_check(Boolean produto_teste_check) {
        this.produto_teste_check = produto_teste_check;
        return this;
    }
}
