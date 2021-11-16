package central.lojas.banco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import central.lojas.dto.Usuario;

public class Usuarios {
	Connection conect;
	Statement sentenca;
	ResultSet procura;
	
	public Usuarios() {
		conect = conexao.conectaBD();
	}
	
	public Usuario consulta(String login) {
		Usuario usuario =  new Usuario();
		
		try {
			sentenca = conect.createStatement();
			procura = sentenca.executeQuery("select * from usuarios where login='"+login+"' LIMIT 1");
			
			if(procura.next()) {
				usuario.setId_usuario(procura.getInt("id_usuario"));
				usuario.setCargo(procura.getString("cargo"));
				usuario.setLogin(procura.getString("login"));
				usuario.setSenha(procura.getString("senha"));
			}
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(null,ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
		}
		
		return usuario;
	}
}
