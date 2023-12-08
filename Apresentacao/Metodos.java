import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;

public class Metodos {

    private static Scanner keyboardInt = new Scanner(System.in);
    private static Scanner keyboardString = new Scanner(System.in);

    private static EquipeDAO equipeDAO = new EquipeDAO();
    private static FaseDAO faseDAO = new FaseDAO();
    private static HabilidadeDAO habilidadeDAO = new HabilidadeDAO();
    private static ItemDAO itemDAO = new ItemDAO();
    private static MonstroDAO monstroDAO = new MonstroDAO();
    private static PersonagemDAO personagemDAO = new PersonagemDAO();
    private static RecompensaDAO recompensaDAO = new RecompensaDAO();
    private static SalaDAO salaDAO = new SalaDAO();

    public static List<Personagem> criarPersonagens(int n) {
        List<Personagem> listaPersonagens = new ArrayList<>();

        for (int i = 0; i<n; i++) {
            System.out.println("Decida o nome do Personagem:");
            String nome = keyboardString.nextLine();

            System.out.printf("Decida a classe do seu Personagem:%n1 - Ladino%n2 - Guerreiro%n3 - Mago%n");
            int classe = keyboardInt.nextInt()-1;

            Personagem personagem = new Personagem(nome, classe);

            listaPersonagens.add(personagem);
        }
        
        return listaPersonagens;
    }

    private static String ativa(Criatura usuario, Equipe inimigos, Acao acao, int alvo) {
        if (acao instanceof Habilidade) {
            return ((Habilidade)acao).usaHabilidade(usuario, inimigos, alvo);
        }
        else if (acao instanceof Item) {
            ((Item)acao).gastaUso();
            if (((Item)acao).getUsos()==0) {
                usuario.removerItem(((Item)acao));
            }
            return ((Item)acao).usaItem(usuario, inimigos, alvo);
        }
        else {
            return null;
        }
    }

    private static boolean isLutando(Equipe combatentes, Criatura combatente) {
        if(combatente.getVida()>0) {
            System.out.println(combatente.getNome() + " mantém-se vivo.");
            return true;
        }
        else {
            combatentes.removerCriatura(combatente);
            System.out.println(combatente.getNome() + " foi morto em combate...");
            return false;
        }
    }

    private static boolean isLutando(Equipe combatentes) {
        List<Boolean> results = new ArrayList<Boolean>();
        
        for(int i = 0; i<combatentes.size(); i++) {
            if(isLutando(combatentes, combatentes.get(i))) {
                results.add(i, true);
            }
            else {
                results.add(i, false);
            }
        }

        for(int j = 0; j<results.size(); j++) {
            if(results.get(j)) {
                return true;
            }
        }

        return false;
    }

    public static Acao menuAcoes(Criatura atual) {
        System.out.printf(atual.getNome() + " qual será a sua ação?%n");
        if (atual.getItens().size()>0) {
            System.out.println("0 - Itens");
        }
        for(int i = 0; i<atual.getHabilidades().size(); i++) {
            System.out.printf(i+1 + " - " + atual.getHabilidade(i).getNome() + " (" + atual.getHabilidade(i).getCusto() + ")%n");
        }

        int acao = keyboardInt.nextInt();
        if (acao>0) {
            return atual.getHabilidade(acao-1);
        }
        else {
            System.out.printf("Escolha o item a ser usado: %n"); 
            for(int i = 0; i<atual.getItens().size(); i++) {
                System.out.printf(i+1 + " - " + atual.getItem(i).getNome() + " (" + atual.getItem(i).getUsos() + ")%n");
            }                
            acao = keyboardInt.nextInt();
            return atual.getItem(acao);
        }
    }

    public static int menuAlvos(Equipe equipeAlvo) {; 
        for(int i = 0; i<equipeAlvo.size(); i++) {
            System.out.printf(i+1 + " - " + equipeAlvo.get(i).getNome() + "%n");
        }
        return keyboardInt.nextInt();
    }

    public static Equipe menuEquipes(Criatura atual, Equipe aliados, Equipe inimigos) {
        System.out.printf("Qual será a equipe alvo?%n1 - Inimigos%n2 - Aliados%n");
        int selecao = keyboardInt.nextInt();

        switch (selecao) {
            case 1: {
                return inimigos;
            }
            case 2: {
                return aliados;
            }
            default: {
                return null;
            }
        }
        
    }

    public static void menuItem() {

    }

    public static void turnoJogador(Criatura atual, Equipe aliados, Equipe inimigos) {
        Acao acao = menuAcoes(atual);

        int alvo = 0;

        while (alvo==0) {
        Equipe equipeAlvo = menuEquipes(atual, aliados, inimigos);

        System.out.printf(atual.getNome() + " qual será o seu alvo?%n0 - Trocar equipe alvo%n");
        alvo = menuAlvos(equipeAlvo);

        if (alvo>0) {
            System.out.println(ativa(atual, equipeAlvo, acao, alvo-1));
        }
        }
    }

    public static void turnoMonstro(Criatura atual, Equipe jogadores, Equipe monstros) {
        int escolha = ((int)(Math.random() * (atual.getHabilidades().size())));

        Habilidade habilidade = atual.getHabilidade(escolha);

        int selecao = ((int)(Math.random() * (jogadores.size())));

        System.out.println(ativa(atual, jogadores, habilidade, selecao));
    }

