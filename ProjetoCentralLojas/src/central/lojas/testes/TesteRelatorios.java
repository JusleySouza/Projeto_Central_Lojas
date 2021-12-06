package central.lojas.testes;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import central.lojas.banco.Relatorios;
import central.lojas.dto.Cliente;
import central.lojas.dto.Funcionario;
import central.lojas.dto.Mercadoria;
import central.lojas.dto.RelatorioVendasObj;

public class TesteRelatorios {
	
	private static Relatorios relatorios = new Relatorios();
	
	 @Test
	public void testRelatorioMercadorias() {
		 ArrayList<Mercadoria> relatorioMercadoriasRecebido = relatorios.relatorioMercadorias();
				 
		 assertTrue(relatorioMercadoriasRecebido.get(0) instanceof Mercadoria);
	}
	 
	 @Test
	public void testRelatorioClientes() {
		 ArrayList<Cliente> relatorioClientesRecebido = relatorios.relatorioClientes();
		 
		 assertTrue(relatorioClientesRecebido.get(0) instanceof Cliente);
	} 
	 
	 @Test
	public void testRelatorioFuncionarios() {
		 ArrayList<Funcionario> relatorioFuncionariosRecebido = relatorios.relatorioFuncionarios();
			 
		assertTrue(relatorioFuncionariosRecebido.get(0) instanceof Funcionario);
	} 
	 
	 @Test
	public void testRelatorioVendas() {
		ArrayList<RelatorioVendasObj> relatorioVendasRecebido = relatorios.relatorioVendas();
		
		assertTrue(relatorioVendasRecebido.get(0) instanceof RelatorioVendasObj);
	}
}
