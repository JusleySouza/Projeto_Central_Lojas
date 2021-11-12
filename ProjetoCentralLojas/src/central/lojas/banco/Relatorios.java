package central.lojas.banco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import central.lojas.dto.Cliente;
import central.lojas.dto.Funcionario;
import central.lojas.dto.Mercadoria;

public class Relatorios {
	
	Connection conect;
	Statement sentenca;
	ResultSet procura;
	int registros;
	
	public Relatorios() {
		conect = conexao.conectaBD();
	}
	
	public ArrayList<Funcionario> relatorioFuncionarios() {
		ArrayList<Funcionario> relatorioFuncionarios = new ArrayList<>();
		
		try {
			sentenca = conect.createStatement();
			procura = sentenca.executeQuery("SELECT cpf, nome, telefone, cargo FROM profissionais");
			
			while(procura.next()) {
				Funcionario funcionario =  new Funcionario();
				
				funcionario.setCpf(procura.getString("cpf"));
				funcionario.setNome(procura.getString("nome"));
				funcionario.setTelefone(procura.getString("telefone"));
				funcionario.setCargo(procura.getString("cargo"));
				
				relatorioFuncionarios.add(funcionario);
			}
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(null,ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
		}
		
		return relatorioFuncionarios;
	}
	
	public ArrayList<Cliente> relatorioClientes() {
		ArrayList<Cliente> relatorioClientes = new ArrayList<>();
		
		try {
			sentenca = conect.createStatement();
			procura = sentenca.executeQuery("SELECT cpf, nome, telefone, email FROM clientes");
			
			while(procura.next()) {
				Cliente cliente =  new Cliente();
				
				cliente.setCpf(procura.getString("cpf"));
				cliente.setNome(procura.getString("nome"));
				cliente.setTelefone(procura.getString("telefone"));
				cliente.setEmail(procura.getString("email"));
				
				
				relatorioClientes.add(cliente);
			}
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(null,ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
		}
		
		return relatorioClientes;
	}
	
		
	public ArrayList<Mercadoria> relatorioMercadorias() {
		ArrayList<Mercadoria> relatorioMercadorias = new ArrayList<>();
		
		try {
			sentenca = conect.createStatement();
			procura = sentenca.executeQuery("SELECT id, nome, quantidade_disponivel, preco, tamanho FROM mercadorias");
			
			while(procura.next()) {
				Mercadoria mercadoria =  new Mercadoria();
				
				mercadoria.setId(procura.getInt("id"));
				mercadoria.setNome(procura.getString("nome"));
				mercadoria.setQuantidade(procura.getInt("quantidade_disponivel"));
				mercadoria.setPreco(procura.getDouble("preco"));
				mercadoria.setTamanho(procura.getString("tamanho"));
				
				relatorioMercadorias.add(mercadoria);
			}
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(null,ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
		}
		
		return relatorioMercadorias;
	}

	
	
	
}
