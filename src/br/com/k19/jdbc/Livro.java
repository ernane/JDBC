package br.com.k19.jdbc;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class Livro {
	Vector columnNames = new Vector();
    Vector data = new Vector();
    JPanel panel = new JPanel(); 
    
	public void insert(String titulo, float preco, int editora_id) {
		try {

			System.out.println("Abrindo Conexão...");
			Connection conexao = ConnectionFactory.createConnection();

			String sql = "INSERT INTO Livro ( titulo , preco, editora_id ) VALUES (?, ?, ?)";

			PreparedStatement comando = conexao.prepareStatement(sql);
			comando.setString(1, titulo);
			comando.setFloat(2, preco);
			comando.setInt(3, editora_id);

			System.out.println(" Executando comando ... ");
			comando.execute();

			System.out.println(" Fechando conexão ... ");
			JOptionPane.showMessageDialog(null,	"Registro inserido com Sucesso.");
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
public void all(){
		
		try {
			
			System.out.println("Abrindo Conexão...");
			Connection conexao = ConnectionFactory.createConnection();
			
			String sql = "SELECT * FROM Livro;";
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			System.out.println("Executando comando...");
			ResultSet resultado = comando.executeQuery();
			
			ResultSetMetaData metaData = resultado.getMetaData();
            int columns = metaData.getColumnCount();
            
            for (int i = 1; i <= columns; i++) {
                columnNames.addElement(metaData.getColumnName(i));
            }

			
			while (resultado.next()) {
				Vector row = new Vector(columns);
                
				for (int i = 1; i <= columns; i++) {
                    row.addElement(resultado.getObject(i));
                }
                data.addElement(row);

				//System.out.println(resultado.getInt("id"));
				//System.out.println(resultado.getString("nome"));
				//System.out.println(resultado.getString("email"));
			}
			
			System.out.println("Fechando conexão...");
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JTable table = new JTable(data, columnNames);
		TableColumn column;
		for (int i = 0; i < table.getColumnCount(); i++) {
			column = table.getColumnModel().getColumn(i);
			column.setMaxWidth(800);
			
		}
		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane);
		JFrame frame = new JFrame("Listagens de Livros");
		frame.add(panel); // adding panel to the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 900); // setting frame size
		frame.setVisible(true); // setting visibility true
		frame.setBackground(Color.gray);
	}
}
