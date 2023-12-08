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
INSERT INTO equipe VALUES(1, null, null, null);

INSERT INTO monstro VALUES(1, "Hidra Esquelética", 10, 5, 3, 0, 1);
INSERT INTO atributos VALUES(null, 4, 1, 1, null, 1);
INSERT INTO fraquezas VALUES(null, 0, 0, 1, 1, 0, null, 1);
INSERT INTO habilidade VALUES(101, "Chibatada", 0, "um corte com a cauda da hidra", 8, 3, null, 3, 0, null); 
INSERT INTO habilidade VALUES(102, "Mordida", 1, "uma mordida de arrancar braços", 12, 6, 8, 1, 1, null);
INSERT INTO monstro_habilidade VALUES(null, 1, 101);
INSERT INTO monstro_habilidade VALUES(null, 1, 102);



INSERT INTO monstro VALUES(2, "Elemental de Rocha", 20, 3, 3, 0, 1);
INSERT INTO atributos VALUES(null, 1, 5, 0, null, 2);
INSERT INTO fraquezas VALUES(null, 0, 1, 0, 0, 1, null, 2);
INSERT INTO habilidade VALUES(201, "Punho Sísmico", 0, "um soco potente", 10, 10, null, 3, 0, null);
INSERT INTO habilidade VALUES(202, "Terremoto", 1, "um tremor de terra que afeta todos na área", 8, 1, 8, 0, 0, null);
INSERT INTO monstro_habilidade VALUES(null, 2, 201);
INSERT INTO monstro_habilidade VALUES(null, 2, 202);



/*INSERE NO BANCO OS MONSTROS DA SALA 2*/
INSERT INTO equipe VALUES(2, null, null, null);

INSERT INTO monstro VALUES(3, "Esqueleto", 10, 6, 2, 0, 2);
INSERT INTO atributos VALUES(null, 2, 2, 2, null, 3);
INSERT INTO fraquezas VALUES(null, 0, 0, 0, 0, 0, null, 3);
INSERT INTO habilidade VALUES(301, "Espadada", 0, "um corte com uma lâmina enferrujada", 8, 1, null, 3, 1, null);
INSERT INTO monstro_habilidade VALUES(null, 3, 301);


INSERT INTO monstro VALUES(4, "Vampiro", 30, 8, 5, 0, 2);
INSERT INTO atributos VALUES(null, 3, 3, 4, null, 4);
INSERT INTO fraquezas VALUES(null, 1, 0, 0, 0, 1, null, 4);
INSERT INTO habilidade VALUES(401, "Sucção de Vitalidade", 1, "uma mordida que suga a energia vital do alvo", 12, 4, 8, 4, 2, null);
INSERT INTO habilidade VALUES(402, "Garras Vampíricas", 0, "um corte com as garras venenosas do vampiro", 8, 6, null, 1, 0, null);
INSERT INTO monstro_habilidade VALUES(null, 4, 401);
INSERT INTO monstro_habilidade VALUES(null, 4, 402);



/*INSERE NO BANCO OS MONSTROS DA SALA 3*/
INSERT INTO equipe VALUES(3, null, null, null);

INSERT INTO monstro VALUES(5, "O Rei Lich", 50, 8, 5, 0, 3);
INSERT INTO atributos VALUES(null, 5, 5, 5, null, 5);
INSERT INTO fraquezas VALUES(null, 0, 0, 0, 0, 0, null, 5);
INSERT INTO habilidade VALUES(501, "Dreno Enérgico", 1, "uma sucção poderosa de energia", 20, 1, 8, 4, 2, null);
INSERT INTO habilidade VALUES(502, "Corte Necrótico", 0, "uma lâmina de pura matéria necrótica", 8, 8, null, 1, 2, null);
INSERT INTO habilidade VALUES(503, "Caveiras Flamejantes", 2, "uma explosão de chamas no formato de uma caveira", 10, 2, null, 0, null, null);
INSERT INTO habilidade VALUES(504, "Flechas Eônicas", 2, "diversas flechas de energia entrópica", 10, 0, null, 2, null, null);
INSERT INTO monstro_habilidade VALUES(null, 5, 501);
INSERT INTO monstro_habilidade VALUES(null, 5, 502);
INSERT INTO monstro_habilidade VALUES(null, 5, 503); 
INSERT INTO monstro_habilidade VALUES(null, 5, 504);



/*INSERE NO BANCO OS ITENS DE RECOMPENSAS*/
INSERT INTO habilidade VALUES(1111, "Poção de Cura Instantânea", 2, "uma poção que restaura completamente a vida de quem a bebe", 100, 100, null, null, null, 0);
INSERT INTO item VALUES(111, "Poção de Cura Instantânea", 1, 1111);
INSERT INTO habilidade VALUES(1112, "Bomba do Caos", 2, "uma bomba que destrói tudo em seu caminho", 100, 100, null, 4, null, 0);
INSERT INTO item VALUES(112, "Bomba do Caos", 1, 1112);



/*INSERE NO BANCO AS HABILIDADES DE RECOMPENSAS*/
INSERT INTO habilidade VALUES(111, "Ventos do Norte", 2, "fortes ventanias que curam os aliados e derrubam os inimigos", 20, 5, null, 2, null, 6);
INSERT INTO habilidade VALUES(112, "Quebra-Nozes", 0, "uma pancada capaz de matar um alvo intantaneamente", 50, 0, null, 3, 1, 10);



/*INSERE NO BANCO AS RECOMPENSAS*/
INSERT INTO recompensa VALUES(1, 3, 1000, 111, 111);
INSERT INTO recompensa VALUES(2, 3, 1000, 112, 112);
INSERT INTO recompensa VALUES(3, 3, 2000, null, null);



/*INSERE NO BANCO AS SALAS*/
INSERT INTO sala VALUES(1, "Portões de Aceitação", "Um enorme portão postava-se diante de vocês. Eles necessitavam de um sacrifício na forma de terror e desespero", 1);
INSERT INTO sala VALUES(2, "Corredores do Desespero", "Corredores labirínticos cresciam como veias pelo sistema das catacumbas, recheados por esqueletos e um sedento vampiro", 2);
INSERT INTO sala VALUES(3, "Santuário do Filactério", "Finalmente... adiante, estava parado diante de seu filactério um lich: o rei destas Catacumbas. %n -Vocês estão atrasados. %n -O fim está próximo.", 3);

INSERT INTO monstro_sala VALUES(null, 1, 1);
INSERT INTO monstro_sala VALUES(null, 2, 1);

INSERT INTO monstro_sala VALUES(null, 3, 2);
INSERT INTO monstro_sala VALUES(null, 3, 2);
INSERT INTO monstro_sala VALUES(null, 4, 2);

INSERT INTO monstro_sala VALUES(null, 5, 3);



/*INSERE NO BANCO AS FASES*/
INSERT INTO fase VALUES(1, "Catacumbas do Lich", 3, null);
INSERT INTO sala_fase VALUES(null, 1, 1);
INSERT INTO sala_fase VALUES(null, 2, 1);
INSERT INTO sala_fase VALUES(null, 3, 1);