    public static String realizarCombate(Equipe equipe1, Equipe equipe2) {
        int num1 = 0;
        int num2 = 0;

        for(int i = 0; ; i++) {
            if(i%2==0) {
                if (num1>=equipe1.size()) {
                    num1 = 0;
                }
                Criatura atual = equipe1.get(num1);

                turnoJogador(atual, equipe1, equipe2);
                num1++;

                if(!isLutando(equipe2)) {
                    return "A primeira equipe venceu!";
                }
            }
            else {
                if (num2>=equipe2.size()){
                    num2 = 0;
                }
                Criatura atual = equipe2.get(num2);

                turnoJogador(atual, equipe2, equipe1);
                num2++;
                
                if(!isLutando(equipe1)) {
                    return "A segunda equipe venceu!";
                }
            }
        }
    }

    public static String realizarEncontro(Equipe aliados, Equipe inimigos) {
        int num1 = 0;
        int num2 = 0;

        for(int i = 0; ; i++) {
            if(i%2==0) {
                if (num1>=aliados.size()) {
                    num1 = 0;
                }
                Criatura atual = aliados.get(num1);

                turnoJogador(atual, aliados, inimigos);
                num1++;

                if(!isLutando(inimigos)) {
                    return "Com sucesso, vocês derrotam o último dos monstros e podem prosseguir!";
                }
            }
            else {
                if (num2>=inimigos.size()) {
                    num2 = 0;
                }
                Criatura atual = inimigos.get(num2);

                turnoMonstro(atual, aliados, inimigos);
                num2++;

                if(!isLutando(aliados)) {
                    return "Os monstros venceram e vocês foram derrotados...";
                }
            }
        }
    }

    public static void aumentaNivel(Criatura aliado) {
        aliado.setNivel(aliado.getNivel()+1);
        aliado.setExperiencia(aliado.getExperiencia()-1000);
        System.out.printf(aliado.getNome() + " subiu para o nível " + aliado.getNivel());
        System.out.printf("%nEscolha um atributo para aumentar.%n1 - Agilidade(" + aliado.getAtributos(0) + ")%n" +
        "2 - Força(" + aliado.getAtributos(1) + ")%n" + 
        "3 - Inteligência(" + aliado.getAtributos(2) + ")%n");
        int escolha = keyboardInt.nextInt()-1;
        switch (escolha) {
            case 0: {
                aliado.setAtributos(0, aliado.getAtributos(0)+1);
                System.out.println("Agilidade aumentada com sucesso.");
                break;
            }
            case 1: {
                aliado.setAtributos(1, aliado.getAtributos(1)+1);
                System.out.println("Força aumentada com sucesso.");
                break;
            }
            case 2: {
                aliado.setAtributos(2, aliado.getAtributos(2)+1);
                System.out.println("Inteligência aumentada com sucesso.");
                break;
            }
            default: {
                break;
            }
        }
    }

    public static void recebeRecompensa(Equipe aliados, Recompensa recompensa) {
        System.out.printf("Após os terríveis monstros serem derrotados, adiante de vocês jazia um belo tesouro.%nAo abrí-lo, vocês se deparavam com: %n");
        System.out.println(recompensa.toString());
        for(int i = 0; i<aliados.size(); i++) {
            aliados.get(i).addExperiencia(recompensa.getExperiencia());
            if(aliados.get(i).getExperiencia()>=1000) {
                aumentaNivel(aliados.get(i));
            }
        }
        if(recompensa.getHabilidade()!=null) {
            System.out.printf("Escolha um personagem para receber a seguinte habilidade: %n" + recompensa.getHabilidade().toString()); 

            int selecao = menuAlvos(aliados)-1;
            aliados.get(selecao).addHabilidade(recompensa.getHabilidade());
            System.out.println(aliados.get(selecao).getNome() + " recebeu " + recompensa.getHabilidade().getNome());
        }
        if(recompensa.getItem()!=null) {
            System.out.printf("Escolha um personagem para receber o seguinte item: %n" + recompensa.getItem().toString()); 

            int selecao = menuAlvos(aliados)-1;
            aliados.get(selecao).addItem(recompensa.getItem());
            System.out.println(aliados.get(selecao).getNome() + " recebeu " + recompensa.getItem().getNome());
        }
    }

    public static boolean entraSala(Equipe aliados, Sala sala) {
        System.out.println(sala.getDescricao());
        System.out.println("E diante de vocês..."); 
        for (int i = 0; i<sala.getInimigos().size(); i++) {
            System.out.println(sala.getInimigo(i).getNome());
        }
        Equipe inimigos = new Equipe(sala.getId(), sala.getInimigos());

        System.out.println(realizarEncontro(aliados, inimigos));

        if(isLutando(aliados)) {
            recebeRecompensa(aliados, sala.getRecompensa());
            return true;
        }
        else {
            System.out.printf("As portas das catacumbas se fecham novamente..%nTalvez... Elas nunca fossem ser abertas.%n");
            return false;
        }
    }

