package br.com.k19.jdbc;

//import javax.swing.JOptionPane;

public class App {
	public static void main(String[] args){
		
		//Editora editora = new Editora();
		//String nome = JOptionPane.showInputDialog("Digite o Nome da Editora");
		//String email = JOptionPane.showInputDialog("Digite o Email da Editora");
		//editora.insert(nome, email);
		//editora.all();
		Livro livro = new Livro();
		//String titulo = JOptionPane.showInputDialog("Digite o Titulo do Livro");
		//String preco = JOptionPane.showInputDialog("Digite o Preço do Livro");
		//String editora = JOptionPane.showInputDialog("Digite o Editora do Livro");
		//livro.insert(titulo,Float.parseFloat(preco), Integer.parseInt(editora));
		livro.all();
	}

}
