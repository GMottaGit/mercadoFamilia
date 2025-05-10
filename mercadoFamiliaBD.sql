create database senac_db;
use senac_db;
create table produto(
id int not null auto_increment primary key,
nome varchar(200),
preco double,
estoque int
);
create table funcionario(
id int not null auto_increment primary key,
nome varchar(200),
cargo varchar(200),
email varchar(200)
);

select * from produto;
select * from funcionario;