    public static void realizaTentativa(Fase fase) {
        for(int i = 0; i<fase.getListaSalas().size(); i++) {
            boolean sucesso = entraSala(fase.getEquipe(), fase.getSala(i));
            if(!sucesso) {
                break;
            }
            else {
                System.out.printf("Vocês prosseguem para a próxima sala... %n");
            }
        }
        System.out.printf("E quando o último golpe era desferido contra o corpo do lich, as Catacumbas começavam a colapsar.%n" + 
        "Os nossos heróis correm de lá o mais rápido que conseguem, mas nem todos são capazes de escapar com vida. %n" +
        "O mar de monstros, destroços e armadilhas no meio do caminho, permite que apenas um de nossos heróis sobrevivam..." + 
        "Ao olhar para trás, este via as portas das Catacumbas selando-se, para nunca mais serem abertas.");
    }

    public static void inicializacao() {
        System.out.printf("Bem-vindo ao The Catacombs!%n Digite qualquer inteiro para iniciar.%n");

        int escolha = keyboardInt.nextInt();
        switch(escolha) {
            case 0: {
                modoDev();
                break;
            }
            default: {
                modoCampanha();
                break;
            }
        }
    }

    public static void modoCampanha() {
        System.out.printf("%nVocê e o seu grupo de aventureiros nasceram numa cidade no pé de uma das maiores montanhas do continente." + 
        "%nVocê, e todos que viveram naquela vila, conheciam sobre os portões selados numa caverna dentro de uma montanha." + 
        "%nAs histórias que seus avós contavam diziam sobre um antigo lich soberano, que ali fora selado." +
        "%nA paz, porém, estava começando a romper." + 
        "%nMonstros começaram a surgir na vila e atacar aqueles que você chamava de família. Só havia uma resposta para isso: " + 
        "%nInvadir aquelas Catacumbas, e acabar com o lich, de uma vez por todas.");
        System.out.printf("%nCrie o seu personagem, e o de seus amigos.%n"); 

        List<Criatura> listaJogadores = new ArrayList<>();
        listaJogadores.addAll(Metodos.criarPersonagens(3));

        for (int i = 0; i<listaJogadores.size(); i++) {
            Personagem personagem = ((Personagem)listaJogadores.get(i));
            personagem.setId(personagemDAO.salvar(personagem));
        }

        Equipe jogadores = new Equipe(10, listaJogadores);
        jogadores.setId(equipeDAO.salvar(jogadores));

        for (int i = 0; i<jogadores.size(); i++) {
            jogadores.get(i).setEquipe(jogadores.getId());
        }

        System.out.printf("%nSelecione, a seguir, a Fase da qual deseja participar:" + 
        "%n(OBS: Fases além da de ID=1 são Fases personalizadas que devem ser criadas no Modo Dev.)%n");

        int escolha = keyboardInt.nextInt();

        Fase fase = faseDAO.buscar(escolha);

        realizaTentativa(fase);
    }

    public static void modoDev() {
        System.out.printf("%n--Bem-vindo ao Modo Dev--" + 
        "%nAqui pode ser realizado o CRUD de todas as tabelas no Banco de Dados." + 
        "%n1 - Habilidade%n2 - Item%n3 - Personagem%n4 - Monstro%n5 - Recompensa%n6 - Sala%n7 - Fase%n");

        int escolha = keyboardInt.nextInt();

        switch (escolha) {
            case 1: {
                habilidadeCRUD();
                break;
            }
            case 2: {
                itemCRUD();
                break;
            }
            case 3: {
                personagemCRUD();
                break;
            }
            case 4: {
                monstroCRUD();
                break;
            }
            case 5: {
                recompensaCRUD();
                break;
            }
            case 6: {
                salaCRUD();
                break;
            }
            case 7: {
                faseCRUD();
            }
            default: {
                System.out.println("Valor inválido.");
                break;
            }
        }
    }

