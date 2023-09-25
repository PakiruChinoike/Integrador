import java.lang.Math;
import java.util.ArrayList;

public class AtaquePesado extends Habilidade{
    
    public AtaquePesado(){
        super(3, "Ataque Pesado", "Um golpe de varrida devastador que acerta todos em sua frente.");
    }

    protected static int habilidadeAtiva(Personagem usuario, ArrayList<Monstro> inimigos) {
        int hit = (int)(Math.random()*20)+5+usuario.getForca();
        int acertos = 0;
        for (int i = 0; i<alvos.size(); i++) {
            if (hit>alvos.get(i).getArmadura()) {
                int damage = (int)(Math.random()*16)+4;
                alvos.get(i).setVida((alvos.get(i).getVida())-damage);
                acertos++;
            }
        }
        return acertos;
    }

}