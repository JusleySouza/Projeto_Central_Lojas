package central.lojas.testes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import central.lojas.banco.VendaUnitaria;
import central.lojas.banco.Vendas;
import central.lojas.dto.VendaUnitObj;
import central.lojas.dto.VendasObj;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TesteVendas {
	
	private static VendasObj vendaFinalEsperada = new VendasObj();
	private static VendasObj vendaFinalRecebida = new VendasObj();
	private static VendaUnitObj vendaUnitariaEsperada = new VendaUnitObj();
	private static VendaUnitObj vendaUnitariaRecebida = new VendaUnitObj();
	private static Vendas vendasFinal = new Vendas();
	private static VendaUnitaria vendasUnitarias = new VendaUnitaria();
	
	@Order(1)
	@Test
	public void testCriacaoVendaFinal() {
		
		vendaFinalEsperada.setIdCliente("121.212.121-21");
		vendaFinalEsperada.setIdProfissional("111.111.111-11");
		
		vendaFinalRecebida = vendasFinal.cadastrar("111.111.111-11", "121.212.121-21");
		vendaFinalEsperada.setId(vendaFinalRecebida.getId());

		assertEquals(vendaFinalRecebida.toString(), vendaFinalEsperada.toString());
	}
	
	@Order(2)
	@Test
	public void testCriacaoVendaUnitaria() {
		
		vendaUnitariaEsperada.setIdMercadoria(1);
		vendaUnitariaEsperada.setIdVenda(vendaFinalRecebida.getId());
		vendaUnitariaEsperada.setQuantidade(3);
		vendaUnitariaEsperada.setTotalPedido(218.93);
		
		vendasUnitarias.cadastrar(vendaUnitariaEsperada);
		vendaUnitariaRecebida = vendasUnitarias.consultar(vendaUnitariaEsperada);
		vendaUnitariaEsperada.setIdUnitaria(vendaUnitariaRecebida.getIdUnitaria());
		
		assertEquals(vendaUnitariaRecebida.toString(), vendaUnitariaEsperada.toString());
	}
	
	@Order(3)
	@Test
	public void testFecharVenda() {
		Date dataCompra = new java.sql.Date(System.currentTimeMillis());
		vendaFinalEsperada.setData(dataCompra);
		vendaFinalEsperada.setPagamento("dinheiro");
		vendaFinalEsperada.setTotal(320.00);
		
		vendasFinal.uptade("dinheiro", 320.00, vendaFinalEsperada.getId());
		vendaFinalRecebida = vendasFinal.consultar(vendaFinalEsperada.getId());
		
		assertEquals(vendaFinalRecebida.toString(), vendaFinalEsperada.toString());
	}
	
	@Order(4)
	@Test
	public void testCancelarVenda() {
		
		vendaFinalEsperada.setId(0);
		vendaFinalEsperada.setIdProfissional(null);
		vendaFinalEsperada.setIdCliente(null);
		vendaFinalEsperada.setData(null);
		vendaFinalEsperada.setPagamento(null);
		vendaFinalEsperada.setTotal(0.0);
		
		vendasUnitarias.deletarTodasVendasUnitarias(vendaFinalRecebida.getId());
		vendasFinal.deletar(vendaFinalRecebida.getId());
		
		vendaFinalRecebida = vendasFinal.consultar(vendaFinalRecebida.getId());
		
		assertEquals(vendaFinalRecebida.toString(), vendaFinalEsperada.toString());
	}
}
