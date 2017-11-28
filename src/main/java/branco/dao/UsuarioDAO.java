package branco.dao;

import branco.model.Usuario;
import branco.util.ConectaPostgres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UsuarioDAO {


    /**
     * metodo para validar um usuario
     * @param usuario
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean autentica(Usuario usuario) throws SQLException, ClassNotFoundException {
        String sql = "select * from usuario where usuario_nome = ? and usuario_senha = ?";
        PreparedStatement stmt = ConectaPostgres.getConexao().prepareStatement(sql);
        stmt.setString(1, usuario.getUsuario_nome());
        stmt.setString(2, usuario.getUsuario_senha());
        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            System.out.println("Usuario Logado");
            return true;
        }
        System.out.println("usuario não logado");
        return false;

    }

    /**
     * metodo para cadastrar um novo usuario
     * @param usuario
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */

    public boolean cadastrar(Usuario usuario) throws SQLException, ClassNotFoundException {
        String sql = "insert into usuario (usuario_nome, usuario_senha) values (?,?)";
        PreparedStatement stmt = ConectaPostgres.getConexao().prepareStatement(sql);
        stmt.setString(1,usuario.getUsuario_nome());
        stmt.setString(2,usuario.getUsuario_senha());
        stmt.execute();
        return true;

    }




}
