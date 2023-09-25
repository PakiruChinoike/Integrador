import java.util.Scanner;
import java.util.ArrayList;

public class TesteCriarPerso {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        Scanner keyboard2 = new Scanner(System.in);

        String nome = keyboard.nextLine();
        int classe = keyboard2.nextInt();

        Personagem char1 = new Personagem(nome, classe, 1);

        System.out.println(char1.toString());
        System.out.println(char1.getNome());
        System.out.println(char1.getListaHabilidades());
        System.out.printf(char1.getAtributos());

        Monstro mon1 = new Monstro("Esqueleto", 1, 3);
        Monstro mon2 = new Monstro("Zumbi", 1, 4);
        ArrayList<Monstro> inimigos = new ArrayList<Monstro>();
        inimigos.add(mon1);
        inimigos.add(mon2);

        System.out.println("Um esqueleto e um zumbi surgem na sua frente!");

        for (int i = 0; char1.getVida()>=0 || (mon1.getVida()>=0 && mon2.getVida()>=0); i++) {
            System.out.println("O que você deseja fazer?");
            System.out.printf(char1.getListaHabilidades().get(0) + ": Golpeada%n" + 
            char1.getListaHabilidades().get(1) + ": Bloquear%n" + 
            char1.getListaHabilidades().get(2) + ": Ataque Pesado%n" + 
            char1.getListaHabilidades().get(3) + ": Recuperar Fôlego%n");
            if (char1.getVida()>0) {
                int escolha = keyboard2.nextInt();
                int alvo =  keyboard2.nextInt()-1;
                int resultado = Habilidade.usaHabilidade(escolha, char1, inimigos, alvo);
                if(resultado==1) {
                    System.out.println(char1.getNome() + " acertou " + inimigos.get(alvo).getNome() + ", o deixando com " + inimigos.get(alvo).getVida() + " pontos de vida.");
                }
                else if(resultado==inimigos.size()) {
                    System.out.println(char1.getNome() + " acertou todos os inimigos, deixando-os com " + inimigos.get(0).getVida() + " e " + inimigos.get(1).getVida() + " pontos de vida.");
                }
                else if(resultado==10) {
                    System.out.println(char1.getNome() + " usou uma habilidade em si mesmo!");
                }
                else {
                    System.out.println(char1.getNome() + " errou o ataque.");
                }
            }
            if (mon1.getVida()>0) {
                int resultado = Habilidade.usaHabilidade(13, mon1, char1);
                if (resultado==1) {
                    System.out.println(mon1.getNome() + " acertou " + char1.getNome() + ", o deixando com " + char1.getVida() + " pontos de vida.");
                }
                else {
                    System.out.println(mon1.getNome() + " errou o ataque.");
                }
            }
            if (mon2.getVida()>0) {
                int resultado = Habilidade.usaHabilidade(13, mon2, char1);
                if (resultado==1) {
                    System.out.println(mon2.getNome() + " acertou " + char1.getNome() + ", o deixando com " + char1.getVida() + " pontos de vida.");
                }
                else {
                    System.out.println(mon2.getNome() + " errou o ataque.");
                }
            }
        }

        keyboard.close();
        keyboard2.close();
    }

}