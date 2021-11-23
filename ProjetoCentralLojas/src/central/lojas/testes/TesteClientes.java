package central.lojas.testes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import central.lojas.banco.ClientesBanco;
import central.lojas.dto.Cliente;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TesteClientes {

	private static ClientesBanco clientesBanco = new ClientesBanco();
	
	 @Order(1)
	 @Test
	    public void testCadastroCliente() {
	    	int retornoEsperado=1;
	        int retornoConsulta = clientesBanco.cadastrar("Andrea Freitas","6359-4512", "3256-7845", "151.515.151-51",
			"15.151.515-1", "andreafreitas@gmail.com", "Maria Rocha", 64 , "Pompéia",
			"Rio Grande do Sul", "F");
	        
	        assertEquals(retornoEsperado,retornoConsulta);

	    }
	 
	 @Order(2)
	 @Test
	    public void testConsultaCliente() {
		 	Cliente clienteEsperado = new Cliente();
	        Cliente clienteConsultado = clientesBanco.consulta("Andrea Freitas");

	        clienteEsperado.setNome("Andrea Freitas");
			clienteEsperado.setTelefone("6359-4512");
			clienteEsperado.setTelefoneSecundario("3256-7845");
			clienteEsperado.setCpf("151.515.151-51");
			clienteEsperado.setRg("15.151.515-1");
			clienteEsperado.setEmail("andreafreitas@gmail.com");
			clienteEsperado.setRua("Maria Rocha");
			clienteEsperado.setNumero(64);
			clienteEsperado.setBairro("Pompéia");
			clienteEsperado.setCidade("Rio Grande do Sul");
			clienteEsperado.setSexo("F");
			
	        assertEquals(clienteConsultado.toString(), clienteEsperado.toString());

	    }
	 
	 @Order(3)
	 @Test
	 public void testAtualizaCliente() {
		 	Cliente clienteEsperado = new Cliente();

	        clienteEsperado.setNome("Andrea Freitas");
			clienteEsperado.setTelefone("6359-4512");
			clienteEsperado.setTelefoneSecundario("3256-7845");
			clienteEsperado.setCpf("151.515.151-51");
			clienteEsperado.setRg("15.151.515-1");
			clienteEsperado.setEmail("andreafreitas@gmail.com");
			clienteEsperado.setRua("Maria Rocha");
			clienteEsperado.setNumero(81);
			clienteEsperado.setBairro("Pompéia");
			clienteEsperado.setCidade("Rio Grande do Sul");
			clienteEsperado.setSexo("F");
			
			clientesBanco.atualizar(clienteEsperado);
			Cliente clienteAtualizado = clientesBanco.consulta(clienteEsperado.getNome());
	        
	        assertEquals(clienteAtualizado.toString(), clienteEsperado.toString());

	    }
	 
	 @Order(4)
	 @Test
	 public void testExcluirCliente() {
		 	Cliente clienteEsperado = new Cliente();
	        clientesBanco.excluir("Andrea Freitas");
	        
	    	Cliente clienteExcluido = clientesBanco.consulta(clienteEsperado.getNome());
	     
	        assertEquals(clienteExcluido.getCpf(), null);
	 }
	 
}
