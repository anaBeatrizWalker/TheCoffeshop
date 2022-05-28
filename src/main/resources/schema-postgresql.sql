CREATE TABLE IF NOT EXISTS bebidas(
	id serial primary key,
	nome varchar(100),
	descricao varchar(300),
	preco varchar(5),
	categoria varchar(100),
	tamanho varchar(20)
);

CREATE TABLE IF NOT EXISTS comidas(
	id serial primary key,
	nome varchar(100),
	descricao varchar(300),
	preco varchar(5),
	categoria varchar(100)
);

CREATE TABLE IF NOT EXISTS cafes(
	id serial primary key,
	nome varchar(100),
	descricao varchar(300),
	fornecedor varchar(100),
	preco varchar(5),
	gramas varchar(7)
);