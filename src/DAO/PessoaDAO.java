package DAO;

import DTO.PessoaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PessoaDAO {

    Connection conn = null;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<PessoaDTO> lista = new ArrayList<>();

    public void Cadastrar(PessoaDTO objpessoadto) {
        /*Strin com comandos sql, cada ? significa um valor a ser recebido*/
        String sql = "insert into pessoa values(?,?,?,?)";

        conn = new ConexaoDAO().conexaoDB();

        try {
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, objpessoadto.getNome());
            pstm.setInt(2, objpessoadto.getIdade());
            pstm.setString(3, objpessoadto.getCpf());
            pstm.setFloat(4, objpessoadto.getDivida());

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO CADASTRAR PESSOA DAO " + erro);
        }

    }

    public ArrayList<PessoaDTO> Listar() {
        /*Criando variável com comando sql para selecionar campos*/
        String sql = "select * from pessoa";

        /*Usando mêtodo de conexao*/
        conn = new ConexaoDAO().conexaoDB();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                PessoaDTO objpessoadto = new PessoaDTO();

                objpessoadto.setNome(rs.getString("nome"));
                objpessoadto.setIdade(rs.getInt("idade"));
                objpessoadto.setCpf(rs.getString("cpf"));
                objpessoadto.setDivida(rs.getFloat("conta"));

                lista.add(objpessoadto);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO LISTAR PESSOA DAO " + erro);
        }
        return lista;
    }

    public void Alterar(PessoaDTO objpessoadto) {
        String sql = "update pessoa set nome=?,idade=?,conta=? where cpf = ?";

        conn = new ConexaoDAO().conexaoDB();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objpessoadto.getNome());
            pstm.setInt(2, objpessoadto.getIdade());
            pstm.setFloat(3, objpessoadto.getDivida());
            pstm.setString(4, objpessoadto.getCpf());

            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO UPDATE PESSOA DAO " + erro);
        }
    }

    public void Delete(PessoaDTO objpessoadto) {

        String sql = "delete from pessoa where cpf =?";
      
        conn = new ConexaoDAO().conexaoDB();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objpessoadto.getCpf());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null, "ERRO DELETAR PESSOA DAO "+ erro);
        }
    }
}
