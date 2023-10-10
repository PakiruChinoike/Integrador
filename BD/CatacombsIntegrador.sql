CREATE DATABASE CatacombsIntegrador;
USE CatacombsIntegrador;

CREATE TABLE personagem(
id_personagem BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
nome VARCHAR(30) NOT NULL,
classe SMALLINT NOT NULL,
agilidade SMALLINT NOT NULL,
forca SMALLINT NOT NULL,
inteligencia SMALLINT NOT NULL,
vida SMALLINT NOT NULL,
armadura SMALLINT NOT NULL,
poder SMALLINT NOT NULL,
nivel SMALLINT NOT NULL,
experiencia INT NOT NULL,
id_party BIGINT NOT NULL,
id_personagem_habilidade BIGINT UNIQUE NOT NULL,
id_personagem_item BIGINT NOT NULL UNIQUE,
PRIMARY KEY (id_personagem),
FOREIGN KEY(id_party) REFERENCES party(id_party),
FOREIGN KEY(id_personagem_habilidade) REFERENCES personagem_habilidade(id_personagem_habilidade),
FOREIGN KEY (id_personagem_item) REFERENCES personagem_item(id_personagem_item)
);

CREATE TABLE party(
id_party BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
id_personagem BIGINT UNIQUE NOT NULL,
PRIMARY KEY(id_party),
FOREIGN KEY(id_personagem) REFERENCES personagem(id_personagem)
);

CREATE TABLE habilidade(
id_habilidade BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
nome VARCHAR(30) NOT NULL,
tipo TINYINT NOT NULL,
descricao VARCHAR(100) NOT NULL,
max_roll SMALLINT NOT NULL,
min_roll SMALLINT NOT NULL,
min_test SMALLINT NOT NULL,
tipo_dano SMALLINT NOT NULL,
atributo SMALLINT NOT NULL,
PRIMARY KEY(id_habilidade)
);

CREATE TABLE personagem_habilidade(
id_personagem_habilidade BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
id_personagem BIGINT UNIQUE NOT NULL,
id_habilidade BIGINT NOT NULL UNIQUE,
PRIMARY KEY (id_personagem_habilidade),
FOREIGN KEY (id_personagem) REFERENCES personagem(id_personagem),
FOREIGN KEY (id_habilidade) REFERENCES habilidade(id_habilidade)
);

CREATE TABLE item(
id_item BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
nome VARCHAR(30) NOT NULL,
raridade VARCHAR(30) NOT NULL,
id_habilidade BIGINT NOT NULL,
PRIMARY KEY(id_item),
FOREIGN KEY (id_habilidade) REFERENCES habilidade(id_habilidade)
);

CREATE TABLE personagem_item(
id_personagem_item BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
id_personagem BIGINT UNIQUE NOT NULL,
id_item BIGINT UNIQUE NOT NULL,
PRIMARY KEY(id_personagem_item),
FOREIGN KEY(id_personagem) REFERENCES personagem(id_personagem),
FOREIGN KEY (id_item) REFERENCES item(id_item)
);
 
CREATE TABLE sala(
id_sala BIGINT NOT NULL UNIQUE AUTO_INCREMENT, 
nome VARCHAR(30) NOT NULL,
tipo TINYINT NOT NULL,
PRIMARY KEY(id_sala)
);

CREATE TABLE chefe(
id_chefe BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
id_monstro BIGINT NOT NULL UNIQUE,
PRIMARY KEY(id_chefe),
FOREIGN KEY(id_monstro) REFERENCES monstro(id_monstro)
);

CREATE TABLE fase(
id_fase BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
nome VARCHAR(30) NOT NULL,
num_sala VARCHAR(30) NOT NULL,
id_sala BIGINT UNIQUE NOT NULL,
id_chefe BIGINT UNIQUE NOT NULL,
id_party BIGINT NOT NULL,
PRIMARY KEY(id_fase),
FOREIGN KEY(id_sala) REFERENCES sala(id_sala),
FOREIGN KEY(id_chefe) REFERENCES mostro(id_chefe),
FOREIGN KEY(id_party) REFERENCES party(id_party) 
);

CREATE TABLE monstro(
id_monstro BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
nome VARCHAR(30) NOT NULL,
dificuldade SMALLINT NOT NULL,
agilidade SMALLINT NOT NULL,
forca SMALLINT NOT NULL,
inteligencia SMALLINT NOT NULL,
vida SMALLINT NOT NULL,
armadura SMALLINT NOT NULL,
fraquezas SMALLINT NOT NULL,
id_monstro_habilidade BIGINT NOT NULL,
PRIMARY KEY(id_monstro),
FOREIGN KEY(id_monstro_habilidade)REFERENCES monstro_habilidade(id_monstro_habilidade)
);

CREATE TABLE monstro_habilidade(
id_monstro_habilidade BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
id_monstro BIGINT NOT NULL,
id_habilidade BIGINT NOT NULL,
PRIMARY KEY(id_monstro_habilidade),
FOREIGN KEY(id_monstro) REFERENCES monstro(id_monstro),
FOREIGN KEY(id_habilidade) REFERENCES habilidade(id_habilidade)
);