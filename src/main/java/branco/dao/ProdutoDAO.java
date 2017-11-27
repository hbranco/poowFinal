package branco.dao;


import branco.model.Produto;
import branco.model.ProdutoTipo;
import branco.model.Usuario;
import branco.util.ConectaPostgres;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    public Integer setProduto(Produto produto) throws SQLException, ClassNotFoundException {
        String sql = "insert into produto (produto_tipo_id, produto_codigo, produto_lote, produto_data_fabricacao) values(?,?,?,?)";
        PreparedStatement stmt  = ConectaPostgres.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, produto.getProduto_tipo_id());
        stmt.setString(2, produto.getProduto_codigo());
        stmt.setInt(3, produto.getProduto_lote());
        stmt.setString(4, produto.getProduto_data_fabricacao());
        stmt.execute();
        ResultSet numero = stmt.getGeneratedKeys();
        if(numero.next()){
            return numero.getInt(1);
//           System.out.println(numero.getInt(1));
        }
        return 0;
//        return true;
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


    /**
     * metodo para buscar um unico produto para edição
     * @param id
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */

    public Produto getProduto(Integer id) throws SQLException, ClassNotFoundException {
//        ArrayList<Produto> produtos = new ArrayList<>();

        String sql = "select * from produto as p join produto_tipo as pt on p.produto_tipo_id = pt.produto_tipo_id where p.produto_deletado = '0' and produto_id = ?";
        PreparedStatement stmt = ConectaPostgres.getConexao().prepareStatement(sql);
        stmt.setInt(1,id);
        ResultSet rs = stmt.executeQuery();
        Produto p = new Produto();
        while (rs.next()){
            p.setProduto_id(rs.getInt("produto_id"));
            p.setProduto_tipo_id(rs.getInt("produto_tipo_id"));
            p.setProduto_tipo_nome(rs.getString("produto_tipo_nome"));
            p.setProduto_codigo(rs.getString("produto_codigo"));
            p.setProduto_lote(rs.getInt("produto_lote"));
            p.setProduto_data_fabricacao(rs.getString("produto_data_fabricacao"));
//            produtos.add(p);
        }
        return p;
    }


    /**
     * metodo para deletar um unico produto
     * OBS: deleção logica
     * @param id
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Boolean deleteProduto(Integer id) throws SQLException, ClassNotFoundException {
        String sql = "update produto set produto_deletado = '1' where produto_id = ?";
        PreparedStatement stmt = ConectaPostgres.getConexao().prepareStatement(sql);
        stmt.setInt(1,id);
        stmt.executeUpdate();
        return true;


    }


    /**
     * metodo para update de produtos
     * @param produto
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Boolean updateProduto(Produto produto) throws SQLException, ClassNotFoundException {
        String sql = "update produto set produto_tipo_id = ? , produto_codigo = ? , produto_lote = ?, produto_data_fabricacao = ? where produto_id = ?";
        PreparedStatement stmt = ConectaPostgres.getConexao().prepareStatement(sql);
        stmt.setInt(1,produto.getProduto_tipo_id());
        stmt.setString(2,produto.getProduto_codigo());
        stmt.setInt(3,produto.getProduto_lote());
        stmt.setString(4,produto.getProduto_data_fabricacao());
        stmt.setInt(5,produto.getProduto_id());
//        System.out.println("sql: " + stmt.toString());
        stmt.executeUpdate();
        return true;

    }




}
