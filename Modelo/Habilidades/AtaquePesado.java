import java.lang.Math;
import java.util.ArrayList;

public final class AtaquePesado extends Habilidade{

    private static int id;
    private static String nome;
    private static String descricao;
    private static int dano;
    
    public AtaquePesado(){
        id = 3;
        nome = "Ataque Pesado";
        descricao = "Um golpe abrangente que acerta todos os inimigos adiante";
        dano = 3;
    }

    protected static int habilidadeAtiva(Personagem usuario, ArrayList<Monstro> inimigos) {
        int hit = (int)(Math.random()*20)+5+usuario.getForca();
        int acertos = 0;
        for (int i = 0; i<inimigos.size(); i++) {
            if (hit>inimigos.get(i).getArmadura()) {
                int damage = (int)(Math.random()*16)+4;
                if (inimigos.get(i).getFraquezas(dano)) {
                    damage = damage*2;
                }
                inimigos.get(i).setVida((inimigos.get(i).getVida())-damage);
                acertos++;
            }
        }
        return acertos;
    }

}