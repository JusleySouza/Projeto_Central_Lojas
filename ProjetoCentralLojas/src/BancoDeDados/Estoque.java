package BancoDeDados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Estoque {
	Connection conect;
	Statement sentenca;
	ResultSet procura;
	int registros;
	
	public Estoque() {
		conect = conexao.conectaBD();
	}
	
	public int cadastrar(String nome, String lote, int quantidade, double preco, String tamanho) {
		
		try {
			sentenca = conect.createStatement();
			registros = sentenca.executeUpdate("INSERT into mercadorias(nome, "
					+ "lote, quantidade_disponivel, preco, tamanho)"
					+ " values('"+nome+"',"
					+ "'"+lote+"','"+quantidade+"','"+preco+"', '"+tamanho+"')");
		}
		catch(SQLException ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
		}
		
		
		return registros;

	}
}
