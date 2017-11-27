package branco.dao;


import branco.model.ProdutoTeste;
import branco.util.ConectaPostgres;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class ProdutoTesteDAO {

    /**
     * Metodo que adiciona um produto a um novo teste.
     * @param produtoTeste
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
        public Boolean novoTeste(ProdutoTeste produtoTeste) throws SQLException, ClassNotFoundException {
            String sql = "insert into produto_teste (produto_teste_tipo_id, produto_teste_obs, produto_teste_data_inicio, produto_teste_data_final, produto_id, produto_teste_check)" +
                    "values(?,?,?,?,?,?)";
            PreparedStatement stmt = ConectaPostgres.getConexao().prepareStatement(sql);
            stmt.setInt(1,produtoTeste.getProduto_teste_tipo_id());
            stmt.setString(2, produtoTeste.getProduto_teste_obs());
            stmt.setString(3,produtoTeste.getProduto_teste_data_inicio());
            stmt.setString(4,produtoTeste.getProduto_teste_data_final());
            stmt.setInt(5,produtoTeste.getProduto_id());
            stmt.setBoolean(6, false);
            stmt.execute();
            return true;
        }


    /**
     * metodo que busca todos os produtos em teste.
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
        public ArrayList<ProdutoTeste> getProtudoTeste() throws SQLException, ClassNotFoundException {
            ArrayList<ProdutoTeste> produtoTestes = new ArrayList<>();
            String sql = "SELECT *\n" +
                    "FROM produto_teste AS pt\n" +
                    "  JOIN produto AS p ON pt.produto_id = p.produto_id\n" +
//                    "  join teste_tipo as tt on pt.produto_teste_tipo_id = tt.teste_tipo_id\n" +
                    "WHERE  pt.produto_teste_check = '0' and p.produto_deletado = '0'";

            PreparedStatement statement = ConectaPostgres.getConexao().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                ProdutoTeste pt = new ProdutoTeste();
                pt.setProduto_teste_tipo_id(rs.getInt("produto_teste_tipo_id"));
                pt.setProduto_teste_data_final(rs.getString("produto_teste_data_final"));
                pt.setProduto_teste_data_inicio(rs.getString("produto_teste_data_inicio"));
                pt.setProduto_teste_id(rs.getInt("produto_teste_id"));
                pt.setProduto_teste_obs(rs.getString("produto_teste_obs"));
                pt.setProduto_codigo(rs.getString("produto_codigo"));
                pt.setProduto_data_fabricacao(rs.getString("produto_data_fabricacao"));
                pt.setProduto_lote(rs.getInt("produto_lote"));
                produtoTestes.add(pt);
            }
            return produtoTestes;
        }


}
