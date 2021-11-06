CREATE DATABASE loja;

USE loja;

CREATE TABLE clientes(
	nome varchar(150) not null,
    telefone varchar(20) not null,
    telefone_secundario varchar(20) default'',
    cpf varchar(15) not null,
    rg varchar(15) not null,
    email varchar(50),
    rua varchar(100) not null,
    numero int unsigned not null,
    bairro varchar(50) not null,
    cidade varchar(50) not null,
    sexo char(1),
    PRIMARY KEY (cpf)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE profissionais(
	nome varchar(150) not null,
    cpf varchar(15) not null,
	rg varchar(20) not null,
    telefone varchar(20) not null,
    telefone_secundario_profissional varchar(20) default'',
    email varchar(50) not null,
    rua varchar(100) not null,
    numero int unsigned not null,
    bairro varchar(50) not null,
    cidade varchar(50) not null,
    cargo varchar(25) not null,
    sexo char(1),
    PRIMARY KEY (cpf)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE mercadorias(
	id int not null auto_increment,
    nome varchar(50) not null,
    lote varchar(20) not null,
    quantidade_disponivel int unsigned not null,
    preco double unsigned not null,
    tamanho varchar(5) not null,
    PRIMARY KEY (id)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE usuarios(
	id_usuario int not null auto_increment,
    funcionario_login varchar(15) not null,
    login varchar(20) not null,
    senha varchar(15) not null,
    primary key(id_usuario),
    CONSTRAINT id_funcionario FOREIGN KEY (funcionario_login) REFERENCES profissionais (cpf)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE venda_final(
	id_venda_final int not null auto_increment,
    profissional_id varchar(15) not null,
    cliente_id varchar(15),
    data_compra datetime,
    forma_pagamento varchar(10),
    total_venda double unsigned,
    PRIMARY KEY (id_venda_final),
	CONSTRAINT id_profissional FOREIGN KEY (profissional_id) REFERENCES profissionais (cpf),
	CONSTRAINT id_cliente FOREIGN KEY (cliente_id) REFERENCES clientes (cpf)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE venda_unitaria(
	id_venda_unitaria int not null auto_increment,
    venda_id int not null,
    mercadoria_id int not null,
    quantidade int unsigned not null,
    total_pedido double unsigned,
    PRIMARY KEY (id_venda_unitaria),
	CONSTRAINT id_venda FOREIGN KEY (venda_id) REFERENCES venda_final (id_venda_final),
	CONSTRAINT id_mercadoria FOREIGN KEY (mercadoria_id) REFERENCES mercadorias (id)
) 
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;