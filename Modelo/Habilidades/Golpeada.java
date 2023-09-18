import java.lang.Math;

public class Golpeada extends Habilidade{
    
    public Golpeada(){
        super("Golpeada", "Um forte ataque físico.");
    }

    protected boolean habilidadeAtiva(Personagem usuario, Criatura alvo) {
        int hit = (int)(Math.random() * 20) + 1 + usuario.getForca;
            if (hit>alvo.getArmadura) {
                int damage = (int)(Math.random()*8)+1;
                alvo.setVida=(alvo.getVida()-damage);
                return true;
            }
            else {
                return false;
            }
    }

}
