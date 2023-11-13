CREATE DATABASE CatacombsIntegrador;
USE CatacombsIntegrador;

CREATE TABLE personagem(
    id_personagem BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
    nome VARCHAR(30) NOT NULL,
    classe TINYINT NOT NULL,
    vida TINYINT NOT NULL,
    armadura TINYINT NOT NULL,
    poder TINYINT NOT NULL,
    nivel TINYINT NOT NULL,
    experiencia SMALLINT NOT NULL,
    id_equipe BIGINT NOT NULL,
    PRIMARY KEY (id_personagem),
    FOREIGN KEY(id_equipe) REFERENCES equipe(id_equipe)
);

CREATE TABLE atributos(
    id_atributos BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
    agilidade TINYINT NOT NULL,
    forca TINYINT NOT NULL,
    inteligencia TINYINT NOT NULL,
    id_personagem BIGINT,
    id_monstro BIGINT,
    PRIMARY KEY(id_atributos),
    FOREIGN KEY(id_personagem) REFERENCES personagem(id_personagem),
    FOREIGN KEY(id_monstro) REFERENCES monstro(id_monstro)
);

CREATE TABLE fraquezas(
    id_fraquezas BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
    flamejante BIT NOT NULL,
    congelante BIT NOT NULL,
    eletrico BIT NOT NULL,
    fisico BIT NOT NULL,
    arcano BIT NOT NULL,
    id_personagem BIGINT,
    id_monstro BIGINT, 
    PRIMARY KEY(id_fraquezas),
    FOREIGN KEY(id_personagem) REFERENCES personagem(id_personagem),
    FOREIGN KEY(id_monstro) REFERENCES monstro(id_monstro)
)

CREATE TABLE equipe(
    id_equipe BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
    id_personagem BIGINT NOT NULL,
    id_personagem2 BIGINT NOT NULL,
    id_personagem3 BIGINT NOT NULL,
    PRIMARY KEY(id_equipe),
    FOREIGN KEY(id_personagem) REFERENCES personagem(id_personagem),
    FOREIGN KEY(id_personagem2) REFERENCES personagem(id_personagem),
    FOREIGN KEY(id_personagem3) REFERENCES personagem(id_personagem)
);

CREATE TABLE habilidade(
    id_habilidade BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
    nome VARCHAR(30) NOT NULL,
    tipo TINYINT NOT NULL,
    descricao VARCHAR(200) NOT NULL,
    max_roll TINYINT,
    min_roll TINYINT,
    min_teste TINYINT,
    tipo_dano TINYINT,
    atributo TINYINT,
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
    raridade TINYINT NOT NULL,
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
    dificuldade TINYINT NOT NULL,
    descricao VARCHAR(500) NOT NULL,
    id_recompensa BIGINT NOT NULL,
    PRIMARY KEY(id_sala),
    FOREIGN KEY(id_inimigo) REFERENCES monstro(id_monstro),
    FOREIGN KEY(id_recompensa) REFERENCES recompensa(id_recompensa)
);

CREATE TABLE fase(
    id_fase BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
    nome VARCHAR(30) NOT NULL,
    num_sala VARCHAR(30) NOT NULL,
    id_sala BIGINT UNIQUE NOT NULL,
    id_chefe BIGINT UNIQUE NOT NULL,
    id_equipe BIGINT NOT NULL,
    PRIMARY KEY(id_fase),
    FOREIGN KEY(id_sala) REFERENCES sala(id_sala),
    FOREIGN KEY(id_chefe) REFERENCES monstro(id_monstro),
    FOREIGN KEY(id_equipe) REFERENCES equipe(id_equipe) 
);

CREATE TABLE recompensa(
    id_recompensa BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
    tipo TINYINT NOT NULL,
    experiencia SMALLINT,
    raridade TINYINT NOT NULL,
    id_item BIGINT,
    id_habilidade BIGINT,
    PRIMARY KEY(id_recompensa),
    FOREIGN KEY(id_item) REFERENCES item(id_item),
    FOREIGN KEY(id_habilidade) REFERENCES habilidade(id_habilidade)
);

CREATE TABLE monstro(
    id_monstro BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
    nome VARCHAR(30) NOT NULL,
    dificuldade TINYINT NOT NULL,
    vida TINYINT NOT NULL,
    armadura TINYINT NOT NULL,
    PRIMARY KEY(id_monstro),
);

CREATE TABLE monstro_habilidade(
    id_monstro_habilidade BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
    id_monstro BIGINT NOT NULL,
    id_habilidade BIGINT NOT NULL,
    PRIMARY KEY(id_monstro_habilidade),
    FOREIGN KEY(id_monstro) REFERENCES monstro(id_monstro),
    FOREIGN KEY(id_habilidade) REFERENCES habilidade(id_habilidade)
);

CREATE TABLE monstro_sala(
    id_monstro_sala BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
    id_monstro BIGINT NOT NULL,
    id_sala BIGINT NOT NULL,
    PRIMARY KEY(id_monstro_habilidade),
    FOREIGN KEY(id_monstro) REFERENCES monstro(id_monstro),
    FOREIGN KEY(id_sala) REFERENCES sala(id_sala)
);
