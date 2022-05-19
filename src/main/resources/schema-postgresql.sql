CREATE TABLE IF NOT EXISTS bebidas(
	id serial primary key,
	nome varchar(50),
	descriçao varchar(300),
	preço money,
	categoria varchar(50),
	tamanho varchar(10)
);

CREATE TABLE IF NOT EXISTS comidas(
	id serial primary key,
	nome varchar(50),
	descriçao varchar(300),
	preço money,
	categoria varchar(50)
);

CREATE TABLE IF NOT EXISTS cafes(
	id serial primary key,
	nome varchar(50),
	descriçao varchar(300),
	fornecedor varchar(50),
	preço money,
	gramas int
);