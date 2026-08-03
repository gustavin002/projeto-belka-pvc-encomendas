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
id_operador_logistico int not null,
foreign key (id_cliente) references tb_cliente (id_cliente),
foreign key (id_operador_logistico) references tb_usuario (id_usuario)
);

create table tb_entrega (
id_entrega integer primary key auto_increment,
data_hora_entrega datetime not null,
codigo_otp_entrega varchar(20) not null,
id_encomenda int not null,
id_entregador int not null,
foreign key (id_encomenda) references tb_encomenda (id_encomenda),
foreign key (id_entregador) references tb_usuario (id_usuario)
);

insert into tb_admin (email_admin, senha_admin) values
('admin@gmail.com', 'admin1010');

insert into tb_usuario (nome_usuario, email_usuario, senha_usuario, role_usuario, disponibilidade_usuario) values
('Gustavo', 'operador1@gmail.com', 'operador1010', 'operador logistico', 'disponível'),
('João', 'operador2@gmail.com', 'operador1020', 'operador logistico', 'disponível'),
('Gabriel', 'operador3@gmail.com', 'operador1030', 'operador logistico', 'disponível'),
('Matheus', 'operador4@gmail.com', 'operador1040', 'operador logistico', 'disponível'),
('Luiz', 'operador5@gmail.com', 'operador1050', 'operador logistico', 'disponível'),

('André', 'entregador1@gmail.com', 'entregador1010', 'entregador', 'disponível'),
('Estevão', 'entregador2@gmail.com', 'entregador1020', 'entregador', 'disponível'),
('Pedro', 'entregador3@gmail.com', 'entregador1030', 'entregador', 'disponível'),
('Ananias', 'entregador4@gmail.com', 'entregador1040', 'entregador', 'indisponível'),
('José', 'entregador5@gmail.com', 'entregador1050', 'entregador', 'indisponível');

insert into tb_cliente (nome_cliente, email_cliente, endereco_cliente) values
('Kaue', 'kaue@email.com', 'Rua das Flores, 123'),
('Fabio', 'fabio@email.com', 'Av. Brasil, 456'),
('Fernando', 'fernando@email.com', 'Rua XV de Novembro'),
('lincoln', 'lincoln@email.com', 'Rua Paraná, 852'),
('Beatrice', 'beatrice@email.com', 'Av. Tiradentes, 1024');

insert into tb_encomenda (codigo_rastreio_encomenda, endereco_atual_encomenda, status_encomenda, id_cliente, id_operador_logistico) values
('67674', 'Galpão Principal - Setor A', 'em separacao', 1, 1),
('77778', 'Galpão Principal - Setor B', 'em transporte', 1, 1),
('33317', 'Galpão Secundário - Setor C', 'em rota de entrega', 2, 2),
('99881', 'Galpão Principal - Setor A', 'entregue', 2, 2),
('35783', 'Galpão Principal - Setor B', 'em separacao', 3, 3),
('25386', 'Galpão Secundário - Setor A', 'em transporte', 3, 3),
('23729', 'Galpão Principal - Setor C', 'em rota de entrega', 4, 4),
('12895', 'Galpão Secundário - Setor B', 'entregue', 4, 4),
('38942', 'Galpão Principal - Setor A', 'em separacao', 5, 5),
('84743', 'Galpão Principal - Setor B', 'em transporte', 5, 5);