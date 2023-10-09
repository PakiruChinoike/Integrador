import java.util.List;

public class Monstro extends Criatura{
    
    private int id;
    private int dificuldade;

    public Monstro(String nome, int dificuldade, List<Boolean> fraquezas, List<Integer> atributos) {
        super(nome, fraquezas, atributos);
        this.dificuldade = dificuldade;
    }

    public int getId() {
        return id;
    }

    public int getDificuldade() {
        return dificuldade;
    }

}
