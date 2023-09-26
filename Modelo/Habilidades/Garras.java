import java.lang.Math;
import java.util.ArrayList;

public final class Garras extends Habilidade{
    
    private static int id;
    private static String nome;
    private static String descricao;
    private static int dano;

    public Garras(){
        id = 13;
        nome = "Garras";
        descricao = "Um golpe das garras de um monstro";
        dano = 3;
    }

    protected static int habilidadeAtiva(Monstro usuario, ArrayList<Personagem> inimigos, int alvo) {
        int hit = (int)(Math.random() * 20) + 1 + usuario.getAtaque();
            if (hit>inimigos.get(alvo).getArmadura()) {
                int damage = (int)(Math.random()*4)+1;
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
