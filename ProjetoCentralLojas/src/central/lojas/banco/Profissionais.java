package central.lojas.banco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import central.lojas.dto.Cliente;
import central.lojas.dto.Funcionario;

public class Profissionais {
	
		Connection conect;
		Statement sentenca;
		ResultSet procura;
		int registros;
		
		public Profissionais() {
			conect = conexao.conectaBD();
		}
		
		public int cadastrar(String nome, String telefone, String telefone_secundario_profissional, String cpf,
				String rg, String email, String rua, int numero, String bairro,
				String cidade, String sexo, String cargo) {
			try {
				sentenca = conect.createStatement();
				registros = sentenca.executeUpdate("INSERT into profissionais(nome, telefone, telefone_secundario_profissional,"
						+ " cpf, rg, email, rua, numero, bairro, cidade, sexo, cargo) values('"+nome+"',"
					+ "'"+telefone+"','"+telefone_secundario_profissional+"','"+cpf+"', '"+rg+"', "
					+ "'"+email+"','"+rua+"', '"+numero+"', '"+bairro+"', '"+cidade+"', '"+sexo+"', '"+cargo+"')");
			}
			catch(SQLException ex)
			{
				JOptionPane.showMessageDialog(null,ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
			}
			

			return registros;
		}
		
		public Funcionario consulta(String nome) {
			Funcionario funcionario =  new Funcionario();
			
			try {
				sentenca = conect.createStatement();
				procura = sentenca.executeQuery("SELECT * FROM profissionais WHERE nome='"+nome+"' LIMIT 1");
				
				if(procura.next()) {

					funcionario.setNome(procura.getString("nome"));
					funcionario.setTelefone(procura.getString("telefone"));
					funcionario.setTelefoneSecundario(procura.getString("telefone_secundario_profissional"));
					funcionario.setCpf(procura.getString("cpf"));
					funcionario.setRg(procura.getString("rg"));
					funcionario.setEmail(procura.getString("email"));
					funcionario.setRua(procura.getString("rua"));
					funcionario.setNumero(procura.getInt("numero"));
					funcionario.setBairro(procura.getString("bairro"));
					funcionario.setCidade(procura.getString("cidade"));
					funcionario.setCargo(procura.getString("cargo"));
					funcionario.setSexo(procura.getString("sexo"));
				}
			}
			catch(SQLException ex){
				JOptionPane.showMessageDialog(null,ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
			}
			
			return funcionario;
		}
		
		public void atualizar(Funcionario funcionario) {
			try {
				sentenca = conect.createStatement();
				registros = sentenca.executeUpdate("UPDATE profissionais SET nome='"+funcionario.getNome()+"'," +
	                    "telefone='"+funcionario.getTelefone()+"', telefone_secundario_profissional='"+funcionario.getTelefoneSecundario()+"'," +
	                    "cpf='"+funcionario.getCpf()+"', rg ='"+funcionario.getRg()+"', email='"+funcionario.getEmail()+"',"
	                    + " rua='"+funcionario.getRua()+"',"  + " numero='"+funcionario.getNumero()+"', "
	                    + "bairro ='"+funcionario.getBairro()+"',"+ "" + " cidade='"+funcionario.getCidade()+"',"
	                    + ""+ " sexo ='"+funcionario.getSexo()+"',"
	                    + ""+ "cargo= '"+funcionario.getCargo()+"'  WHERE nome='"+funcionario.getNome()+"'");
				JOptionPane.showMessageDialog(null,"Alteração realizada com sucesso!!!","Sucesso",JOptionPane.INFORMATION_MESSAGE);

			}
			catch(SQLException ex)
			{
				JOptionPane.showMessageDialog(null,ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
			}	
		}
		
		public void excluir(String nome) {
			try {
				sentenca = conect.createStatement();
				sentenca.executeUpdate("DELETE FROM profissionais  WHERE nome='"+nome+"'");
				JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso!!!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
			}
			catch(SQLException ex)
			{
				JOptionPane.showMessageDialog(null,ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
			}
			
		}
}
