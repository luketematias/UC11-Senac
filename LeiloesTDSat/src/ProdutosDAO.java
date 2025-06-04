/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutosDAO {

    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    public boolean cadastrarProduto(ProdutosDTO prod) {

        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";

        try {
            conectaDAO conn = new conectaDAO();
            conn.conectar();

            PreparedStatement ps = conn.getConexao().prepareStatement(sql);

            ps.setString(1, prod.getNome());
            ps.setString(2, String.valueOf(prod.getValor()));
            ps.setString(3, prod.getStatus());

            int atualizacaoTabela = ps.executeUpdate();
            System.out.println("Produto cadastrado com sucesso");
            conn.desconectar();
            return atualizacaoTabela > 0;
        } catch (SQLException se) {
            System.err.println("Error ao cadastrar produto: " + se.getMessage());
            return false;
        }
    
    }

    public ArrayList<ProdutosDTO> listarProdutos() {

        return listagem;
    }

}
