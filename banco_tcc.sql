create database db_sistema_web;
use db_sistema_web;

create table tb_usuario (
id_usuario int primary key auto_increment,
nome_usuario varchar(60) not null,
email_usuario varchar(100) not null,
senha_usuario varchar(100) not null,
role_usuario varchar(30) not null
);

create table tb_cliente (
id_cliente int primary key auto_increment,
nome_cliente varchar(60) not null,
email_cliente varchar(100) not null
);

create table tb_encomenda (
id_encomenda int primary key auto_increment,
codigo_rastreio_encomenda varchar(50) not null,
destinatario_encomenda varchar(100) not null,
endereco_atual_encomenda varchar(100) not null,
status_encomenda varchar(50) not null,
id_cliente int not null,
id_usuario int not null,
foreign key (id_cliente) references tb_cliente (id_cliente),
foreign key (id_usuario) references tb_usuario (id_usuario)
);

create table tb_entrega (
id_entrega int primary key auto_increment,
data_entrega datetime not null,
codigo_otp_entrega varchar(60) not null,
id_encomenda int not null,
id_usuario int not null,
foreign key (id_encomenda) references tb_encomenda (id_encomenda),
foreign key (id_usuario) references tb_usuario (id_usuario)
);