package BancoDeDados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Clientes {
	Connection conect;
	Statement sentenca;
	ResultSet procura;
	int registros;
	
	public Clientes() {
		conect = conexao.conectaBD();
	}
	
	public int cadastrar(String nome, String telefone, String telsecund, String cpf,
			String rg, String email, String rua, int numeroC, String bairro,
			String cidade, String sexo) {
		try {
			sentenca = conect.createStatement();
			registros = sentenca.executeUpdate("INSERT into clientes values('"+nome+"',"
				+ "'"+telefone+"','"+telsecund+"','"+cpf+"', '"+rg+"', "
				+ "'"+email+"','"+rua+"', '"+numeroC+"', '"+bairro+"', '"+cidade+"', '"+sexo+"')");
		}
		catch(SQLException ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
		}
		

		return registros;
	}
}
