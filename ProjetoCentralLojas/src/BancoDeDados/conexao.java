package BancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexao {
static Connection conexao = null;
	

	public static Connection conectaBD() {
		try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/loja","root","");
	    } catch (Exception e) {
	        System.out.println("N�o foi poss�vel conectar ao bd" + e.getMessage());
	    }
	    return conexao;
	}
}
