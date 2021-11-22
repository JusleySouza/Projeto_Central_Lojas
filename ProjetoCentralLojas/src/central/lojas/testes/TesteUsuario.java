package central.lojas.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import central.lojas.banco.Usuarios;
import central.lojas.dto.Usuario;

public class TesteUsuario{

	Usuarios usuarios = new Usuarios();
	Usuario usuarioEsperado;
	Usuario usuarioResultado;
	
	public static Usuario criarUsuario(String cargo, int id) {
		Usuario usuario = new Usuario();
		usuario.setId_usuario(id);
		usuario.setCargo(cargo);
		usuario.setLogin("admin");
		usuario.setSenha("admin");
		
		return usuario;
	}
	
	@Test
	public void testeConsultarUsuarioAdmin() {
		usuarioEsperado = new Usuario();
		usuarioResultado = new Usuario();
		usuarioEsperado =  criarUsuario("gerente", 1);
		String login = "admin";
		
		usuarioResultado = usuarios.consulta(login);
		assertEquals(usuarioEsperado, usuarioResultado);
	}
}
