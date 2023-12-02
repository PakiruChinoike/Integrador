USE CatacombsIntegrador;

/*INSERE NO BANCO AS HABILIDADES DA CLASSE LADINO*/
INSERT INTO habilidade VALUES(1, "Facada", 2, "Um golpe que rasga a carne do alvo", 6, 3, null, 3, 0, 0);
INSERT INTO habilidade VALUES(2, "Ataque Furtivo", 0, "Um golpe furtivo e poderoso", 12, 1, null, 3, 0, 3);
INSERT INTO habilidade VALUES(3, "Bomba das Sombras", 1, "Uma granada que congela os alvos", 8, 8, 8, 1, 2, 4);



/*INSERE NO BANCO AS HABILIDADES DA CLASSE GUERREIRO*/
INSERT INTO habilidade VALUES(5, "Golpeada", 0, "Um ataque de cima para baixo", 6, 1, null, 3, 1, 0);
INSERT INTO habilidade VALUES(6, "Trovão", 0, "Um ataque abrangente elétrico", 6, 1, null, 2, 1, 3);
INSERT INTO habilidade VALUES(7, "Recuperar Fôlego", 2, "Uma respiração funda que o faz recuperar vida", 8, 2, null, null, 1, 4);



/*INSERE NO BANCO AS HABILIDADES DA CLASSE MAGO*/
INSERT INTO habilidade VALUES(9, "Rajada Mística", 2, "Um raio de pura energia arcana contra um alvo", 4, 3, null, 4, 2, 0);
INSERT INTO habilidade VALUES(10, "Bola de Fogo", 1, "Uma bola de puras chamas destrutivas", 12, 6, 10, 0, 0, 6);
INSERT INTO habilidade VALUES(11, "Revigoração Divina", 2, "Uma benção que cura a vida de um aliado", 6, 2, null, null, 2, 3);



/*INSERE NO BANCO OS MONSTROS DA SALA 1*/
INSERT INTO monstro VALUES(1, "Hidra Esquelética", 10, 12, 3, 0, 0);
INSERT INTO atributos VALUES(null, 4, 1, 1, null, 1);
INSERT INTO fraquezas VALUES(null, 0, 0, 1, 1, 0, null, 1);
INSERT INTO habilidade VALUES(101, "Chibatada", 0, "um corte com a cauda da hidra", 8, 3, null, 3, 0, null); 
INSERT INTO habilidade VALUES(102, "Mordida", 1, "uma mordida de arrancar braços", 12, 6, 12, 1, 1, null);
INSERT INTO habilidade VALUES(103, "Regenerar-se", 2, "A hidra recupera uma de suas cabeças", 10, 10, null, null, 2, null);
INSERT INTO monstro_habilidade VALUES(null, 1, 101);
INSERT INTO monstro_habilidade VALUES(null, 1, 102);
INSERT INTO monstro_habilidade VALUES(null, 1, 103);


INSERT INTO monstro VALUES(2, "Elemental de Rocha", 20, 9, 3, 0, 0);
INSERT INTO atributos VALUES(null, 1, 5, 0, null, 2);
INSERT INTO fraquezas VALUES(null, 0, 1, 0, 0, 1, null, 2);
INSERT INTO habilidade VALUES(201, "Punho Sísmico", 0, "um soco potente", 10, 10, null, 3, 0, null);
INSERT INTO habilidade VALUE(202, "Terremoto", 1, "um tremor de terra que afeta todos na área", 8, 1, 12, 0, 0, null);
INSERT INTO monstro_habilidade VALUES(null, 2, 201);
INSERT INTO monstro_habilidade VALUES(null, 2, 202);



/*INSERE NO BANCO OS ITENS DE RECOMPENSAS*/
INSERT INTO habilidade VALUES(1111, "Poção de Cura Instantânea", 2, "uma poção que restaura completamente a vida de quem a bebe", 100, 100, null, null, null, 0);
INSERT INTO item VALUES(111, "Poção de Cura Instantânea", 3, 1, 1111);
INSERT INTO habilidade VALUES(1112, "Bomba do Caos", 2, "uma bomba que destrói tudo em seu caminho", 100, 100, null, 4, null, 0);
INSERT INTO item VALUES(112, "Bomba do Caos", 3, 1, 1112);

/*INSERE NO BANCO AS HABILIDADES DE RECOMPENSAS*/
INSERT INTO habilidade VALUES(111, "Ventos do Norte", 2, "fortes ventanias que curam os aliados e derrubam os inimigos", 20, 5, null, 2, null, 6);
INSERT INTO habilidade VALUES(112, "Quebra-Nozes", 0, "uma pancada capaz de matar um alvo intantaneamente", 50, 0, null, 3, 1, 10);

/*INSERE NO BANCO AS RECOMPENSAS*/
INSERT INTO recompensa VALUES(1, 3, 1000, 3, 111, 111);
INSERT INTO recompensa VALUES(2, 3, 1000, 3, 112, 112);
