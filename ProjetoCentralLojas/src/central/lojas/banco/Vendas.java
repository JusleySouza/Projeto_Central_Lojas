package central.lojas.banco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JOptionPane;

import central.lojas.dto.VendasObj;

public class Vendas {
	
	Connection conect;
	Statement sentenca;
	ResultSet procura;
	int registros;
	
	public Vendas() {
		conect = conexao.conectaBD();
		
	}
	
public VendasObj cadastrar(String idProfissional, String idCliente) {
		VendasObj vendas = new VendasObj();
	
		try {
			sentenca = conect.createStatement();
			registros = sentenca.executeUpdate("INSERT into venda_final(profissional_id, "
				+ "cliente_id) values('"+idProfissional+"', '"+idCliente+"')");
			procura = sentenca.executeQuery("SELECT * FROM venda_final ORDER BY id_venda_final DESC LIMIT 1");
			
			if (procura.next()) {
			vendas.setId(procura.getInt("id_venda_final"));
			vendas.setIdCliente(procura.getString("cliente_id"));
			vendas.setIdProfissional(procura.getString("profissional_id"));
			vendas.setTotal(0);
			}
		}
		catch(SQLException ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
		}
		
		
		return vendas;

	}
	
 public int uptade(String pagamento, double total, int id) {
	 Date dataCompra = new java.sql.Date(System.currentTimeMillis());
	 try {
			sentenca = conect.createStatement();
			registros = sentenca.executeUpdate("UPDATE venda_final SET data_compra='"+dataCompra+"', "
					+ "forma_pagamento='"+pagamento+"', total_venda='"+total+"' WHERE id_venda_final='"+id+"'");
		}
		catch(SQLException ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
		}
		
		
		return registros;

 }
 
 public void deletar(int idVenda) {
		
		try {
			sentenca = conect.createStatement();
			registros = sentenca.executeUpdate("DELETE from venda_final WHERE id_venda_final='"+idVenda+"'");
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(null,ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
		}	
 }

}
