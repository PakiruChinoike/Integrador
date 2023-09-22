import java.lang.Math;

public class Golpeada extends Habilidade{
    
    public Golpeada(){
        super(1, "Golpeada", "Um forte ataque físico.");
    }

    protected static int habilidadeAtiva(Personagem usuario, Monstro alvo) {
        int hit = (int)(Math.random() * 20) + 1 + usuario.getForca();
            if (hit>alvo.getArmadura()) {
                int damage = (int)(Math.random()*8)+1;
                alvo.setVida(alvo.getVida()-damage);
                return 1;
            }
            else {
                return 0;
            }
    }

}
