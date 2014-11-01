package br.com.k19.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsereEditora {
	public static void main(String[] args) {

		String stringDeConexao = "jdbc:mysql://192.168.33.10:3306/livraria";
		String usuario = "root";
		String senha = "sefa123";

		Scanner entrada = new Scanner(System.in);

		try {
			System.out.println("Abrindo Conexão...");
			Connection conexao = DriverManager.getConnection(stringDeConexao,usuario, senha);
			
			System.out.println(" Digite o nome da editora : ");
			String nome = entrada.nextLine();
			
			System.out.println(" Digite o email da editora : ");
			String email = entrada.nextLine();
			
			String sql = " INSERT INTO Editora ( nome , email ) " + " VALUES ( '" + nome + "', '" + email + "') ";
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
