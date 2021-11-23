package central.lojas.testes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import central.lojas.banco.Estoque;
import central.lojas.dto.Mercadoria;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TesteMercadorias {

	private static Estoque estoque = new Estoque();
	
	 @Order(1)
	 @Test
	    public void testCadastroMercadoria() {
	    	int retornoEsperado=1;
	        int retornoConsulta = estoque.cadastrar("Samba Canção","2356847942", 30, 12.50, "M");
	        
	        assertEquals(retornoEsperado,retornoConsulta);

	    }
	 
	 @Order(2)
	 @Test
	    public void testConsultamercadoria() {
		 	Mercadoria mercadoriaEsperada = new Mercadoria();
	        Mercadoria mercadoriaConsultada = estoque.consulta("Samba Canção");

	        mercadoriaEsperada.setNome("Samba Canção");
	        mercadoriaEsperada.setLote("2356847942");
	        mercadoriaEsperada.setQuantidade(30);
	        mercadoriaEsperada.setPreco(12.50);
	        mercadoriaEsperada.setTamanho("M");
			
	        assertEquals(mercadoriaConsultada.toString(), mercadoriaEsperada.toString());

	    }
	 
	 @Order(3)
	 @Test
	 public void testAtualizaMercadoria() {
		 	Mercadoria mercadoriaEsperada = new Mercadoria();
		 	Mercadoria mercadoriaAtualizada = estoque.consulta("Samba Canção");
		 	
		 	mercadoriaEsperada.setId(mercadoriaAtualizada.getId());
		    mercadoriaEsperada.setNome("Cueca Samba Canção");
	        mercadoriaEsperada.setLote("2356847942");
	        mercadoriaEsperada.setQuantidade(30);
	        mercadoriaEsperada.setPreco(12.50);
	        mercadoriaEsperada.setTamanho("M");
			
			estoque.atualizar(mercadoriaEsperada);
			mercadoriaAtualizada = estoque.consulta(mercadoriaEsperada.getNome());
		
	        assertEquals(mercadoriaAtualizada.toString(), mercadoriaEsperada.toString());

	    }
	 
	 @Order(4)
	 @Test
	 public void testSubtrairMercadoria() {
		 
		 	Mercadoria mercadoriaEsperada = estoque.consulta("Cueca Samba Canção");
		 	
	        mercadoriaEsperada.setQuantidade(21);

			estoque.subtrairMercadoria(mercadoriaEsperada);
			Mercadoria mercadoriaAtualizada = estoque.consulta(mercadoriaEsperada.getNome());
			
	        assertEquals(mercadoriaAtualizada.toString(), mercadoriaEsperada.toString());
	 }
	 
	 @Order(5)
	 @Test
	 public void testExcluirMercadoria() {
		 	Mercadoria mercadoriaEsperada = new Mercadoria();
		 	Mercadoria mercadoriaConsultada = estoque.consulta("Cueca Samba Canção");
		 	
	        estoque.excluir(mercadoriaConsultada.getId());
	        
	    	Mercadoria mercadoriaExcluida = estoque.consulta(mercadoriaEsperada.getNome());
	     
	        assertEquals(mercadoriaExcluida.getLote(), null);
	 }
}