    public static void habilidadeCRUD() {
        System.out.printf("%n1 - Create%n2 - Read%n3 - Update%n4 - Delete%n");

        int escolha = keyboardInt.nextInt();

        switch (escolha) {
            case 1: {
                //CREATE

                System.out.printf("%nDefina um nome, uma descrição, um tipo, um valor máximo de dano/cura, um valor mínimo de dano/cura, um valor mínimo para o teste de resistência, um tipo de dano, um atributo de resistência/ataque e um custo de Poder.%n");
                String nome = keyboardString.nextLine();
                String descricao = keyboardString.nextLine();
                int tipo = keyboardInt.nextInt();
                int maxRoll = keyboardInt.nextInt();
                int minRoll = keyboardInt.nextInt();
                int minTeste = keyboardInt.nextInt();
                int tipoDano = keyboardInt.nextInt();
                int atributo = keyboardInt.nextInt();
                int custo = keyboardInt.nextInt();

                Habilidade habilidade;

                switch (tipo) {
                    case 0: {
                        habilidade = new Ataque(1, nome, descricao, maxRoll, minRoll, tipoDano, atributo, custo);
                        habilidade.setId(habilidadeDAO.salvar(habilidade));

                        System.out.println("Habilidade de ID=" + habilidade.getId() + " criada com sucesso.");
                        break;
                    }
                    case 1: {
                        habilidade = new Resistencia(1, nome, descricao, maxRoll, minRoll, minTeste, tipoDano, atributo, custo);
                        habilidade.setId(habilidadeDAO.salvar(habilidade));

                        System.out.println("Habilidade de ID=" + habilidade.getId() + " criada com sucesso.");
                        break;
                    }
                    case 2: {
                        habilidade = new Garantido(1, nome, descricao, maxRoll, minRoll, tipoDano, custo);
                        habilidade.setId(habilidadeDAO.salvar(habilidade));

                        System.out.println("Habilidade de ID=" + habilidade.getId() + " criada com sucesso.");
                        break;
                    }
                    default: {
                        System.out.println("Valor de Tipo inválido.");
                        break;
                    }
                }
                break;
            }
            case 2: {
                //READ

                System.out.printf("Defina um valor de ID para ser buscado.%n");

                long id = keyboardInt.nextLong();
                Habilidade habilidade = habilidadeDAO.buscar(id);

                System.out.printf(habilidade.toString());
                break;
            }
            case 3: {
                //UPDATE

                System.out.printf("%nEscolha o ID da habilidade a ser atualizada. Então defina um nome, uma descrição, um tipo, um valor máximo de dano/cura, um valor mínimo de dano/cura, um valor mínimo para o teste de resistência, um tipo de dano, um atributo de resistência/ataque e um custo de Poder da sua atualização.%n");
                long id = keyboardInt.nextLong();
                String nome = keyboardString.nextLine();
                String descricao = keyboardString.nextLine();
                int tipo = keyboardInt.nextInt();
                int maxRoll = keyboardInt.nextInt();
                int minRoll = keyboardInt.nextInt();
                int minTeste = keyboardInt.nextInt();
                int tipoDano = keyboardInt.nextInt();
                int atributo = keyboardInt.nextInt();
                int custo = keyboardInt.nextInt();

                Habilidade habilidade;

                switch (tipo) {
                    case 0: {
                        habilidade = new Ataque(id, nome, descricao, maxRoll, minRoll, tipoDano, atributo, custo);
                        habilidadeDAO.editar(habilidade);

                        System.out.println("Habilidade de ID=" + habilidade.getId() + " atualizada com sucesso.");
                        break;
                    }
                    case 1: {
                        habilidade = new Resistencia(id, nome, descricao, maxRoll, minRoll, minTeste, tipoDano, atributo, custo);
                        habilidadeDAO.editar(habilidade);

                        System.out.println("Habilidade de ID=" + habilidade.getId() + " atualizada com sucesso.");
                        break;
                    }
                    case 2: {
                        habilidade = new Garantido(id, nome, descricao, maxRoll, minRoll, tipoDano, custo);
                        habilidadeDAO.editar(habilidade);

                        System.out.println("Habilidade de ID=" + habilidade.getId() + " atualizada com sucesso.");
                        break;
                    }
                    default: {
                        System.out.println("Valor de Tipo inválido.%n");
                        break;
                    }
                }
                break;
            }
            case 4: {
                //DELETE

                System.out.printf("%nDefina o ID da habilidade que deseja excluir.%n");

                long id = keyboardInt.nextLong();
                habilidadeDAO.excluir(id);

                System.out.println("Habilidade de ID=" + id + " excluída com sucesso.");
                break;
            }
            default: {
                System.out.println("Valor inválido.");
                break;
            }
        }
    }

    public static void itemCRUD() {
        System.out.printf("%n1 - Create%n2 - Read%n3 - Update%n4 - Delete%n");

        int escolha = keyboardInt.nextInt();

        switch (escolha) {
            case 1: {
                //CREATE

                System.out.printf("%nDefina um nome, uma quantidade de usos e o ID de uma habilidade.%n");

                String nome = keyboardString.nextLine();
                int usos = keyboardInt.nextInt();
                long id_habilidade = keyboardInt.nextLong();
                Habilidade habilidade = habilidadeDAO.buscar(id_habilidade);

                Item item = new Item(1, nome, usos, habilidade);
                item.setId(itemDAO.salvar(item));

                System.out.println("Item de ID=" + item.getId() + " criado com sucesso.");
                break;
            }
            case 2: {
                //READ

                System.out.printf("%nDefina o ID do item a ser buscado.%n");

                long id = keyboardInt.nextLong();

                Item item = itemDAO.buscar(id);
                System.out.println(item.toString());
                break;
            }
            case 3: {
                //UPDATE 

                System.out.printf("%nEscolha o ID do item a ser atualizado.%nEntão defina um nome, uma quantidade de usos e o ID de uma habilidade para a atualização.%n");

                long id = keyboardInt.nextLong();
                String nome = keyboardString.nextLine();
                int usos = keyboardInt.nextInt();
                long id_habilidade = keyboardInt.nextLong();
                Habilidade habilidade = habilidadeDAO.buscar(id_habilidade);

                Item item = new Item(id, nome, usos, habilidade);
                itemDAO.editar(item);

                System.out.println("Item de ID=" + item.getId() + " atualizado com sucesso.");
                break;
            }
            case 4: {
                //DELETE

                System.out.printf("%Defina o ID do item que deseja excluir.");

                long id = keyboardInt.nextLong();
                itemDAO.excluir(id);

                System.out.println("Item de ID=" + id + " excluído com sucesso.");
                break;
            }
            default: {
                System.out.println("Valor inválido.");
                break;
            }
        }
    }

