import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;

public class Metodos {

    private static Scanner keyboardInt = new Scanner(System.in);
    private static Scanner keyboardString = new Scanner(System.in);

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

    private static String ativa(Criatura usuario, Equipe inimigos, int numHab, int alvo) {
        return usuario.getHabilidade(numHab).usaHabilidade(usuario, inimigos, alvo);
    }

    private static boolean isLutando(Criatura combatente) {
        if(combatente.getVida()>0) {
            return true;
        }
        else {
            return false;
        }
    }

    private static boolean isLutando(Equipe combatentes) {
        boolean isLutando = true;

        for(int i = 0; i<combatentes.size(); i++) {
            isLutando = isLutando(combatentes.get(i));
        }
        return isLutando;
    }

    public static int menuHabilidades(Criatura atual) {
        System.out.printf(atual.getNome() + " qual será a sua ação?%n");
        for(int j = 0; j<atual.getHabilidades().size(); j++) {
            System.out.printf(j+1 + " - " + atual.getHabilidade(j).getNome() + "%n");
        }

        return keyboardInt.nextInt()-1;
    }

    public static int menuAlvos(Criatura atual, Equipe equipeAlvo) {
        System.out.printf(atual.getNome() + " qual será o seu alvo?%n0 - Trocar equipe alvo%n"); 
        for(int j = 0; j<equipeAlvo.size(); j++) {
            System.out.printf(j+1 + " - " + equipeAlvo.get(j).getNome() + "%n");
        }
        return keyboardInt.nextInt()-1;
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

    public static void turnoJogador(Criatura atual, Equipe aliados, Equipe inimigos) {
        int hab = menuHabilidades(atual);

        Equipe equipeAlvo = menuEquipes(atual, aliados, inimigos);

        int selecao = menuAlvos(atual, equipeAlvo);

        System.out.println(ativa(atual, equipeAlvo, hab, selecao));
    }

    public static void turnoMonstro(Criatura atual, Equipe jogadores, Equipe monstros) {
        int hab = ((int)(Math.random() * (atual.getHabilidades().size())));

        int selecao = ((int)(Math.random() * (jogadores.size())));

        System.out.println(ativa(atual, jogadores, hab, selecao));
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

}
