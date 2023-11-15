USE CatacombsIntegrador;

INSERT INTO monstro VALUES(null, 'Jonas', 10, 13, 5);

INSERT INTO habilidade VALUES(null, 'Cabeçada', 0, 'Jonas dá uma cabeçada', 8, 1, null, 3, 1);

INSERT INTO monstro_habilidade VALUES(null, 1, 1);

INSERT INTO monstro VALUES(null, 'Búfalo', 15, 11, 5);

INSERT INTO monstro_habilidade VALUES(null, 2, 1);

SELECT * FROM monstro_habilidade WHERE id_habilidade=1;

SELECT * FROM monstro;

SELECT * FROM personagem;

SELECT * FROM atributos WHERE id_personagem=8;