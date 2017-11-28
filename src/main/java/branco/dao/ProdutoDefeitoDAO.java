package branco.dao;

import branco.model.ProdutoDefeito;
import branco.model.ProdutoTeste;
import branco.util.ConectaPostgres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Repository
public class ProdutoDefeitoDAO {

    @Autowired
    ProdutoTesteDAO daoPT;
    /**
     * metodo para listas todos os produtos com defeito
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ArrayList<ProdutoDefeito> getProdutoDefeito() throws SQLException, ClassNotFoundException {
        ArrayList<ProdutoDefeito> produtoDefeito = new  ArrayList<>();
        String sql = "SELECT *\n" +
                "FROM produto_defeito AS pd\n" +
                "  JOIN produto ON pd.produto_id = produto.produto_id\n" +
                "  where pd.produto_defeito_conserto = '0'";

        PreparedStatement statement = ConectaPostgres.getConexao().prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        while (rs.next()){
            ProdutoDefeito pd = new ProdutoDefeito();
            pd.setProduto_defeito_conserto(rs.getBoolean("produto_defeito_conserto"));
            pd.setProduto_defeito_data_in(rs.getString("produto_defeito_data_in"));
            pd.setProduto_defeito_data_out(rs.getString("produto_defeito_data_out"));
            pd.setProduto_defeito_id(rs.getInt("produto_defeito_id"));
            pd.setProduto_codigo(rs.getString("produto_codigo"));
            pd.setProduto_id(rs.getInt("produto_id"));
            pd.setProduto_lote(rs.getInt("produto_lote"));
            pd.setProduto_data_fabricacao(rs.getString("produto_data_fabricacao"));
            produtoDefeito.add(pd);
        }
        return produtoDefeito;
    }


    /**
     * Metodo de conserto de um produto
     * @param produto_defeito_id
     * @param produto_id
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */

    public boolean produtoConsertado(int produto_defeito_id, int produto_id) throws SQLException, ClassNotFoundException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");

        String sql = "update produto_defeito set produto_defeito_conserto = '1' where produto_defeito_id = ? ";
        PreparedStatement statement = ConectaPostgres.getConexao().prepareStatement(sql);
        statement.setInt(1,produto_defeito_id);
        statement.executeUpdate();

        ProdutoTeste produtoTeste = new ProdutoTeste();
        produtoTeste.setProduto_teste_obs("Produto Consertado Em Teste");
        produtoTeste.setProduto_id(produto_id);
        produtoTeste.setProduto_teste_data_inicio(simpleDateFormat.format(date).toString());
        produtoTeste.setProduto_teste_data_final("-");
        produtoTeste.setProduto_teste_tipo_id(1);
        daoPT.novoTeste(produtoTeste);

        return true;
    }


    /**
     * Metodo para adicionar um produto a lsita de defeitos
     * @param id
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean produtoComDefeito(int id) throws SQLException, ClassNotFoundException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String sql = "insert into produto_defeito (produto_id, produto_defeito_conserto, produto_defeito_data_in) values(?,?,?)";
        PreparedStatement statement = ConectaPostgres.getConexao().prepareStatement(sql);
        statement.setInt(1,id);
        statement.setBoolean(2,false);
        statement.setString(3,simpleDateFormat.format(date));
        statement.execute();
        return true;
    }


    public Integer totalDefeito() throws SQLException, ClassNotFoundException {

        String sql = "SELECT count(*) as total\n" +
                "FROM produto_defeito\n" +
                "  JOIN produto ON produto_defeito.produto_id = produto.produto_id\n" +
                "where produto_defeito.produto_defeito_conserto = '0' and produto.produto_deletado ='0'";
        PreparedStatement statement = ConectaPostgres.getConexao().prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        if(rs.next()){
            return  rs.getInt("total");
        }

        return 0;
    }


}
