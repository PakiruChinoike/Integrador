import java.lang.Math;
import java.util.ArrayList;

public final class Golpeada extends Habilidade{
    
    private static int id;
    private static String nome;
    private static String descricao;
    private static int dano;

    public Golpeada(){
        id = 1;
        nome = "Golpeada";
        descricao = "Um forte golpe que acerta um inimigo";
        dano = 3;
    }

    protected static int habilidadeAtiva(Personagem usuario, ArrayList<Monstro> inimigos, int alvo) {
        int hit = (int)(Math.random() * 20) + 1 + usuario.getForca();
            if (hit>inimigos.get(alvo).getArmadura()) {
                int damage = (int)(Math.random()*8)+1;
                if (inimigos.get(alvo).getFraquezas(dano)) {
                    damage = damage*2;
                }
                inimigos.get(alvo).setVida((inimigos.get(alvo).getVida())-damage);
                return 1;
            }
            else {
                return 0;
            }
    }

}
