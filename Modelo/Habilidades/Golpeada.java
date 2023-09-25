import java.lang.Math;
import java.util.ArrayList;

public class Golpeada extends Habilidade{
    
    public Golpeada(){
        super(1, "Golpeada", "Um forte ataque físico.");
    }

    protected static int habilidadeAtiva(Personagem usuario, ArrayList<Monstro> inimigos, int alvo) {
        int hit = (int)(Math.random() * 20) + 1 + usuario.getForca();
            if (hit>inimigos.get(alvo).getArmadura()) {
                int damage = (int)(Math.random()*8)+1;
                inimigos.get(alvo).setVida((inimigos.get(alvo).getVida())-damage);
                return 1;
            }
            else {
                return 0;
            }
    }

}
