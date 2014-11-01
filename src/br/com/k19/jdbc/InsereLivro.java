package br.com.k19.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class InsereLivro {
	public static void main(String[] args) {
		String stringDeConexao = "jdbc:mysql://192.168.33.10:3306/livraria";
		String usuario = "root";
		String senha = "sefa123";

		try {

			System.out.println("Abrindo Conexão...");
			Connection conexao = DriverManager.getConnection(stringDeConexao,usuario, senha);
			
			String titulo = JOptionPane.showInputDialog("Digite o Título do Livro");
			
			String preco = JOptionPane.showInputDialog("Digite o Valor do Livro");
			
			String editora = JOptionPane.showInputDialog("Digite a Editora do Livro");
			
			float Preco = Float.parseFloat(preco);
			float Editora = Float.parseFloat(editora);
			
			String sql = " INSERT INTO Livro ( titulo , preco, editora_id ) " + " VALUES ( '" + titulo + "', '" + Preco + "', '" + Editora + "') ";
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			System.out.println(" Executando comando ... ");
			comando.execute();
			
			System.out.println(" Fechando conexão ... ");
			conexao.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