    public static void personagemCRUD() {
        System.out.printf("%n1 - Create%n2 - Read%n3 - Update%n4 - Delete%n");

        int escolha = keyboardInt.nextInt();

        switch (escolha) {
            case 1: {
                //CREATE

                System.out.printf("%nDefina o nome, a classe, a vida, a armadura, o poder, o nível, a experiência e o ID da equipe do personagem.%n");
                String nome = keyboardString.nextLine();
                int classe = keyboardInt.nextInt();
                int vida = keyboardInt.nextInt();
                int armadura = keyboardInt.nextInt();
                int poder = keyboardInt.nextInt();
                int nivel = keyboardInt.nextInt();
                int experiencia = keyboardInt.nextInt();
                long equipe = keyboardInt.nextLong();

                Personagem personagem = new Personagem(1, nome, classe, armadura, vida, nivel, poder, experiencia, equipe);

                System.out.printf("%nDefina os valores de agilidade, força e inteligência do personagem.%n");
                int agilidade = keyboardInt.nextInt();
                int forca = keyboardInt.nextInt();
                int inteligencia = keyboardInt.nextInt();

                personagem.setAtributos(0, agilidade);
                personagem.setAtributos(1, forca);
                personagem.setAtributos(2, inteligencia);

                System.out.printf("%nDefina as fraquezas do personagem.%n"); 
                boolean flamejante = keyboardString.nextBoolean();
                boolean congelante = keyboardString.nextBoolean();
                boolean eletrico = keyboardString.nextBoolean();
                boolean fisico = keyboardString.nextBoolean();
                boolean arcano = keyboardString.nextBoolean();

                personagem.setFraquezas(0, flamejante);
                personagem.setFraquezas(1, congelante);
                personagem.setFraquezas(2, eletrico);
                personagem.setFraquezas(3, fisico);
                personagem.setFraquezas(4, arcano);

                System.out.printf("%nDefina quantas habilidades o personagem possui, e então, o ID de cada uma delas.%n");
                int num_hab = keyboardInt.nextInt();
                for (int i = 0; i<num_hab; i++) {
                    int id_habilidade = keyboardInt.nextInt();
                    Habilidade habilidade = habilidadeDAO.buscar(id_habilidade);

                    personagem.addHabilidade(habilidade);
                }
                
                System.out.printf("%nDefina quantos itens o personagem possui, e então, o ID de cada um deles.%n");
                int num_item = keyboardInt.nextInt();
                for (int i = 0; i<num_item; i++) {
                    int id_item = keyboardInt.nextInt();
                    Item item = itemDAO.buscar(id_item);

                    personagem.addItem(item);
                }

                personagem.setId(personagemDAO.salvar(personagem));

                System.out.println("Personagem de ID=" + personagem.getId() + " criado com sucesso.");
                break;
            }
            case 2: {
                //READ

                System.out.printf("%nDefina o ID do personagem a ser buscado.%n");

                long id = keyboardInt.nextLong();

                Personagem personagem = personagemDAO.buscar(id);
                System.out.println(personagem.toString());
                break;
            }
            case 3: {
                //UPDATE

                System.out.printf("%nEscolha o ID do personagem a ser atualizado. Então defina o nome, a classe, a vida, a armadura, o poder, o nível, a experiência e o ID da equipe do personagem atualizado.%n");
                long id = keyboardInt.nextLong();
                String nome = keyboardString.nextLine();
                int classe = keyboardInt.nextInt();
                int vida = keyboardInt.nextInt();
                int armadura = keyboardInt.nextInt();
                int poder = keyboardInt.nextInt();
                int nivel = keyboardInt.nextInt();
                int experiencia = keyboardInt.nextInt();
                long equipe = keyboardInt.nextLong();

                Personagem personagem = new Personagem(id, nome, classe, armadura, vida, nivel, poder, experiencia, equipe);

                System.out.printf("%nDefina os valores de agilidade, força e inteligência do personagem.%n");
                int agilidade = keyboardInt.nextInt();
                int forca = keyboardInt.nextInt();
                int inteligencia = keyboardInt.nextInt();

                personagem.setAtributos(0, agilidade);
                personagem.setAtributos(1, forca);
                personagem.setAtributos(2, inteligencia);

                System.out.printf("%nDefina as fraquezas do personagem.%n"); 
                boolean flamejante = keyboardString.nextBoolean();
                boolean congelante = keyboardString.nextBoolean();
                boolean eletrico = keyboardString.nextBoolean();
                boolean fisico = keyboardString.nextBoolean();
                boolean arcano = keyboardString.nextBoolean();

                personagem.setFraquezas(0, flamejante);
                personagem.setFraquezas(1, congelante);
                personagem.setFraquezas(2, eletrico);
                personagem.setFraquezas(3, fisico);
                personagem.setFraquezas(4, arcano);

                System.out.printf("%nDefina quantas habilidades o personagem possui, e então, o ID de cada uma delas.%n");
                int num_hab = keyboardInt.nextInt();
                for (int i = 0; i<num_hab; i++) {
                    int id_habilidade = keyboardInt.nextInt();
                    Habilidade habilidade = habilidadeDAO.buscar(id_habilidade);

                    personagem.addHabilidade(habilidade);
                }
                
                System.out.printf("%nDefina quantos itens o personagem possui, e então, o ID de cada um deles.%n");
                int num_item = keyboardInt.nextInt();
                for (int i = 0; i<num_item; i++) {
                    int id_item = keyboardInt.nextInt();
                    Item item = itemDAO.buscar(id_item);

                    personagem.addItem(item);
                }

                personagemDAO.editar(personagem);

                System.out.println("Personagem de ID=" + personagem.getId() + " atualizado com sucesso.");
                break;
            }
            case 4: {
                //DELETE

                System.out.printf("%Defina o ID do personagem que deseja excluir.%n");

                long id = keyboardInt.nextLong();
                personagemDAO.excluir(id);

                System.out.println("Personagem de ID=" + id + " excluído com sucesso.");
                break;
            }
            default: {
                System.out.println("Valor inválido.");
                break;
            }
        }
    }

