package central.lojas.banco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

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
	
}
