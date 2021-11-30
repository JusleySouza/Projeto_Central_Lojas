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
	        int retornoConsulta = profissionais.cadastrar("Jorge Mariano da Silva","6359-6231", "3256-7461", "444.444.444-44",
			"44.444.444-4", "jorgesilva@gmail.com", "Maria Bento", 804 , "São Benedito",
			"Limeira", "M", "gerente");
	        
	        assertEquals(retornoEsperado,retornoConsulta);

	    }
	 
	 @Order(2)
	 @Test
	    public void testConsultaFuncionario() {
		 	Funcionario funcionarioEsperado = new Funcionario();
	        Funcionario funcionarioConsultado = profissionais.consulta("Jorge Mariano da Silva");

	        funcionarioEsperado.setNome("Jorge Mariano da Silva");
			funcionarioEsperado.setTelefone("6359-6231");
			funcionarioEsperado.setTelefoneSecundario("3256-7461");
			funcionarioEsperado.setCpf("444.444.444-44");
			funcionarioEsperado.setRg("44.444.444-4");
			funcionarioEsperado.setEmail("jorgesilva@gmail.com");
			funcionarioEsperado.setRua("Maria Bento");
			funcionarioEsperado.setNumero(804);
			funcionarioEsperado.setBairro("São Benedito");
			funcionarioEsperado.setCidade("Limeira");
			funcionarioEsperado.setSexo("M");
			funcionarioEsperado.setCargo("gerente");
			
	        assertEquals(funcionarioConsultado.toString(), funcionarioEsperado.toString());

	    }
	 
	 @Order(3)
	 @Test
	 public void testAtualizaFuncionario() {
		 	Funcionario funcionarioEsperado = new Funcionario();


	        funcionarioEsperado.setNome("Jorge Mariano da Silva");
			funcionarioEsperado.setTelefone("6359-6231");
			funcionarioEsperado.setTelefoneSecundario("3256-7461");
			funcionarioEsperado.setCpf("444.444.444-44");
			funcionarioEsperado.setRg("44.444.444-4");
			funcionarioEsperado.setEmail("jorgesilva@gmail.com");
			funcionarioEsperado.setRua("Maria Bento");
			funcionarioEsperado.setNumero(804);
			funcionarioEsperado.setBairro("São Benedito");
			funcionarioEsperado.setCidade("Limeira");
			funcionarioEsperado.setSexo("M");
			funcionarioEsperado.setCargo("gerente");
			
			profissionais.atualizar(funcionarioEsperado);
			Funcionario funcionarioAtualizado = profissionais.consulta(funcionarioEsperado.getNome());
	        
	        assertEquals(funcionarioAtualizado.toString(), funcionarioEsperado.toString());

	    }
	 
	 @Order(4)
	 @Test
	 public void testExcluirFuncionario() {
		 	Funcionario funcionarioEsperado = new Funcionario();
	        profissionais.excluir("Jorge Mariano da Silva");
	        
	    	Funcionario funcionarioExcluido = profissionais.consulta(funcionarioEsperado.getNome());
	     
	        assertEquals(funcionarioExcluido.getCpf(), null);
	 }
}
