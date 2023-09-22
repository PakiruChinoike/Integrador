import java.util.ArrayList;

public class Inimigos extends Equipe{
    
    private ArrayList<Monstro> monstros;

    public Inimigos(int id, ArrayList<Monstro> monstros) {
        super(id);
        this.monstros = new ArrayList<Monstro>();
        this.monstros.addAll(monstros);
    }

    public Monstro getMonstro(int index) {
        return monstros.get(index);
    }

}
