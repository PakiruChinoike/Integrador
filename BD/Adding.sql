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
