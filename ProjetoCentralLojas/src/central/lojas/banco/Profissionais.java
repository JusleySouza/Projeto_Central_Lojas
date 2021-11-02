package BancoDeDados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Profissionais {
	
		Connection conect;
		Statement sentenca;
		ResultSet procura;
		int registros;
		
		public Profissionais() {
			conect = conexao.conectaBD();
		}
		
		public int cadastrar(String nome, String telefone, String telefone_secundario_profissionais, String cpf,
				String rg, String email, String rua, int numero, String bairro,
				String cidade, String sexo, String cargo) {
			try {
				sentenca = conect.createStatement();
				registros = sentenca.executeUpdate("INSERT into profissionais(nome, telefone, telefone_secundario_profissionais,"
						+ " cpf, rg, email, rua, numero, bairro, cidade, sexo, cargo) values('"+nome+"',"
					+ "'"+telefone+"','"+telefone_secundario_profissionais+"','"+cpf+"', '"+rg+"', "
					+ "'"+email+"','"+rua+"', '"+numero+"', '"+bairro+"', '"+cidade+"', '"+sexo+"', '"+cargo+"')");
			}
			catch(SQLException ex)
			{
				JOptionPane.showMessageDialog(null,ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
			}
			

			return registros;
		}
}