    public static void monstroCRUD() {
        System.out.printf("%n1 - Create%n2 - Read%n3 - Update%n4 - Delete%n");

        int escolha = keyboardInt.nextInt();

        switch (escolha) {
            case 1: {
                //CREATE

                System.out.printf("Defina o nome, a vida, a armadura, o nivel e o ID da equipe do monstro.%n");
                String nome = keyboardString.nextLine();
                int vida = keyboardInt.nextInt();
                int armadura = keyboardInt.nextInt();
                int nivel = keyboardInt.nextInt();
                long equipe = keyboardInt.nextLong();

                Monstro monstro = new Monstro(1, nome, vida, armadura, nivel, 0, equipe);

                System.out.printf("%nDefina os valores de agilidade, força e inteligência do monstro.%n");
                int agilidade = keyboardInt.nextInt();
                int forca = keyboardInt.nextInt();
                int inteligencia = keyboardInt.nextInt();

                monstro.setAtributos(0, agilidade);
                monstro.setAtributos(1, forca);
                monstro.setAtributos(2, inteligencia);

                System.out.printf("%nDefina as fraquezas do monstro.%n"); 
                boolean flamejante = keyboardString.nextBoolean();
                boolean congelante = keyboardString.nextBoolean();
                boolean eletrico = keyboardString.nextBoolean();
                boolean fisico = keyboardString.nextBoolean();
                boolean arcano = keyboardString.nextBoolean();

                monstro.setFraquezas(0, flamejante);
                monstro.setFraquezas(1, congelante);
                monstro.setFraquezas(2, eletrico);
                monstro.setFraquezas(3, fisico);
                monstro.setFraquezas(4, arcano);

                System.out.printf("%nDefina quantas habilidades o monstro possui, e então, o ID de cada uma delas.%n");
                int num_hab = keyboardInt.nextInt();
                for (int i = 0; i<num_hab; i++) {
                    int id_habilidade = keyboardInt.nextInt();
                    Habilidade habilidade = habilidadeDAO.buscar(id_habilidade);

                    monstro.addHabilidade(habilidade);
                }

                monstro.setId(monstroDAO.salvar(monstro));

                System.out.println("Monstro de ID=" + monstro.getId() + " criado com sucesso.");
                break;
            }
            case 2: {
                //READ

                System.out.printf("%nDefina o ID do monstro a ser buscado.%n");

                long id = keyboardInt.nextLong();

                Monstro monstro = monstroDAO.buscar(id);
                System.out.println(monstro.toString());
                break;
            }
            case 3: {
                //UPDATE

                System.out.printf("Escolha o ID do monstro a ser atualizado. Então, defina o nome, a vida, a armadura, o nivel e o ID da equipe do monstro atualizado.%n");
                long id = keyboardInt.nextLong();
                String nome = keyboardString.nextLine();
                int vida = keyboardInt.nextInt();
                int armadura = keyboardInt.nextInt();
                int nivel = keyboardInt.nextInt();
                long equipe = keyboardInt.nextLong();

                Monstro monstro = new Monstro(id, nome, vida, armadura, nivel, 0, equipe);

                System.out.printf("%nDefina os valores de agilidade, força e inteligência do monstro.%n");
                int agilidade = keyboardInt.nextInt();
                int forca = keyboardInt.nextInt();
                int inteligencia = keyboardInt.nextInt();

                monstro.setAtributos(0, agilidade);
                monstro.setAtributos(1, forca);
                monstro.setAtributos(2, inteligencia);

                System.out.printf("%nDefina as fraquezas do monstro.%n"); 
                boolean flamejante = keyboardString.nextBoolean();
                boolean congelante = keyboardString.nextBoolean();
                boolean eletrico = keyboardString.nextBoolean();
                boolean fisico = keyboardString.nextBoolean();
                boolean arcano = keyboardString.nextBoolean();

                monstro.setFraquezas(0, flamejante);
                monstro.setFraquezas(1, congelante);
                monstro.setFraquezas(2, eletrico);
                monstro.setFraquezas(3, fisico);
                monstro.setFraquezas(4, arcano);

                System.out.printf("%nDefina quantas habilidades o monstro possui, e então, o ID de cada uma delas.%n");
                int num_hab = keyboardInt.nextInt();
                for (int i = 0; i<num_hab; i++) {
                    int id_habilidade = keyboardInt.nextInt();
                    Habilidade habilidade = habilidadeDAO.buscar(id_habilidade);

                    monstro.addHabilidade(habilidade);
                }

                monstroDAO.editar(monstro);

                System.out.println("Monstro de ID=" + monstro.getId() + " atualizado com sucesso.");
                break;
            }
            case 4: {
                //DELETE

                System.out.printf("%Defina o ID do monstro que deseja excluir.%n");

                long id = keyboardInt.nextLong();
                monstroDAO.excluir(id);

                System.out.println("Monstro de ID=" + id + " excluído com sucesso.");
                break;
            }
            default: {
                System.out.println("Valor inválido.");
                break;
            }
        }
    }

