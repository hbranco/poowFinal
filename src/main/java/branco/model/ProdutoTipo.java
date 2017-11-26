package branco.model;

/**
 *
 * -- auto-generated definition
 CREATE TABLE produto_tipo
 (
 produto_tipo_id   SERIAL                                               NOT NULL
 CONSTRAINT produto_tipo_pkey
 PRIMARY KEY,
 produto_tipo_nome VARCHAR(100) DEFAULT 'sem nome' :: CHARACTER VARYING NOT NULL,
 produto_tipo_obs  VARCHAR(250) DEFAULT '-' :: CHARACTER VARYING        NOT NULL
 );

 *
 *
 */


public class ProdutoTipo {
    private Integer produto_tipo_id;
    private String Produto_tipo_nome;
    private String Produto_tipo_obs;


    public Integer getProduto_tipo_id() {
        return produto_tipo_id;
    }

    public void setProduto_tipo_id(Integer produto_tipo_id) {
        this.produto_tipo_id = produto_tipo_id;
    }

    public String getProduto_tipo_nome() {
        return Produto_tipo_nome;
    }

    public void setProduto_tipo_nome(String produto_tipo_nome) {
        Produto_tipo_nome = produto_tipo_nome;
    }

    public String getProduto_tipo_obs() {
        return Produto_tipo_obs;
    }

    public void setProduto_tipo_obs(String produto_tipo_obs) {
        Produto_tipo_obs = produto_tipo_obs;
    }
}
