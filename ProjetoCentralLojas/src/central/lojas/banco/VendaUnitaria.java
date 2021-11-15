package central.lojas.banco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import central.lojas.dto.Mercadoria;
import central.lojas.dto.VendaUnitObj;

public class VendaUnitaria {
	
	Connection conect;
	Statement sentenca;
	ResultSet procura;
	int registros;
	
	public VendaUnitaria() {
	conect = conexao.conectaBD();
	}

	public int cadastrar(VendaUnitObj vendaUnitObj) {
		
		try {
			sentenca = conect.createStatement();
			registros = sentenca.executeUpdate("INSERT into venda_unitaria(venda_id, "
				+ "mercadoria_id, quantidade, total_pedido) values('"+vendaUnitObj.getIdVenda()+"', '"+vendaUnitObj.getIdMercadoria()+"',"
						+ " '"+vendaUnitObj.getQuantidade()+"', '"+vendaUnitObj.getTotalPedido()+"')");
		}
		catch(SQLException ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
		}
		
		return registros;
	}

	public void deletar(int idVenda, int idMercadoria, int quantidadeMercadoria) {
	
		try {
			sentenca = conect.createStatement();
			registros = sentenca.executeUpdate("DELETE from venda_unitaria WHERE "
					+ "venda_id='"+idVenda+"' and mercadoria_id='"+idMercadoria+"' "
					+ "and quantidade='"+quantidadeMercadoria+"'");
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(null,ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
		}	
	}

	public void deletarTodasVendasUnitarias(int idVenda) {
		try {
			sentenca = conect.createStatement();
			procura = sentenca.executeQuery("Select id_venda_unitaria from venda_unitaria WHERE venda_id='"+idVenda+"'");
			
			while(procura.next()) {
				sentenca = conect.createStatement();
				sentenca.executeUpdate("DELETE from venda_unitaria WHERE id_venda_unitaria='"+procura.getInt("id_venda_unitaria")+"'");
			}
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(null,ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
}
