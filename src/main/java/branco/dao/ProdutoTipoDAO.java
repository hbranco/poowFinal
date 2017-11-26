package branco.dao;


import branco.model.ProdutoTipo;
import branco.util.ConectaPostgres;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class ProdutoTipoDAO {


    /**
     * Metodo para Cadastrar um novo tipo de Produto
     * @param produtoTipo
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Boolean cadastrar(ProdutoTipo produtoTipo) throws SQLException, ClassNotFoundException {
        String sql = "insert into produto_tipo (produto_tipo_nome, produto_tipo_obs) values(?,?)";
        PreparedStatement stmt  = ConectaPostgres.getConexao().prepareStatement(sql);
        stmt.setString(1,produtoTipo.getProduto_tipo_nome());
        stmt.setString(2,produtoTipo.getProduto_tipo_obs());
        stmt.execute();
        return true;

    }


    /**
     * meotodo para retornar todos os tipos de produtos
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ArrayList<ProdutoTipo> getProdutoTipo() throws SQLException, ClassNotFoundException {
        ArrayList<ProdutoTipo> produtoTipos = new ArrayList<>();

        String sql = "select * from produto_tipo";
        PreparedStatement stmt = ConectaPostgres.getConexao().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            ProdutoTipo pt = new ProdutoTipo();
            pt.setProduto_tipo_id(rs.getInt("produto_tipo_id"));
            pt.setProduto_tipo_nome(rs.getString("produto_tipo_nome"));
            pt.setProduto_tipo_obs(rs.getString("produto_tipo_ob"));
            produtoTipos.add(pt);
        }

        return produtoTipos;


    }




}