    public static void recompensaCRUD() {
        System.out.printf("%n1 - Create%n2 - Read%n3 - Update%n4 - Delete%n");

        int escolha = keyboardInt.nextInt();

        switch (escolha) {
            case 1: {
                //CREATE

                System.out.printf("Defina o tipo, a raridade, a experiência concedida, o ID do item concedido e o ID da habilidade concedida.%n");
                int tipo = keyboardInt.nextInt();
                int raridade = keyboardInt.nextInt();
                int experiencia = keyboardInt.nextInt();
                long id_item = keyboardInt.nextLong();
                long id_habilidade = keyboardInt.nextLong();

                switch (tipo) {
                    case 0: {
                        Recompensa recompensa = new Recompensa(tipo, raridade, experiencia);
                        recompensa.setId(recompensaDAO.salvar(recompensa));

                        System.out.println("Recompensa de ID=" + recompensa.getId() + " criada com sucesso.");
                        break;
                    }
                    case 1: {
                        Item item = itemDAO.buscar(id_item);
                        Recompensa recompensa = new Recompensa(tipo, raridade, experiencia, item);
                        recompensa.setId(recompensaDAO.salvar(recompensa));

                        System.out.println("Recompensa de ID=" + recompensa.getId() + " criada com sucesso.");
                        break;
                    }
                    case 2: {
                        Habilidade habilidade = habilidadeDAO.buscar(id_habilidade);
                        Recompensa recompensa = new Recompensa(tipo, raridade, experiencia, habilidade);
                        recompensa.setId(recompensaDAO.salvar(recompensa));

                        System.out.println("Recompensa de ID=" + recompensa.getId() + " criada com sucesso.");
                        break;
                    }
                    case 3: {
                        Item item = itemDAO.buscar(id_item);
                        Habilidade habilidade = habilidadeDAO.buscar(id_habilidade);
                        Recompensa recompensa = new Recompensa(tipo, raridade, experiencia, item, habilidade);
                        recompensa.setId(recompensaDAO.salvar(recompensa));

                        System.out.println("Recompensa de ID=" + recompensa.getId() + " criada com sucesso.");
                        break;
                    }
                    default: {
                        System.out.println("Valor de tipo inválido.");
                        break;
                    }
                }
                break;
            }
            case 2: {
                //READ

                System.out.printf("%nDefina o ID do recompensa a ser buscado.%n");

                long id = keyboardInt.nextLong();

                Recompensa recompensa = recompensaDAO.buscar(id);
                System.out.println(recompensa.toString());
                break;
            }
            case 3: {
                //UPDATE
                System.out.printf("Escolha o ID da recompensa a ser atualizada. Então defina o tipo, a raridade, a experiência concedida, o ID do item concedido e o ID da habilidade concedida da atualização.%n");
                long id = keyboardInt.nextLong();
                int tipo = keyboardInt.nextInt();
                int raridade = keyboardInt.nextInt();
                int experiencia = keyboardInt.nextInt();
                long id_item = keyboardInt.nextLong();
                long id_habilidade = keyboardInt.nextLong();

                switch (tipo) {
                    case 0: {
                        Recompensa recompensa = new Recompensa(tipo, raridade, experiencia);
                        recompensa.setId(id);
                        recompensaDAO.editar(recompensa);

                        System.out.println("Recompensa de ID=" + id + " atualizada com sucesso.");
                        break;
                    }
                    case 1: {
                        Item item = itemDAO.buscar(id_item);
                        Recompensa recompensa = new Recompensa(tipo, raridade, experiencia, item);
                        recompensa.setId(id);
                        recompensaDAO.editar(recompensa);

                        System.out.println("Recompensa de ID=" + id + " atualizada com sucesso.");
                        break;
                    }
                    case 2: {
                        Habilidade habilidade = habilidadeDAO.buscar(id_habilidade);
                        Recompensa recompensa = new Recompensa(tipo, raridade, experiencia, habilidade);
                        recompensa.setId(id);
                        recompensaDAO.editar(recompensa);

                        System.out.println("Recompensa de ID=" + id + " atualizada com sucesso.");
                        break;
                    }
                    case 3: {
                        Item item = itemDAO.buscar(id_item);
                        Habilidade habilidade = habilidadeDAO.buscar(id_habilidade);
                        Recompensa recompensa = new Recompensa(tipo, raridade, experiencia, item, habilidade);
                        recompensa.setId(id);
                        recompensaDAO.editar(recompensa);

                        System.out.println("Recompensa de ID=" + id + " atualizada com sucesso.");
                        break;
                    }
                    default: {
                        System.out.println("Valor de tipo inválido.");
                        break;
                    }
                }
                break;
            }
            case 4: {
                //DELETE

                System.out.printf("%Defina o ID do recompensa que deseja excluir.%n");

                long id = keyboardInt.nextLong();
                recompensaDAO.excluir(id);

                System.out.println("Recompensa de ID=" + id + " excluído com sucesso.");
                break;
            }
            default: {
                System.out.println("Valor inválido.");
                break;
            }
        }
    }

