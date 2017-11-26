package branco.model;


import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * -- auto-generated definition
 CREATE TABLE produto
 (
 produto_id              SERIAL                                             NOT NULL
 CONSTRAINT produto_pkey
 PRIMARY KEY,
 produto_tipo_id         INTEGER
 CONSTRAINT produto_produto_tipo_produto_tipo_id_fk
 REFERENCES produto_tipo,
 produto_codigo          VARCHAR(50) DEFAULT 'not cod' :: CHARACTER VARYING NOT NULL,
 produto_lote            INTEGER,
 produto_data_fabricacao TIMESTAMP,
 produto_deletado        BOOLEAN DEFAULT FALSE                              NOT NULL
 );

 */
@Repository
public class Produto  extends ProdutoTipo{
    private Integer produto_id;

    @NotEmpty
    private String produto_codigo;

    @NotNull
//    @Size(min=2)
    private Integer produto_lote;

    @NotEmpty
    private String produto_data_fabricacao;

    private Boolean produto_deletado;






    public Integer getProduto_id() {
        return produto_id;
    }

    public Produto setProduto_id(Integer produto_id) {
        this.produto_id = produto_id;
        return this;
    }

    public String getProduto_codigo() {
        return produto_codigo;
    }

    public Produto setProduto_codigo(String produto_codigo) {
        this.produto_codigo = produto_codigo;
        return this;
    }

    public Integer getProduto_lote() {
        return produto_lote;
    }

    public Produto setProduto_lote(Integer produto_lote) {
        this.produto_lote = produto_lote;
        return this;
    }

    public String getProduto_data_fabricacao() {
        return produto_data_fabricacao;
    }

    public Produto setProduto_data_fabricacao(String produto_data_fabricacao) {
        this.produto_data_fabricacao = produto_data_fabricacao;
        return this;
    }

    public Boolean getProduto_deletado() {
        return produto_deletado;
    }

    public Produto setProduto_deletado(Boolean produto_deletado) {
        this.produto_deletado = produto_deletado;
        return this;
    }
}
