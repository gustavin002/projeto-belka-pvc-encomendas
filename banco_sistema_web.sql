create database db_sistema_web;
use db_sistema_web;

create table tb_admin (
id_admin integer primary key auto_increment,
email_admin varchar(100) unique not null,
senha_admin varchar(100) not null
);

create table tb_usuario (
id_usuario integer primary key auto_increment,
nome_usuario varchar(60) not null,
email_usuario varchar(100) unique not null,
senha_usuario varchar(100) not null,
role_usuario enum('operador logistico', 'entregador') not null,
disponibilidade_usuario enum('disponível', 'indisponível') not null
);

create table tb_cliente (
  id_cliente integer primary key auto_increment,
  nome_cliente varchar(60) not null,
  email_cliente varchar(100) unique not null,
  endereco_cliente varchar(120) not null
);

create table tb_encomenda (
id_encomenda integer primary key auto_increment,
codigo_rastreio_encomenda varchar(20) unique not null,
endereco_atual_encomenda varchar(120) not null,
status_encomenda enum('em separacao', 'em transporte', 'em rota de entrega', 'entregue') not null,
id_cliente int not null,
id_usuario int not null,
foreign key (id_cliente) references tb_cliente (id_cliente),
foreign key (id_usuario) references tb_usuario (id_usuario)
);

create table tb_entrega (
id_entrega integer primary key auto_increment,
data_hora_entrega datetime not null,
codigo_otp_entrega varchar(20) not null,
id_encomenda int not null,
id_usuario int not null,
foreign key (id_encomenda) references tb_encomenda (id_encomenda),
foreign key (id_usuario) references tb_usuario (id_usuario)
);

insert into tb_admin (email_admin, senha_admin) values 
('admin@gmail.com', 'admin123');