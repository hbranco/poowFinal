package branco.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaPostgres {

    public static Connection getConexao() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        // abrir conexao
        String url = "jdbc:postgresql://localhost:5432/produto";
        String user = "postgres";
        String pass = "branco123";
        Connection conn = DriverManager.getConnection(url, user, pass);
        System.out.println("oi");

        return conn;

        }
    }


