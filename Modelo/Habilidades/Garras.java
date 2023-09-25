import java.lang.Math;

public class Garras extends Habilidade{
    
    public Garras(){
        super(13, "Garras", "Um ataque com garras.");
    }

    protected static int habilidadeAtiva(Monstro usuario, Personagem alvo) {
        int hit = (int)(Math.random() * 20) + 1 + usuario.getAtaque();
            if (hit>alvo.getArmadura()) {
                int damage = (int)(Math.random()*4)+1;
                alvo.setVida(alvo.getVida()-damage);
                return 1;
            }
            else {
                return 0;
            }
    }

}
