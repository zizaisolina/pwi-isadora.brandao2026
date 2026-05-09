create database locadoraAmbev;
use locadoraAmbev;

create table cliente
(
id_cliente varchar (50) primary key,
        nome        varchar(100),
        endereco    varchar(150),
        telefone    varchar(20),
        email       varchar(100),
        cpf_cnpj    varchar(100)
);

create table equipamento
(
id_equipamento varchar (50) primary key,
        tipo        varchar(100),
        modelo    varchar(150),
        localização    varchar(20),
        status         varchar(100)
);

create table manutenção
(
id_manutenção varchar (50) primary key,
        tipo        varchar(100),
        data    varchar(150),
        custo    varchar(20),
        descrição   varchar(100),
        id_equipamento varchar(100)
);

create table pedido
(
id_pedido varchar (50) primary key,
       data_pedido  varchar(100),
       valor_total  varchar(100),
       status       varchar(100),
       id_cliente varchar(100)
);

create table veículo
(
id_veiculo varchar (50) primary key



