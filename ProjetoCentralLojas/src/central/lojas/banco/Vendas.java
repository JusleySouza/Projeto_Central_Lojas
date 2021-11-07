package central.lojas.banco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import central.lojas.dto.VendasObj;

public class Vendas {
	
	Connection conect;
	Statement sentenca;
	ResultSet procura;
	int registros;
	
	public Vendas() {
		conect = conexao.conectaBD();
		VendasObj vendas = new VendasObj();
	}
	
}
