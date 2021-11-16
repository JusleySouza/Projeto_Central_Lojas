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
import central.lojas.dto.RelatorioVendasObj;

public class Relatorios {
	
	Connection conect;
	Statement sentenca;
	ResultSet procura;
	ResultSet vendas;
	ResultSet vendedor;
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
	
	public ArrayList<RelatorioVendasObj> relatorioVendas() {
		ArrayList<RelatorioVendasObj> relatorioVendas = new ArrayList<>();
		
		try {
			sentenca = conect.createStatement();
			procura = sentenca.executeQuery("SELECT * FROM venda_final");
			
			while(procura.next()) {
				RelatorioVendasObj relatorio =  new RelatorioVendasObj();
				
				relatorio.setTotalVenda(procura.getDouble("total_venda"));
				relatorio.setComissao(procura.getDouble("total_venda"));
				
				sentenca = conect.createStatement();
				vendedor = sentenca.executeQuery("SELECT nome FROM profissionais WHERE cpf='"+procura.getString("profissional_id")+"'");
				if(vendedor.next()) {
					relatorio.setNomeFuncionario(vendedor.getString("nome"));
				}
				
				sentenca = conect.createStatement();
				vendas = sentenca.executeQuery("SELECT quantidade FROM venda_unitaria WHERE venda_id='"+procura.getInt("id_venda_final")+"'");
				
				while(vendas.next()) {
					relatorio.setQuantidadePecas(relatorio.getQuantidadePecas() + vendas.getInt("quantidade"));
				}

				relatorioVendas.add(relatorio);
			}
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(null,ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
		}
		
		return relatorioVendas;
	}
	
	
	
}