    public static void salaCRUD() {
        System.out.printf("%n1 - Create%n2 - Read%n3 - Update%n4 - Delete%n");

        int escolha = keyboardInt.nextInt();

        switch (escolha) {
            case 1: {
                //CREATE

                System.out.printf("Defina o nome, a descrição e o ID da sua recompensa.%n");
                String nome = keyboardString.nextLine();
                String descricao = keyboardString.nextLine();
                long id_recompensa = keyboardInt.nextLong();
                Recompensa recompensa = recompensaDAO.buscar(id_recompensa);

                Sala sala = new Sala(1, nome, descricao);
                sala.setRecompensa(recompensa);

                System.out.printf("Defina quantos monstros existem na sala, e então o ID de cada um deles.%n"); 
                int num_monstros = keyboardInt.nextInt();
                for (int i = 0; i<num_monstros; i++) {
                    long id_monstro = keyboardInt.nextLong();
                    Monstro monstro = monstroDAO.buscar(id_monstro);

                    sala.addInimigos(monstro);
                }

                sala.setId(salaDAO.salvar(sala));

                System.out.println("Sala de ID=" + sala.getId() + " criada com sucesso.");
                break;
            }
            case 2: {
                //READ

                System.out.printf("%nDefina o ID da sala a ser buscada.%n");

                long id = keyboardInt.nextLong();

                Sala sala = salaDAO.buscar(id);
                System.out.println(sala.toString());
                break;
            }
            case 3: {
                //UPDATE

                System.out.printf("Escolha o ID da sala a ser atualizada. Então defina o nome, a descrição e o ID da sua recompensa da atualização.%n");
                long id = keyboardInt.nextLong();
                String nome = keyboardString.nextLine();
                String descricao = keyboardString.nextLine();
                long id_recompensa = keyboardInt.nextLong();
                Recompensa recompensa = recompensaDAO.buscar(id_recompensa);

                Sala sala = new Sala(id, nome, descricao);
                sala.setRecompensa(recompensa);

                System.out.printf("Defina quantos monstros existem na sala, e então o ID de cada um deles.%n"); 
                int num_monstros = keyboardInt.nextInt();
                for (int i = 0; i<num_monstros; i++) {
                    long id_monstro = keyboardInt.nextLong();
                    Monstro monstro = monstroDAO.buscar(id_monstro);

                    sala.addInimigos(monstro);
                }

                salaDAO.editar(sala);

                System.out.println("Sala de ID=" + id + " atualizada com sucesso.");
                break;
            }
            case 4: {
                //DELETE

                System.out.printf("%Defina o ID da sala que deseja excluir.%n");

                long id = keyboardInt.nextLong();
                salaDAO.excluir(id);

                System.out.println("Sala de ID=" + id + " excluída com sucesso.");
                break;
            }
            default: {
                System.out.println("Valor inválido.");
                break;
            }
        }
    }

    public static void faseCRUD() {
        System.out.printf("%n1 - Create%n2 - Read%n3 - Update%n4 - Delete%n");

        int escolha = keyboardInt.nextInt();

        switch (escolha) {
            case 1: {
                //CREATE
                System.out.printf("Defina um nome para a fase e uma quantidade de salas, definindo então o ID de cada uma dessas salas.%n");
                String nome = keyboardString.nextLine();
                int num_salas = keyboardInt.nextInt();

                List<Sala> listaSalas = new ArrayList<Sala>(num_salas);
                for (int i = 0; i<num_salas; i++) {
                    long id_sala = keyboardInt.nextLong();
                    Sala sala = salaDAO.buscar(id_sala);
                    listaSalas.add(sala);
                }

                Fase fase = new Fase(nome, listaSalas);
                fase.setId(faseDAO.salvar(fase));

                System.out.println("Fase de ID=" + fase.getId() + " criada com sucesso.");
                break;
            }
            case 2: {
                //READ

                System.out.printf("%nDefina o ID da fase a ser buscada.%n");

                long id = keyboardInt.nextLong();

                Fase fase = faseDAO.buscar(id);
                System.out.println(fase.toString());
                break;
            }
            case 3: {
                //UPDATE

                System.out.printf("Escolha o ID da fase a ser atualizada. Defina um nome para a fase e uma quantidade de salas, definindo então o ID de cada uma dessas salas.%n");
                long id = keyboardInt.nextLong();
                String nome = keyboardString.nextLine();
                int num_salas = keyboardInt.nextInt();

                List<Sala> listaSalas = new ArrayList<Sala>(num_salas);
                for (int i = 0; i<num_salas; i++) {
                    long id_sala = keyboardInt.nextLong();
                    Sala sala = salaDAO.buscar(id_sala);
                    listaSalas.add(sala);
                }

                Fase fase = new Fase(nome, listaSalas);
                fase.setId(id);
                faseDAO.editar(fase);

                System.out.println("Fase de ID=" + fase.getId() + " atualizada com sucesso.");

                break;
            }
            case 4: {
                //DELETE

                System.out.printf("%Defina o ID da fase que deseja excluir.%n");

                long id = keyboardInt.nextLong();
                faseDAO.excluir(id);

                System.out.println("Fase de ID=" + id + " excluída com sucesso.");
                break;
            }
            default: {
                System.out.println("Valor inválido.");
                break;
            }
        }
    }

}
