package central.lojas.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class conexao {
static Connection conexao = null;
static PreparedStatement stm;
	
	public static Connection conectaBD() {
		try {
	    	Class.forName("com.mysql.cj.jdbc.Driver"); 	
	    	conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/loja","root","");
	    } catch (Exception e) {
	    	if(e.getMessage().equals("Unknown database 'loja'")) {
	    		criaBD();
	    	}
	    	else {
	    		System.out.println("Não foi possível conectar ao bd" + e.getMessage());
	    	}
	    }
		
		return conexao;
	}
	
	public static void criaBD() {
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");
			
			stm = conexao.prepareStatement("CREATE DATABASE loja");
			stm.execute();
			
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/loja","root","");
			
			stm = conexao.prepareStatement("CREATE TABLE clientes(\r\n"
					+ "nome varchar(150) not null,\r\n"
					+ "telefone varchar(20) not null,\r\n"
					+ "telefone_secundario varchar(20) default'',\r\n"
					+ "cpf varchar(15) not null,\r\n"
					+ "rg varchar(15) not null,\r\n"
					+ "email varchar(50),\r\n"
					+ "rua varchar(100) not null,\r\n"
					+ "numero int unsigned not null,\r\n"
					+ "bairro varchar(50) not null,\r\n"
					+ "cidade varchar(50) not null,\r\n"
					+ "sexo char(1),\r\n"
					+ "PRIMARY KEY (cpf)\r\n"
					+ ")\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
			stm.execute();
			
			stm = conexao.prepareStatement("CREATE TABLE profissionais(\r\n"
					+ "nome varchar(150) not null,\r\n"
					+ "cpf varchar(15) not null,\r\n"
					+ "rg varchar(20) not null,\r\n"
					+ "telefone varchar(20) not null,\r\n"
					+ "telefone_secundario_profissional varchar(20) default'',\r\n"
					+ "email varchar(50) not null,\r\n"
					+ "rua varchar(100) not null,\r\n"
					+ "numero int unsigned not null,\r\n"
					+ "bairro varchar(50) not null,\r\n"
					+ "cidade varchar(50) not null,\r\n"
					+ "cargo varchar(25) not null,\r\n"
					+ "sexo char(1),\r\n"
					+ "PRIMARY KEY (cpf)\r\n"
					+ ")\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "DEFAULT CHARACTER SET = utf8;\r\n"
					+ "");
			stm.execute();
			
			stm = conexao.prepareStatement("CREATE TABLE mercadorias(\r\n"
					+ "id int not null auto_increment,\r\n"
					+ "nome varchar(50) not null,\r\n"
					+ "lote varchar(20) not null,\r\n"
					+ "quantidade_disponivel int unsigned not null,\r\n"
					+ "preco double unsigned not null,\r\n"
					+ "tamanho varchar(5) not null,\r\n"
					+ "PRIMARY KEY (id)\r\n"
					+ ")\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
			stm.execute();
			
			stm = conexao.prepareStatement("CREATE TABLE usuarios(\r\n"
					+ "id_usuario int not null auto_increment,\r\n"
					+ "funcionario_login varchar(15) not null,\r\n"
					+ "login varchar(20) not null,\r\n"
					+ "senha varchar(15) not null,\r\n"
					+ "primary key(id_usuario),\r\n"
					+ "CONSTRAINT id_funcionario FOREIGN KEY (funcionario_login) REFERENCES profissionais (cpf)\r\n"
					+ ")\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
			stm.execute();
			
			stm = conexao.prepareStatement("CREATE TABLE venda_final(\r\n"
					+ "id_venda_final int not null auto_increment,\r\n"
					+ "profissional_id varchar(15) not null,\r\n"
					+ "cliente_id varchar(15),\r\n"
					+ "data_compra datetime,\r\n"
					+ "forma_pagamento varchar(10),\r\n"
					+ "total_venda double unsigned,\r\n"
					+ "PRIMARY KEY (id_venda_final),\r\n"
					+ "CONSTRAINT id_profissional FOREIGN KEY (profissional_id) REFERENCES profissionais (cpf),\r\n"
					+ "CONSTRAINT id_cliente FOREIGN KEY (cliente_id) REFERENCES clientes (cpf)\r\n"
					+ ")\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
			stm.execute();
			
			stm = conexao.prepareStatement("CREATE TABLE venda_unitaria(\r\n"
					+ "id_venda_unitaria int not null auto_increment,\r\n"
					+ "venda_id int not null,\r\n"
					+ "mercadoria_id int not null,\r\n"
					+ "quantidade int unsigned not null,\r\n"
					+ "total_pedido double unsigned,\r\n"
					+ "PRIMARY KEY (id_venda_unitaria),\r\n"
					+ "CONSTRAINT id_venda FOREIGN KEY (venda_id) REFERENCES venda_final (id_venda_final),\r\n"
					+ "CONSTRAINT id_mercadoria FOREIGN KEY (mercadoria_id) REFERENCES mercadorias (id)\r\n"
					+ ") \r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
			stm.execute();
			
			conexao.close();
			conectaBD();
		}
		catch (SQLException e) {	
			e.printStackTrace();
		}
	    		
	}
}
