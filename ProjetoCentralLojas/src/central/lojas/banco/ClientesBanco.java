package central.lojas.banco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import central.lojas.dto.Cliente;
import central.lojas.dto.Mercadoria;

public class ClientesBanco {
	Connection conect;
	Statement sentenca;
	ResultSet procura;
	int registros;
	
	public ClientesBanco() {
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
	
	public Cliente consulta(String nome) {
		Cliente cliente =  new Cliente();
		
		try {
			sentenca = conect.createStatement();
			procura = sentenca.executeQuery("SELECT * FROM clientes WHERE nome='"+nome+"' LIMIT 1");
			
			if(procura.next()) {

				cliente.setNome(procura.getString("nome"));
				cliente.setTelefone(procura.getString("telefone"));
				cliente.setTelefoneSecundario(procura.getString("telefone_secundario"));
				cliente.setCpf(procura.getString("cpf"));
				cliente.setRg(procura.getString("rg"));
				cliente.setEmail(procura.getString("email"));
				cliente.setRua(procura.getString("rua"));
				cliente.setNumero(procura.getInt("numero"));
				cliente.setBairro(procura.getString("bairro"));
				cliente.setCidade(procura.getString("cidade"));
				cliente.setSexo(procura.getString("sexo"));
				
			}
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(null,ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
		}
		
		System.out.println(cliente);
		
		return cliente;
		
	}
	
	public void atualizar(Cliente cliente) {
		System.out.println(cliente.getNome());
		try {
			sentenca = conect.createStatement();
			registros = sentenca.executeUpdate("UPDATE clientes SET nome='"+cliente.getNome()+"'," +
                    "telefone='"+cliente.getTelefone()+"', telefone_secundario='"+cliente.getTelefoneSecundario()+"'," +
                    "cpf='"+cliente.getCpf()+"', rg ='"+cliente.getRg()+"', email='"+cliente.getEmail()+"', rua='"+cliente.getRua()+"'," 
                    + " numero='"+cliente.getNumero()+"', bairro ='"+cliente.getBairro()+"'," + " cidade='"+cliente.getCidade()+"',"
                    		+ " sexo ='"+cliente.getSexo()+"'  WHERE nome='"+cliente.getNome()+"'");
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
			sentenca.executeUpdate("DELETE FROM clientes  WHERE nome='"+nome+"'");
			JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso!!!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
		}
		catch(SQLException ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
		}
		
	}

		
	}

		
	
	

