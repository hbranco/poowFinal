package branco.dao;


import branco.model.Produto;
import branco.model.ProdutoTipo;
import branco.util.ConectaPostgres;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class ProdutoDAO {


    /**
     * Metodo para gravar um novo produto no banco de dados
     * @param produto
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean setProduto(Produto produto) throws SQLException, ClassNotFoundException {
        String sql = "insert into produto (produto_tipo_id, produto_codigo, produto_lote, produto_data_fabricacao) values(?,?,?,?)";
        PreparedStatement stmt  = ConectaPostgres.getConexao().prepareStatement(sql);
        stmt.setInt(1, produto.getProduto_tipo_id());
        stmt.setString(2, produto.getProduto_codigo());
        stmt.setInt(2, produto.getProduto_lote());
        stmt.setString(2, produto.getProduto_data_fabricacao());
        stmt.execute();
        return true;
    }


    /**
     * metodo que retorna uma lista com todos os produtos não deletados
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ArrayList<Produto> getProdutos() throws SQLException, ClassNotFoundException {
        ArrayList<Produto> produtos = new ArrayList<>();

        String sql = "select * from produto as p join produto_tipo as pt on p.produto_tipo_id = pt.produto_tipo_id where p.produto_deletado = '0'";
        PreparedStatement stmt = ConectaPostgres.getConexao().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            Produto p = new Produto();
            p.setProduto_id(rs.getInt("produto_id"));
            p.setProduto_tipo_id(rs.getInt("produto_tipo_id"));
            p.setProduto_tipo_nome(rs.getString("produto_tipo_nome"));
            p.setProduto_codigo(rs.getString("produto_codigo"));
            p.setProduto_lote(rs.getInt("produto_lote"));
            p.setProduto_data_fabricacao(rs.getString("produto_data_fabricacao"));
            produtos.add(p);
        }
        return produtos;
    }



}
