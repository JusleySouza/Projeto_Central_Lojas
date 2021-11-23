package central.lojas.testes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import central.lojas.banco.Profissionais;
import central.lojas.dto.Funcionario;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TesteFuncionarios {

	private static Profissionais profissionais = new Profissionais();
	
	 @Order(1)
	 @Test
	    public void testCadastroFuncionario() {
	    	int retornoEsperado=1;
	        int retornoConsulta = profissionais.cadastrar("Andrea Freitas","6359-4512", "3256-7845", "151.515.151-51",
			"15.151.515-1", "andreafreitas@gmail.com", "Maria Rocha", 64 , "Pompéia",
			"Rio Grande do Sul", "F", "gerente");
	        
	        assertEquals(retornoEsperado,retornoConsulta);

	    }
	 
	 @Order(2)
	 @Test
	    public void testConsultaFuncionario() {
		 	Funcionario funcionarioEsperado = new Funcionario();
	        Funcionario funcionarioConsultado = profissionais.consulta("Andrea Freitas");

	        funcionarioEsperado.setNome("Andrea Freitas");
			funcionarioEsperado.setTelefone("6359-4512");
			funcionarioEsperado.setTelefoneSecundario("3256-7845");
			funcionarioEsperado.setCpf("151.515.151-51");
			funcionarioEsperado.setRg("15.151.515-1");
			funcionarioEsperado.setEmail("andreafreitas@gmail.com");
			funcionarioEsperado.setRua("Maria Rocha");
			funcionarioEsperado.setNumero(64);
			funcionarioEsperado.setBairro("Pompéia");
			funcionarioEsperado.setCidade("Rio Grande do Sul");
			funcionarioEsperado.setSexo("F");
			funcionarioEsperado.setCargo("gerente");
			
	        assertEquals(funcionarioConsultado.toString(), funcionarioEsperado.toString());

	    }
	 
	 @Order(3)
	 @Test
	 public void testAtualizaFuncionario() {
		 	Funcionario funcionarioEsperado = new Funcionario();

	        funcionarioEsperado.setNome("Andrea Freitas");
			funcionarioEsperado.setTelefone("6359-4512");
			funcionarioEsperado.setTelefoneSecundario("3256-7845");
			funcionarioEsperado.setCpf("151.515.151-51");
			funcionarioEsperado.setRg("15.151.515-1");
			funcionarioEsperado.setEmail("andreafreitas@gmail.com");
			funcionarioEsperado.setRua("Maria Rocha");
			funcionarioEsperado.setNumero(81);
			funcionarioEsperado.setBairro("Pompéia");
			funcionarioEsperado.setCidade("Rio Grande do Sul");
			funcionarioEsperado.setSexo("F");
			funcionarioEsperado.setCargo("gerente");
			
			profissionais.atualizar(funcionarioEsperado);
			Funcionario funcionarioAtualizado = profissionais.consulta(funcionarioEsperado.getNome());
	        
	        assertEquals(funcionarioAtualizado.toString(), funcionarioEsperado.toString());

	    }
	 
	 @Order(4)
	 @Test
	 public void testExcluirFuncionario() {
		 	Funcionario funcionarioEsperado = new Funcionario();
	        profissionais.excluir("Andrea Freitas");
	        
	    	Funcionario funcionarioExcluido = profissionais.consulta(funcionarioEsperado.getNome());
	     
	        assertEquals(funcionarioExcluido.getCpf(), null);
	 }
}
