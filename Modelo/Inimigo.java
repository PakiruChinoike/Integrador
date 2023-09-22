import java.util.ArrayList;

public class Inimigo extends Criatura{
    
    private int dificuldade;
    private int ataque;

    public Inimigo(String nome, int dificuldade, int ataque) {
        super(nome);
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
