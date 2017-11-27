package branco.dao;

import branco.model.ProdutoEstoque;
import branco.util.ConectaPostgres;
import org.springframework.stereotype.Repository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Repository
public class ProdutoEstoqueDAO {


    public ArrayList<ProdutoEstoque> getProdutoEstoque() throws SQLException, ClassNotFoundException {
        ArrayList<ProdutoEstoque> produtoEstoques = new ArrayList<>();

        String sql= "select * from produto_estoque as pe join produto as p on pe.produto_id = p.produto_id where pe.produto_estoque_estoque = '0'and p.produto_deletado = '0'";
        PreparedStatement statement = ConectaPostgres.getConexao().prepareStatement(sql);
        ResultSet rs = statement.executeQuery();

        while (rs.next()){
            ProdutoEstoque pe = new ProdutoEstoque();
            pe.setProduto_estoque_id(rs.getInt("produto_estoque_id"));
            pe.setProduto_estoque_dataentrada(rs.getString("produto_estoque_data_entrada"));
            pe.setProduto_estoque_estoque(rs.getBoolean("produto_estoque_estoque"));
            pe.setProduto_id(rs.getInt("produto_id"));
            pe.setProduto_lote(rs.getInt("produto_lote"));
            pe.setProduto_data_fabricacao(rs.getString("produto_data_fabricacao"));
            pe.setProduto_codigo(rs.getString("produto_codigo"));
            produtoEstoques.add(pe);
            }
            return produtoEstoques;
    }


    public Boolean produtoVendido(int id) throws SQLException, ClassNotFoundException {
        String sql = "update produto_estoque set produto_estoque_estoque = '1' where produto_estoque_id = ?";
        PreparedStatement statement = ConectaPostgres.getConexao().prepareStatement(sql);
        statement.setInt(1,id);
        statement.executeUpdate();
        return true;
    }



    public Boolean produtoEstoque(int id) throws SQLException, ClassNotFoundException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");

        String sql = "insert into produto_estoque (produto_id, produto_estoque_estoque, produto_estoque_data_entrada) values(?,?,?)";
        PreparedStatement statement = ConectaPostgres.getConexao().prepareStatement(sql);
        statement.setInt(1,id);
        statement.setBoolean(2,false);
        statement.setString(3,simpleDateFormat.format(date).toString());
        statement.execute();
        return true;




    }


    public Integer totalEstoque() throws SQLException, ClassNotFoundException {

        String sql = "select count(*) as total\n" +
                "from produto_estoque\n" +
                "join produto on produto_estoque.produto_id = produto.produto_id\n" +
                "where produto_estoque.produto_estoque_estoque = '0' and produto.produto_deletado = '0'";
        PreparedStatement statement = ConectaPostgres.getConexao().prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        if(rs.next()){
            return  rs.getInt("total");
        }

        return 0;
    }





    public Integer totalVendido() throws SQLException, ClassNotFoundException {

        String sql = "select count(*) as total\n" +
                "from produto_estoque\n" +
                "join produto on produto_estoque.produto_id = produto.produto_id\n" +
                "where produto_estoque.produto_estoque_estoque = '1' and produto.produto_deletado = '0'";
        PreparedStatement statement = ConectaPostgres.getConexao().prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        if(rs.next()){
            return  rs.getInt("total");
        }

        return 0;
    }







}
