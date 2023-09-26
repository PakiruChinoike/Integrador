import java.util.ArrayList;

public class Monstro extends Criatura{
    
    private int dificuldade;
    private int ataque;

    public Monstro(String nome, int dificuldade, int ataque, ArrayList<Boolean> fraquezas) {
        super(nome, fraquezas);
        this.dificuldade = dificuldade;
        this.ataque = ataque;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDificuldade() {
        return dificuldade;
    }

}
