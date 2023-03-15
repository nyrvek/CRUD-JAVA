package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoDAO {

    public Connection conexaoDB() {
        Connection conn = null;

        try {
            /*Declarando variáveis de conexão com a url do db nome do usuário e senha de acesso*/
            String url = "jdbc:mysql://localhost:3306/crud";
            String user = "root";
            String password = "Pa$$word";
            conn = DriverManager.getConnection(url,user,password);
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO CONEXÃO DAO " + erro);
        }
        return conn;
    }
}
