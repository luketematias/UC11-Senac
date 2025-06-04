
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {
    
    private Connection conexao;

    public Connection getConexao() {
        return conexao;
    }
    
    public void conectar() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/uc11", "root", "12345");
            System.out.println("SUCESSO DE CONEXÃO!");
        } catch (ClassNotFoundException cn) {
            System.out.println("Error ao conectar com o banco " + cn);
        } catch (SQLException sql) {
            System.out.println("Eror de SQL: " + sql);
        }
    }

    public void desconectar() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
                System.out.println("DESCONECTADO");
            }
        } catch (SQLException se) {
            System.out.println("Probelma ao desconectar do banco: " + se);
        }
    }
    
}
