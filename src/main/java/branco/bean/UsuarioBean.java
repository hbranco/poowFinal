package branco.bean;

import branco.model.Usuario;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

/**
 * classe de autenticação do usuario na session
 */


@Component
@Scope("session")
public class UsuarioBean {

    private Usuario usuario;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Usuario getUsuario() {
        return usuario;
    }



}
