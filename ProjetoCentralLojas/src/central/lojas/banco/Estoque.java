package central.lojas.banco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import central.lojas.dto.Mercadoria;;

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
	

	public Mercadoria consulta(String nome) {
		Mercadoria mercadoria =  new Mercadoria();
		
		try {
			sentenca = conect.createStatement();
			procura = sentenca.executeQuery("SELECT * FROM mercadorias WHERE nome='"+nome+"' LIMIT 1");
			
			if(procura.next()) {
				mercadoria.setId(procura.getInt("id"));;
				mercadoria.setNome(procura.getString("nome"));
				mercadoria.setLote(procura.getString("lote"));
				mercadoria.setQuantidade(procura.getInt("quantidade_disponivel"));
				mercadoria.setPreco(procura.getDouble("preco"));
				mercadoria.setTamanho(procura.getString("tamanho"));
			}
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(null,ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
		}
		
		System.out.println(mercadoria);
		
		return mercadoria;
		
	}
	
	public int atualizar(Mercadoria mercadoria) {
		System.out.println(mercadoria.getId());
		try {
			sentenca = conect.createStatement();
			registros = sentenca.executeUpdate("UPDATE mercadorias SET nome='"+mercadoria.getNome()+"'," +
                    "lote='"+mercadoria.getLote()+"', quantidade_disponivel='"+mercadoria.getQuantidade()+"'," +
                    "preco='"+mercadoria.getPreco()+"', tamanho ='"+mercadoria.getTamanho()+"'  WHERE id='"+mercadoria.getId()+"'");
			JOptionPane.showMessageDialog(null,"Alteração realizada com sucesso!!!","Sucesso",JOptionPane.INFORMATION_MESSAGE);

		}
		catch(SQLException ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
		}
		
		return (registros);	
	}
	
	public void excluir(int id) {
		try {
			sentenca = conect.createStatement();
			registros = sentenca.executeUpdate("DELETE FROM mercadorias  WHERE id='"+id+"'");
			JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso!!!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
		}
		catch(SQLException ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
