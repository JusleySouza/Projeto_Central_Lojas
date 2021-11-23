package central.lojas.testes;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import central.lojas.banco.Usuarios;
import central.lojas.dto.Usuario;

public class TesteUsuario{

    private static Usuarios usuarios = new Usuarios();

    @Test
    public void testConsultarUsuario() {
    	Usuario usuarioEsperado = new Usuario();
        Usuario usuarioConsultado = usuarios.consulta("admin");

        usuarioEsperado.setId_usuario(1);
        usuarioEsperado.setCargo("gerente");
        usuarioEsperado.setLogin("admin");
        usuarioEsperado.setSenha("admin");
        
        assertEquals(usuarioConsultado.toString(), usuarioEsperado.toString());
    }
    
    @Test
    public void testConsultarUsuario2() {
    	Usuario usuarioEsperado = new Usuario();
        Usuario usuarioConsultado = usuarios.consulta("vendas");

        usuarioEsperado.setId_usuario(2);
        usuarioEsperado.setCargo("vendedor");
        usuarioEsperado.setLogin("vendas");
        usuarioEsperado.setSenha("vendas");
        
        assertEquals(usuarioConsultado.toString(), usuarioEsperado.toString());
    }
}