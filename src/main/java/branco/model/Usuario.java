package branco.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Usuario {
    private Integer usuario_id;

    @NotEmpty
    private String usuario_nome;

    @NotEmpty
    @Size(min=3)
    private String usuario_senha;
    private Boolean usuario_auth;


    public Usuario() {
    }

    public Usuario(@NotEmpty String usuario_nome, @NotEmpty @Size(min = 3) String usuario_senha) {
        this.usuario_nome = usuario_nome;
        this.usuario_senha = usuario_senha;
    }


    public Integer getUsuario_id() {
        return usuario_id;
    }

    public Usuario setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
        return this;
    }

    public String getUsuario_nome() {
        return usuario_nome;
    }

    public Usuario setUsuario_nome(String usuario_nome) {
        this.usuario_nome = usuario_nome;
        return this;
    }

    public String getUsuario_senha() {
        return usuario_senha;
    }

    public Usuario setUsuario_senha(String usuario_senha) {
        this.usuario_senha = usuario_senha;
        return this;
    }

    public Boolean getUsuario_auth() {
        return usuario_auth;
    }

    public Usuario setUsuario_auth(Boolean usuario_auth) {
        this.usuario_auth = usuario_auth;
        return this;
    }
}
